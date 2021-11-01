import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FolderSizeCalculator extends RecursiveTask<Long> {

    private File file;

    public FolderSizeCalculator(File folder) {
        this.file = folder;
    }

    @Override
    protected Long compute() {
        if (file.isFile()) {
            return  file.length();
        }

        long size = 0;

        List<FolderSizeCalculator> subTasks = new LinkedList<>();
        File[] files = file.listFiles();
        for (File f : files) {
            FolderSizeCalculator task = new FolderSizeCalculator(f);
            task.fork();
            subTasks.add(task);
        }
        for (FolderSizeCalculator task : subTasks) {
            size = task.join();
        }

        return size;
    }
}