import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;

public class FileUtils {

    public static void copyFolder(String sourceDirectory, String destinationDirectory) {
        try {
            Files.createDirectories(Paths.get(destinationDirectory));
            File sourceDirectoryFile = new File(sourceDirectory);
            File[] files = sourceDirectoryFile.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    copyFolder(sourceDirectory + "/" + file.getName(),
                            destinationDirectory + "/" + file.getName());
                } else if (file.isFile()) {
                    Files.copy(
                            Paths.get(sourceDirectory + "/" + file.getName()),
                            Paths.get(destinationDirectory + "/" + file.getName()),
                            StandardCopyOption.REPLACE_EXISTING);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}