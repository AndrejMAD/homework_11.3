import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();

        while (true) {
            System.out.println("Введите номер, имя или команду:");
            System.out.println("0 - выход из программы");
            System.out.println("LIST - выввести список всех контактов");

            String input = scanner.nextLine();

            if (input.equals("0")) {
                break;
            } else if (input.equals("LIST")) {
                Set<String> allContacts = phoneBook.getAllContacts();
                if (allContacts.isEmpty()) {
                    System.out.println("Список контактов пуст.");
                } else {
                    for (String contact : phoneBook.getAllContacts()) {
                        System.out.println(contact);
                    }
                }
                continue;
            } else {
                String newPhone = phoneBook.validatePhone(input);
                if (!newPhone.isEmpty()) {
                    String contact = phoneBook.getContactByPhone(newPhone);
                    if (contact.isEmpty()) {
                        System.out.println("Такого номера нет в телефонной книге.");
                        System.out.println("Введите имя абонента для номера “" + newPhone + "“:");
                        String newName = scanner.nextLine();
                        phoneBook.addContact(newPhone, newName);
                        System.out.println("Контакт сохранен!");
                    } else {
                        System.out.println(contact);
                    }
                    continue;
                }

                String newName = phoneBook.validateName(input);
                if (!newName.isEmpty()) {
                    Set<String> contact = phoneBook.getContactByName(newName);
                    if (contact.isEmpty()) {
                        System.out.println("Такого имени в телефонной книге нет.");
                        System.out.println("Введите номер телефона для абонента “" + newName + "”:");
                        newPhone = scanner.nextLine();
                        phoneBook.addContact(newPhone, newName);
                        System.out.println("Контакт сохранен!");
                    } else {
                        System.out.println(contact);
                    }
                    continue;
                }
            }
            System.out.println("Неверный формат ввода");
        }
    }
}