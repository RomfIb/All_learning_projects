import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalDays;
        int weekEnds;
        boolean isVIP;
        double price;
        boolean isBreakfast;
        double payment;

        System.out.println("Hello!");
        System.out.println("If you want standard room enter 1");
        System.out.println("If you want comfort room enter 2");
        System.out.println("If you want deluxe room enter 3");
        int type = scanner.nextInt();

        switch (type) {
            case 1:
                price = 80;
                break;
            case 2:
                price = 120;
                break;
            case 3:
                price = 180;
                break;
            default:
                System.out.println("Wrong number!");
                return;
        }

        System.out.println("How many days do you want to stay?");
        totalDays = scanner.nextInt();
        if (totalDays <= 0) {
            System.out.println("Wrong number!");
            return;
        }
        else if (totalDays <= 7) {
            System.out.println("How many weekends do you want to stay?");
            weekEnds = scanner.nextInt();
            if (weekEnds < 0) {
                System.out.println("Wrong number!");
                return;
            }
            payment = (price * (totalDays - weekEnds)) + (price * 1.2 * weekEnds);
        }
        else {
            System.out.println("How many weekends you want to stay in the first week?");
            weekEnds = scanner.nextInt();
            if (weekEnds < 0) {
                System.out.println("Wrong number!");
                return;
            }
            System.out.println("How many weekends do you want to stay after first week?");
            int weekEnds2 = scanner.nextInt();
            if (weekEnds2 < 0) {
                System.out.println("Wrong number!");
                return;
            }
            payment = (price * (7 - weekEnds)) + (price * 1.2 * weekEnds);
            payment += 0.8 * ((price * (totalDays - weekEnds2 - 7)) + (price * 1.2 * weekEnds2));
        }

        System.out.println("Do you want breakfast?");
        isBreakfast = scanner.nextBoolean();
        if (isBreakfast)
            payment = payment + 15 * totalDays;

        System.out.println("Are you VIP client?");
        isVIP = scanner.nextBoolean();
        if (isVIP)
            payment = payment - 15 * totalDays;

        System.out.println("Are you older 65?");
        boolean isOld = scanner.nextBoolean();
        if (isOld)
            payment *= 0.95;


        System.out.println("You have to pay " + payment + " AZN");
    }
}