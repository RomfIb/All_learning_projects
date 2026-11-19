import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileSearchService {

    public List<File> findByExtension(File directory, String extension) {
        List<File> result = new ArrayList<>();
        search(directory, extension, result);
        return result;
    }

    private void search(File file, String extension, List<File> result) {
        if ((file == null) || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            if (file.getName().endsWith(extension)) {
                result.add(file);
            }
            return;
        }
        File[] fileChildren = file.listFiles();
        if (fileChildren == null) {
            return;
        }
        for (File fileChild: fileChildren) {
            search(fileChild, extension, result);
        }
    }
}
