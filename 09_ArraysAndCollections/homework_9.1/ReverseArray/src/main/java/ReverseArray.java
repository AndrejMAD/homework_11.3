public class ReverseArray {

    //TODO: Напишите код, который меняет порядок расположения элементов внутри массива на обратный.
    public static String[] reverse (String[] strings){
        int length = strings.length;
        int middle = length / 2;

        for (int i = 0; i < middle; i++) {
            String left = strings[i];
            String right = strings[length - i - 1];
            strings[i] = right;
            strings[length - i - 1] = left;
        }

        return strings;
    }
}
