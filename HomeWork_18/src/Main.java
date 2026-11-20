import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;
import java.util.concurrent.ScheduledExecutorService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Path currentPath = Paths.get("...").toAbsolutePath();

        while (true) {
            System.out.println("Current directory: " + currentPath);
            System.out.println("Choose option: ");
            System.out.println("1. Copy current directory");
            System.out.println("2. Delete current directory");
            System.out.println("3. Move current directory");
            System.out.println("4. Rename current directory");
            System.out.println("5. Change to parent directory");
            System.out.println("0. Exit");

            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("0")) {
                System.out.println("Exiting...");
                break;
            }

            try {
                switch (choice) {
                    case "1":
                        System.out.println("Enter new copy folder's name");
                        String copyName = scanner.nextLine();
                        Path targetCopy = currentPath.getParent().resolve(copyName);
                        Files.copy(currentPath, targetCopy, StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("Copied in " + targetCopy);
                        break;

                    case "2":
                        System.out.println("Are you sure you want to delete?");
                        String confirm = scanner.nextLine();
                        if (confirm.equalsIgnoreCase("yes")) {
                            Files.delete(currentPath);
                            System.out.println("Directory is deleted");
                        }
                        else {
                            System.out.println("Cancelled");
                        }
                        break;

                    case "3":
                        System.out.println("Enter where you want to move");
                        String moveName = scanner.nextLine();
                        Path targetMove = Paths.get(moveName).resolve(currentPath.getFileName());
                        Files.move(currentPath, targetMove, StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("Moved to " + targetMove);
                        break;

                    case "4":
                        System.out.println("Enter new name: ");
                        String newName = scanner.nextLine();
                        Path targetRename = currentPath.getParent().resolve(newName);
                        Files.move(currentPath, targetRename, StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("Renamed to " + targetRename.getFileName());
                        break;

                    case "5":
                        Path parentPath = currentPath.getParent();
                        if (parentPath != null) {
                            currentPath = parentPath;
                            System.out.println("Directory changed to " + parentPath);
                        }
                        else {
                            System.out.println("You are in root directory");
                        }
                        break;

                    default:
                        System.out.println("Wrong choice");
                        break;
                }
            }
            catch (IOException e) {
                System.err.println(e.getStackTrace());
            }
        }
    }
}