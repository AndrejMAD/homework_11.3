import java.io.File;
import java.util.Formatter;

public class FileUtils {

    public static long calculateFolderSize(String path) {
        long size = 0;

        try {
            File folder = new File(path);
            if (folder.isDirectory()) {
                File[] files = folder.listFiles();
                for (File file : files) {
                    if (file.isDirectory()) {
                        size += calculateFolderSize(file.getPath());
                    } else if (file.isFile()) {
                        size += file.length();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return size;
    }

    public static String bytesToReadableUnit(long size) {
        final String format = "%.1f %s";
        final String UNIT_BYTE = "байт";
        final String UNIT_KB = "Кб";
        final String UNIT_MB = "Мб";
        final String UNIT_GB = "Гб";
        final String UNIT_TB = "Еб";

        if (size < 1024) {
            return String.format(format, (double) size, UNIT_BYTE);
        } else if (size < 1024.0 * 1024.0) {
            return String.format(format, size / 1024.0, UNIT_KB);
        } else if (size < 1024.0 * 1024.0 * 1024.0) {
            return String.format(format, size / (1024.0 * 1024.0), UNIT_MB);
        } else if (size < 1024.0 * 1024.0 * 1024.0 * 1024.0) {
            return String.format(format, size / (1024.0 * 1024.0 * 1024.0), UNIT_GB);
        } else if (size < 1024.0 * 1024.0 * 1024.0 * 1024.0 * 1024.0) {
            return String.format(format, size / (1024.0 * 1024.0 * 1024.0 * 1024.0), UNIT_TB);
        }
        return "Много";
    }
}
