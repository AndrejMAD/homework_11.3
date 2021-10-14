import java.util.*;

public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> coolNumbers = CoolNumbers.generateCoolNumbers();

        while (true) {
            System.out.println("Введите номер автомобильного номера в формате: XNNNYZR");
            System.out.println("где XYZ — различный набор из списка разрешенных букв, N — цифры, R — регион (от 01 до 199)");
            System.out.println("В госномерах автомобилей в РФ используются следующие буквы: А, В, Е, К, М, Н, О, Р, С, Т, У, Х");

            String input = scanner.nextLine();

            if (input.equals("0")) {
                break;
            }
            if (!input.isEmpty()) {
                long start = System.nanoTime();
                boolean isSearch = CoolNumbers.bruteForceSearchInList(coolNumbers, input);
                String isSearchStr = isSearch ? "найден" : "не найден";
                long end = System.nanoTime();
                long time = end - start;
                System.out.println("Поиск перебором: номер " + isSearchStr + ", поиск занял " + time + "нс");

                Collections.sort(coolNumbers);
                start = System.nanoTime();
                isSearch = CoolNumbers.binarySearchInList(coolNumbers, input);
                isSearchStr = isSearch ? "найден" : "не найден";
                end = System.nanoTime();
                time = end - start;
                System.out.println("Бинарный поиск: номер " + isSearchStr + ", поиск занял " + time + "нс");

                HashSet<String> hashSet = new HashSet<>(coolNumbers);
                start = System.nanoTime();
                isSearch = CoolNumbers.searchInHashSet(hashSet, input);
                isSearchStr = isSearch ? "найден" : "не найден";
                end = System.nanoTime();
                time = end - start;
                System.out.println("Поиск в HashSet: номер " + isSearchStr + ", поиск занял " + time + "нс");

                TreeSet<String> treeSet = new TreeSet<>(coolNumbers);
                start = System.nanoTime();
                isSearch = CoolNumbers.searchInTreeSet(treeSet, input);
                isSearchStr = isSearch ? "найден" : "не найден";
                end = System.nanoTime();
                time = end - start;
                System.out.println("БПоиск в TreeSet: номер " + isSearchStr + ", поиск занял " + time + "нс");
            }
            System.out.println();
        }
    }
}
