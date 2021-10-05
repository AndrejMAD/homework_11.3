public class FindCharRu {
    public static void main(String[] args) {
        for (int i = 0; i <= 65536; i++) {
            if ((i >= (int) 'а' && i <= (int) 'я') || (i >= (int) 'А' && i <= (int) 'Я') || (char) i == 'Ё' || (char) i == 'ё') {
                System.out.println("code = " + i + ", char = " + (char) i);
            }
        }
    }
}
