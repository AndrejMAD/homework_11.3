import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      //TODO:напишите ваш код тут, результат вывести в консоль.
      //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО
      int indexSpace1 = input.indexOf(' ');
      if (indexSpace1 == -1) {
        System.out.println("Введенная строка не является ФИО");
        break;
      }
      int indexSpace2 = input.indexOf(' ', indexSpace1 + 1);
      if (indexSpace2 == -1) {
        System.out.println("Введенная строка не является ФИО");
        break;
      }

      String surname = input.substring(0, indexSpace1);
      String name = input.substring(indexSpace1 + 1, indexSpace2);
      String middleName = input.substring(indexSpace2 + 1);

      if (!isCyrillicString(surname) || !isCyrillicString(name) || !isCyrillicString(middleName)) {
        System.out.println("Введенная строка не является ФИО");
        break;
      }

      System.out.println("Фамилия: " + surname);
      System.out.println("Имя: " + name);
      System.out.println("Отчество: " + middleName);
    }
  }

  public static boolean isCyrillicString(String text) {
    for (int i = 0; i < text.length(); i++) {
      char c= text.charAt(i);
      if (!((c >= 'а' && c <= 'я') || (c >= 'А' && c <= 'Я') || c == 'ё' || c == 'Ё' || c == '-')) {
        return false;
      }
    }
    return true;
  }
}