import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("----Subscribe system---- ");
            LocalDate purchaseDate = LocalDate.now();
            System.out.println("Hello!    Purchase date: " + purchaseDate);
            System.out.println("Enter 1 for 30 day subscribe");
            System.out.println("Enter 2 for 1 year subscribe");
            System.out.println("Enter your choice: ");

            int choice = scanner.nextInt();
            if (choice != 1 && choice != 2) {
                throw new IllegalArgumentException("Wrong choice, choose 1 or 2");
            }

            int days = (choice == 2) ? 365 : 30;

            LocalDate expirationDate = purchaseDate.plusDays(days);
            LocalDate warningDate = expirationDate.minusDays(3);

            System.out.println("Your subscription is active till " + expirationDate);

            System.out.println("---Checking subscription---");
            System.out.println("How many days passed after purchase?");

            int daysPassed = scanner.nextInt();

            if (daysPassed < 0)
                throw new IllegalArgumentException("Days cannot be negative");

            LocalDate checkDate = purchaseDate.plusDays(daysPassed);
            System.out.println("Date of checking subscription " + checkDate);

            if (checkDate.isAfter(expirationDate) || checkDate.isEqual(expirationDate)) {
                System.out.println("Your subscription is over");
            }
            else if (checkDate.isAfter(warningDate) || checkDate.isEqual(warningDate)) {
                System.out.println("Warning! Your subscription is ending for 3 or less days");
            }
            else {
                System.out.println("Subscription is active");
            }
        }
        catch (IllegalArgumentException e) {
            System.err.println("Wrong input!");
        }
    }
}