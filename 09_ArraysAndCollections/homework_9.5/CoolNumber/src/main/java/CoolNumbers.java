import java.util.*;

public class CoolNumbers {

    public static List<String> generateCoolNumbers() {
        List<String> coolNumbers = new ArrayList<>();

        char[] chars = {'А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х'};
        int startRegion = 1;
        int endRegion = 199;
        int startNumber = 1;
        int endNumber = 9;

        for (int r = startRegion; r <= endRegion; r++) {
            for (int n = startNumber; n <= endNumber; n++) {
                for (int c1 = 0; c1 < chars.length; c1++) {
                    for (int c2 = 0; c2 < chars.length; c2++) {
                        for (int c3 = 0; c3 < chars.length; c3++) {
                            String coolNumber = chars[c1] + String.valueOf(n) + n + n + chars[c2] + chars[c3] + r;
                            coolNumbers.add(coolNumber);
                        }
                    }
                }
            }
        }

        return coolNumbers;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        for (String n : list) {
            if (n.equals(number)) {
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        int resultSearch = Collections.binarySearch(sortedList, number);
        return (resultSearch != -1) ? true : false;
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        return hashSet.contains(number);
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        return treeSet.contains(number);
    }
}