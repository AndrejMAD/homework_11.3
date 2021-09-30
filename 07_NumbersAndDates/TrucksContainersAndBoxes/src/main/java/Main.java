import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int boxes = scanner.nextInt();
        int containers = 0;
        int trucks = 0;

        String ls = System.lineSeparator();

        for (int b = 0; b < boxes;) {
            if (b % (12 * 27) == 0) {
                trucks++;
                System.out.print("Грузовик: " + trucks + ls);
            }
            if (b % 27 == 0) {
                containers++;
                System.out.print("\tКонтейнер: " + containers + ls);
            }
            b++;
            System.out.print("\t\tЯщик: " + b + ls);
        }

        System.out.print("Необходимо:" + ls);
        System.out.print("грузовиков - " + trucks + " шт." + ls);
        System.out.print("контейнеров - " + containers + " шт." + ls);

        // TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
        // пример вывода при вводе 2
        // для отступа используйте табуляцию - \t

        /*
        Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт.
        */
    }

}
