import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Map<String, String> appMap = new HashMap<>();
        //Path appPath = Path.of("src", "Config", "app.properties");
//        try {
//            int character;
//            while ((character = fileReader.read()) != -1) {
//                System.out.print((char)fileReader.read());
//            }

//            List<String> lines = Files.readAllLines(appPath);
//            for (String line: lines) {
//                if (!(line == null || line.startsWith("#"))) {
//                    String[] config = line.trim().split("=");
//                    if (config.length == 2) {
//                        appMap.put(config[0], config[1]);
//                    }
//                }
//            }
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(appMap);

        FileSearchService fileSearchService = new FileSearchService();
        List<File> resultList = fileSearchService.findByExtension(new File("Config"), ".doc");
        for (File file: resultList) {
            System.out.println(file.getAbsolutePath());
        }


    }
}