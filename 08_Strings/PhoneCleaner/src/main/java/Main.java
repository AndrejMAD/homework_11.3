import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }

      String formatTelephoneNumber = formatTelephoneNumber(input);

      if (formatTelephoneNumber.isEmpty()) {
        System.out.println("Неверный формат номера");
      } else {
        System.out.println(formatTelephoneNumber(input));
      }
    }
  }

  public static String formatTelephoneNumber(String number) {
    String regex = "[^0-9]";
    String formatNumber = number.replaceAll(regex, "");

    // Если number не содержит чисел
    if (formatNumber.isEmpty()) {
      return "";
    }
    if (formatNumber.charAt(0) == '8') {
      formatNumber = "7" + formatNumber.substring(1, formatNumber.length());
    }
    if (formatNumber.length() == 10) {
      formatNumber = "7" + formatNumber;
    }
    if (formatNumber.length() != 11 || formatNumber.charAt(0) != '7') {
      formatNumber = "";
    }

    return formatNumber;
  }
}
