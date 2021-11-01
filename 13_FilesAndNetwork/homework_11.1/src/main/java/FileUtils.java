import java.io.File;

public class FileUtils {

    public static long calculateFolderSize(String path) {
        try {
            File file = new File(path);

            if (file.isFile()) {
                return file.length();
            }

            long size = 0;
            File[] files = file.listFiles();
            for (File f : files) {
                size += calculateFolderSize(f.getPath());
            }
            return size;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static String bytesToReadableUnit(long size) {
        final String FORMAT = "%.1f%s";
        final double BYTE_ORDINAL = 1024.0;
        final String UNITS = "BKMGT";

        for (int i = 1; i <= 5; i++) {
            if (size < Math.pow(BYTE_ORDINAL, i)) {
                double sizeResult = size / Math.pow(BYTE_ORDINAL, i - 1);
                return String.format(FORMAT, sizeResult, UNITS.charAt(i - 1));
            }
        }

        return "";
    }
}
