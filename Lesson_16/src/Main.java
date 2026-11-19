import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Applogger logger = new Applogger(Path.of("log.log"));
        logger.log("Application started");
        MyClass myObject = new MyClass();
        myObject.setValue("java");
        String newValue =(String) myObject.getValue();
        myObject.setValue(123);
        //String newValue2 =(String) myObject.getValue();

        GenericClass <String> genericObject = new GenericClass<>();
        genericObject.setValue("java is cool");
        String newValue3 = genericObject.getValue();
        //genericObject.setValue(123);

        //Path<>;
        //Files
        File file = new File("file.txt");
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        try {
            boolean fileCreated = file.createNewFile();
            if (fileCreated) {
                System.out.println("File is created");
            }
            else {
                System.out.println("File is not created");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        File directory = new File("Folder2/Files/Photos");
        boolean createdFolders = directory.mkdirs();

        File directory2 = new File("Folder");
        //boolean createdFolder = directory.mkdir();
        File[] files = directory2.listFiles();//(filee -> filee.getName().endsWith(".txt"));
        if (files != null) {
            for (File f : files) {
                System.out.println(f.getName());
            }
        }
        file.delete();
        try(FileWriter fileWriter = new FileWriter("newFile.txt", StandardCharsets.US_ASCII, true)) {
            fileWriter.write("I love java\nand programming\nand writing");
            fileWriter.write("java 17 is stable");
            fileWriter.write("hello java\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(FileReader fileReader = new FileReader("newFile.txt")) {
            int character;
            while ((character = fileReader.read()) != -1) {
                System.out.print((char)fileReader.read());
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }



        try(FileReader fileReader = new FileReader("newFile.txt", StandardCharsets.US_ASCII)) {
            int character;
            while ((character = fileReader.read()) != -1) {
                System.out.print((char)fileReader.read());
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader("newFile.txt", StandardCharsets.US_ASCII)
        )){
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                System.out.println(string);
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("newFile.txt", StandardCharsets.US_ASCII, true))) {
            bufferedWriter.write("Hello, java");
            bufferedWriter.newLine();
            bufferedWriter.write("Goodbye");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }




        try
                (FileInputStream fileInputStream = new FileInputStream("images.png")) {
            int data;
            while ((data = fileInputStream.read()) != -1) {
                System.out.println(data);
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        byte[] ourData = {65,66,67,68,69,70};
        try
                (FileOutputStream fileOutputStream = new FileOutputStream("newFile.jpg")) {
            fileOutputStream.write(ourData);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (
                FileInputStream fileInputStream = new FileInputStream("images.png");
                FileOutputStream fileOutputStream = new FileOutputStream("images-copy.png")
        )
        {
            int readBytes;
            byte[] buffer = new byte[1024*4];
            while ((readBytes = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0,readBytes);
            }
            System.out.println("File copied");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }


        try (
                Scanner scanner = new Scanner(new File("newFile.txt"))
        ) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        }
        catch (IOException e) {
            throw new RuntimeException();
        }


        Path pathFolder = Path.of("Myfolder", "InnerFolder1", "InnerFolder2");
        try {
            Files.createDirectories(pathFolder);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        Path pathFile = Path.of("Myfolder", "myFile.txt");
        try {
            if (Files.notExists(pathFile)) {
                Files.createFile(pathFile);
            }

            if (Files.exists(pathFile)) {
                Files.writeString(pathFile, "My text is long\n", StandardOpenOption.APPEND);
            }

            List<String> list = List.of("Ali", "Vali", "Pirvali");
            Files.write(pathFile, list, StandardOpenOption.APPEND);
            List<String> readLines = Files.readAllLines(pathFile);
            System.out.println(readLines);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }


        Path target = Path.of("MyFolder", "InnerFolder1", "myFile.txt");
        Path target2 = Path.of("MyFolder", "InnerFolder1","InnerFolder2","myFile.txt");
        try {
            //Files.copy(pathFile, target);
            Files.copy(pathFile, target, StandardCopyOption.REPLACE_EXISTING);
            Files.move(pathFile, target2, StandardCopyOption.REPLACE_EXISTING);
            //Files.move(pathFile, target2);
            //Files.deleteIfExists(pathFile);
            //Files.delete(pathFile);
        } catch (IOException e) {
            System.err.println(e.getStackTrace());
        }

        try (BufferedReader reader = Files.newBufferedReader(pathFile)) {
            String string;
            while((string = reader.readLine()) != null) {
                System.out.println(string);
            }
        }
        catch (IOException e) {
            System.err.println();
        }


        logger.log("Application ended");


        List<Product> products = new ArrayList<>();
        Path productsPath = Path.of("Folder", "Products.csv");
        try {
            List<String> readLines = Files.readAllLines(productsPath);
            for (String product : readLines) {
                String[] productSplitted = product.split(";");
                Product object = new Product(
                        Integer.parseInt(productSplitted[0]),
                        productSplitted[1],
                        Double.parseDouble(productSplitted[2])
                );
                products.add(object);
            }
            System.out.println(products);
        } catch (IOException e) {
            System.err.println();
        }
    }
}