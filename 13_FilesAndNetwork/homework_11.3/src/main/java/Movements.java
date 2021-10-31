import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Movements {

    private final String pathMovementsCsv;
    private final List<MovementsItem> items;

    public Movements(String pathMovementsCsv) {
        this.pathMovementsCsv = pathMovementsCsv;
        this.items = new ArrayList<>();
    }

    public double getExpenseSum() {
        parse();
        double expenseSum = items.stream().mapToDouble(MovementsItem::getExpense).sum();
        return expenseSum;
    }

    public double getIncomeSum() {
        parse();
        double incomeSum = items.stream().mapToDouble(MovementsItem::getIncome).sum();
        return incomeSum;
    }

    // Key - operation
    // Value - income sum
    public Map<String, Double> getIncomeSumGroupByOperation() {
        parse();

        Map<String, Double> result = new TreeMap<>();
        Set<String> operations = new TreeSet<>();

        items.forEach(i -> operations.add(i.getOrganization()));

        for (String operation : operations) {
            double expenseSum = items.stream()
                    .filter(i -> i.getOrganization().equals(operation))
                    .mapToDouble(MovementsItem::getExpense).sum();
            result.put(operation, expenseSum);
        }

        return result;
    }

    public void parse() {
        if (!items.isEmpty()) {
            return;
        }
        try {
            List<String> strings = Files.readAllLines(Paths.get(pathMovementsCsv));
            for (int i = 1; i < strings.size(); i++) {
                String str = strings.get(i);
                str = formatString(str);
                String[] values = str.split(",");
                try {
                    MovementsItem item = new MovementsItem(
                            Double.parseDouble(values[6]),
                            Double.parseDouble(values[7]),
                            parseOrganization(values[5]));
                    items.add(item);
                } catch (NumberFormatException ex) {

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String parseOrganization(String operationDescription) {
        int start = 0;
        int end = 0;

        String regex = "[0-9]{6}[+]{6}[0-9]{4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(operationDescription);
        while (matcher.find()) {
            start = matcher.end();
        }

        regex = "[0-9]{2}.[0-9]{2}.[0-9]{2}";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(operationDescription);
        while (matcher.find()) {
            end = matcher.start();
            break;
        }

        String organization = operationDescription.substring(start, end).trim();

        return organization;
    }

    private String formatString(String str) {
        String regex = "\"[0-9]+,[0-9]+\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String subStr = str.substring(start, end);
            String newSubStr = subStr.replace(',', '.');
            newSubStr = newSubStr.replaceAll("\"", "");
            str = str.replaceAll(subStr, newSubStr);
        }

        return str;
    }
}