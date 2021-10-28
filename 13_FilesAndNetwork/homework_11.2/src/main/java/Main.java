import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите путь к копируемой папке:");
        String sourceDirectory = scanner.nextLine();
        System.out.println("Введите путь к папке в которую копируем:");
        String destinationDirectory = scanner.nextLine();

        FileUtils.copyFolder(sourceDirectory, destinationDirectory);
    }
}
