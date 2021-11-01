import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите путь к папке:");

        String path = scanner.nextLine();
        FolderSizeCalculator calculator = new FolderSizeCalculator(new File(path));
        ForkJoinPool pool = new ForkJoinPool();
        long folderSize = pool.invoke(calculator);

        System.out.println(folderSize);
    }
}
