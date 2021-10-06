public class Main {

  public static void main(String[] args) {
    System.out.println(splitTextIntoWords("aaaa bbbb,cccc100dddd.eeee666HHH"));
  }

  public static String splitTextIntoWords(String text) {
    String splitRegex = "[^a-zA-Z’]+";
    String[] words = text.split(splitRegex);

    String strWords = "";
    for (int i = 0; i < words.length; i ++) {
      strWords = strWords.concat(words[i]);
      if (i < words.length - 1) {
        strWords = strWords.concat("\n");
      }
    }

    return strWords;
  }
}