public class Main {

  public static void main(String[] args) {
    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
    System.out.println(getSumm(text));
  }

  public static int getSumm(String text) {
    int summ = 0;
    String rub = " руб";

    int end = text.indexOf(rub);
    int start = text.lastIndexOf(' ', end - 1);
    String strNumber = text.substring(start, end).trim();
    summ += Integer.valueOf(strNumber);
    //System.out.println(start + ", " + end + ", " + strNumber);

    end = text.indexOf(rub, end + rub.length());
    start = text.lastIndexOf(' ', end - 1);
    strNumber = text.substring(start, end).trim();
    summ += Integer.valueOf(strNumber);
    //System.out.println(start + ", " + end + ", " + strNumber);

    end = text.indexOf(rub, end + rub.length());
    start = text.lastIndexOf(' ', end - 1);
    strNumber = text.substring(start, end).trim();
    summ += Integer.valueOf(strNumber);
    //System.out.println(start + ", " + end + ", " + strNumber);

    return summ;
  }
}