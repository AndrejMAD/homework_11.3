import java.util.List;
import java.util.Scanner;

public class Main {

    private static final EmailList emailList = new EmailList();
    
    /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@skillbox.ru == HeLLO@SKILLbox.RU
        - вывод на печать должен быть в нижнем регистре
           hello@skillbox.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
    */

    public static void main(String[] args) {
        String split = "\\s";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите команду: LIST, ADD");
        while (true) {
            String input = scanner.nextLine();
            String[] commands = input.split(split);

            if (input.equals("0")) {
                break;
            }
            
            //TODO: write code here
            if (commands[0].equals("LIST")) {
                List<String> emails =  emailList.getSortedEmails();

                if (emails.isEmpty()) {
                    System.out.println("Список пустой");
                }
                for (String email : emails) {
                    System.out.println(email);
                }
                continue;
            }
            if (commands[0].equals("ADD")) {
                if (commands.length < 2) {
                    System.out.println("Введите команду в формате: ADD \"email\"");
                    continue;
                }

                int start = input.indexOf(commands[0]) + commands[0].length();
                String email = input.substring(start).trim();

                emailList.add(email);
                continue;
            }
            System.out.println("Введите команду: LIST, ADD");
        }
    }
}