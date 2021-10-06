import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }

      boolean isErrorStr = false;
      String errorInfo = "Введенная строка не является ФИО";
      String splitRegex = "\\s";
      String cyrillicRegex = "[а-яА-Я-]+";
      String[] words = input.split(splitRegex);

      if (words.length != 3) {
        System.out.println(errorInfo);
        break;
      }

      for (int i = 0; i < words.length; i++) {
        if (!words[i].matches(cyrillicRegex)) {
          System.out.println(errorInfo);
          isErrorStr = true;
          break;
        }
      }

      if (isErrorStr) {
        break;
      }

      System.out.println("Фамилия: " + words[0]);
      System.out.println("Имя: " + words[1]);
      System.out.println("Отчество: " + words[2]);
    }
  }
}