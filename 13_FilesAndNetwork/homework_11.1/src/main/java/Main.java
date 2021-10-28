import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите путь до папки или 0 для выхода:");
            String cmd = scanner.nextLine();
            if (cmd.equals("0")) {
                break;
            }
            long folderSize = FileUtils.calculateFolderSize(cmd);
            System.out.println("Размер папки " + cmd + " cоставляет " + FileUtils.bytesToReadableUnit(folderSize));
        }
    }
}