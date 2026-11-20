import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner();

        //File file = new File("file.txt");
        try(FileWriter fileWriter = new FileWriter("file.txt")) {
//            for (int i = 0; i < 100; i++) {
//                fileWriter.write(i);
//            }
            fileWriter.write("35 ");
            fileWriter.write("-6 ");
            fileWriter.write("17 ");
            fileWriter.write("15 ");
            fileWriter.write("39 ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int sum = 0;
        try (
                Scanner scanner = new Scanner(new File("file.txt"))
        ) {
            while (scanner.hasNext()) {
                sum += scanner.nextInt();
            }
            System.out.println("Sum of file numbers: " + sum);
        }
        catch (IOException e) {
            throw new RuntimeException();
        }

        try(FileWriter fileWriter = new FileWriter("students.txt")) {
            fileWriter.write("Ali, 20, 4 5 5\n");
            fileWriter.write("Vali, 21, 4 4 5\n");
            fileWriter.write("Pirvali, 19, 4 4 4\n");
        }
        catch (IOException e) {
            throw new RuntimeException();
        }

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] studentData = line.split(",");
                System.out.println("------------------");
                System.out.println("Name of student: " + studentData[0]);
                System.out.println("Age of student: " + studentData[1]);
                System.out.println("Grades of student: " + studentData[2]);
                System.out.println("------------------");
            }
        }
        catch (IOException e) {
            throw new RuntimeException();
        }
    }
}