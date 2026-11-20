import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;
import Enum.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Applogger logger = new Applogger(Path.of("log.log"));
        logger.log(LogInfo.INFO,"Application started");
        Path textPath = Path.of("Folder");
        try {
            Files.createDirectories(textPath);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        Path textFile = Path.of("Folder", "text.txt");

        try {
            if (Files.notExists(textFile)) {
                Files.createFile(textFile);
            }

            if (Files.exists(textFile)) {
                Files.writeString(textFile, "My text is long\n");
            }
            List<String> list = List.of(
                    "I love java 17",
                    "Ali loves java 8",
                    "Vali loves java 21",
                    "Pirvali loves java 14");
            Files.write(textFile, list, StandardOpenOption.APPEND);
        }
        catch (IOException e) {
            System.err.println(e.getStackTrace());
        }

        try (BufferedReader reader = Files.newBufferedReader(textFile)) {
            String line;
            Integer lineCount = 0;
            Integer wordCount = 0;
            Integer charCount = 0;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                charCount += line.length();
                line.trim();
                if (!line.isEmpty()) {
                    String[] words = line.split(" ");
                    wordCount += words.length;
                }
            }
            System.out.println("Lines count = " + lineCount);
            System.out.println("Words count = " + wordCount);
            System.out.println("Characters count = " + charCount);
        }
        catch (IOException e) {
            System.err.println(e.getStackTrace());
        }

        if (Files.notExists(ContactBook.contactsFile)) {
            try {
                Files.writeString(ContactBook.contactsFile, "First name, Last name, Country code, Number\n");
            }
            catch (IOException e) {
                System.err.println(e.getStackTrace());
            }
        }
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("====Contacts menu=====");
            System.out.println("----Choose option----");
            System.out.println("1. Add contact");
            System.out.println("2. Print all contacts");
            System.out.println("3. Find contact by number");
            System.out.println("4. Find contact by name");
            System.out.println("5. Exit");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addContact(scanner);
                case "2" -> printAllContacts();
                case "3" -> findPhoneByNumber(scanner);
                case "4" -> findPhoneByName(scanner);
                case "5" -> {
                    System.out.println("Exiting...");
                    logger.log(LogInfo.INFO,"Application ended");
                    return;
                }
                default -> System.out.println("Wrong choice, try again");
            }
        }

    }

    public static void addContact(Scanner scanner) {
        System.out.println("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter country code: ");
        String countryCode = scanner.nextLine();
        System.out.println("Enter number ");
        String phoneNumber = scanner.nextLine();

        String csvLine = firstName + "," + lastName + "," + countryCode + "," + phoneNumber + "\n";

        try {
            Files.writeString(ContactBook.contactsFile, csvLine, StandardOpenOption.APPEND);
            System.out.println("Contact is added");
        } catch (IOException e) {
            System.err.println(e.getStackTrace());
        }
    }

    public static void printAllContacts() {
        try {
            List<String> lines = Files.readAllLines(ContactBook.contactsFile);
            System.out.println("----All contacts list----");
            for (int i = 1; i <= lines.size() - 1; i++) {
                System.out.println(lines.get(i));
            }
        } catch (IOException e) {
            System.err.println(e.getStackTrace());
        }
    }

    public static void findPhoneByNumber(Scanner scanner) {
        System.out.println("Enter number: ");
        String searchContact = scanner.nextLine();

        try {
            List<String> lines = Files.readAllLines(ContactBook.contactsFile);
            boolean found = false;
            for (int i = 1; i <= lines.size() - 1; i++) {
                String[] parts = lines.get(i).split(",");
                String fullNumber = parts[2] + parts[3];
                if (fullNumber.contains(searchContact) || parts[3].equalsIgnoreCase(searchContact)) {
                    System.out.println("Found contact: " + lines.get(i));
                    found = true;
                }
            }
            if (!found)
                System.out.println("Contact is not found");
        } catch (IOException e) {
            System.err.println(e.getStackTrace());
        }
    }

    public static void findPhoneByName(Scanner scanner) {
        System.out.println("Enter name: ");
        String searchContact = scanner.nextLine();

        try {
            List<String> lines = Files.readAllLines(ContactBook.contactsFile);
            boolean found = false;
            for (int i = 1; i <= lines.size() - 1; i++) {
                String[] parts = lines.get(i).split(",");
                if (parts[0].equalsIgnoreCase(searchContact) || parts[1].equalsIgnoreCase(searchContact)) {
                    System.out.println("Found contact: " + lines.get(i));
                    found = true;
                }
            }
            if (!found)
                System.out.println("Contact is not found");
        } catch (IOException e) {
            System.err.println(e.getStackTrace());
        }
    }

}