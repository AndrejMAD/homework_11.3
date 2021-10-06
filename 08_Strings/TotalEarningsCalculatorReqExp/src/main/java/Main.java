import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {
    System.out.println(calculateSalarySum("dsdsd 4000, dsd dsds 5000 dsd  6000"));
  }

  public static int calculateSalarySum(String text){
    int sum = 0;

    String regex = "[0-9]+";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(text);

    while (matcher.find()) {
      int start = matcher.start();
      int end = matcher.end();
      int number = Integer.valueOf(text.substring(start, end));
      sum += number;
    }

    return sum;
  }
}