import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = scanner.nextLine();
        Movements movements = new Movements(path);
        Map<String, Double> incomeSumGroupByOperation = movements.getIncomeSumGroupByOperation();
        incomeSumGroupByOperation.forEach((k, v) -> System.out.println(k + " = " + v));
    }
}
