import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;

public class Main {

  public static void main(String[] args) {
    LocalDate javaBirthday = LocalDate.of(1996, 1, 21);
    System.out.println(getPeriodFromBirthday(javaBirthday));
  }

  private static String getPeriodFromBirthday(LocalDate birthday) {
    LocalDate today = LocalDate.now();
    LocalDate period = today.minusYears(birthday.getYear()).minusMonths(birthday.getMonthValue()).minusDays(birthday.getDayOfMonth());

    long years = period.getYear();
    long months = period.getMonthValue();
    long days = period.getDayOfMonth();

    return years + " years, " + months + " months, " + days + " days";
  }

}
