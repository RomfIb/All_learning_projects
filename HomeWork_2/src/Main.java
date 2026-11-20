import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner variableGettingDataFromConsole = new Scanner(System.in);

//        System.out.println("Enter your values: ");
//        int value1 = variableGettingDataFromConsole.nextInt();
//        int value2 = variableGettingDataFromConsole.nextInt();
//        int value3 = variableGettingDataFromConsole.nextInt();
//        int value4 = variableGettingDataFromConsole.nextInt();
//        int value5 = variableGettingDataFromConsole.nextInt();
//        int min = value1;
//        if (value2 < min)
//            min = value2;
//        if (value3 < min)
//            min = value3;
//        if (value4 < min)
//            min = value4;
//        if (value5 < min)
//            min = value5;
//        System.out.println("Minimum value is " + min);
//
//        double leg1 = 5;
//        double hypotenuse = 0;
//        //int leg2;
//        double angle1 = 30;
//        if (angle1 == 30)
//            hypotenuse = 2 * leg1;
//       double leg2 = Math.sqrt((hypotenuse * hypotenuse) - (leg1 * leg1));
//        System.out.println("Hypotenuse equals " + hypotenuse + " and leg2 equals " + leg2);
//
//        System.out.println("Enter coefficients of a quadratic equation: ");
//        double a = variableGettingDataFromConsole.nextDouble();
//        double b = variableGettingDataFromConsole.nextDouble();
//        double c = variableGettingDataFromConsole.nextDouble();
//        double D = (b * b) - (4 * a * c);
//        if (D < 0)
//            System.out.println("Your equation does not have real roots");
//        else if (D == 0) {
//            double x1 = ((-b) / (2 * a));
//            System.out.println("Your equation has one root equals " + x1);
//        }
//        else {
//            double x1 = ((-b) + Math.sqrt(D)) / (2 * a);
//            double x2 = ((-b) - Math.sqrt(D)) / (2 * a);
//            System.out.println("Your equation roots are " + x1 + " and " + x2);
//        }
//
//        System.out.println("Enter your year: ");
//        int year = variableGettingDataFromConsole.nextInt();
//        if ((year % 4) != 0)
//            System.out.println("Year is not leap");
//        else if ((year % 100) == 0) {
//            if ((year % 400) == 0)
//                System.out.println("Year is leap");
//            else
//                System.out.println("Year is not leap");
//        }
//        else
//            System.out.println("Year is leap");

//        System.out.println("Enter your number: ");
//        int day = variableGettingDataFromConsole.nextInt();
//        switch (day) {
//            case 1:
//                System.out.println("Monday");
//                break;
//            case 2:
//                System.out.println("Tuesday");
//                break;
//            case 3:
//                System.out.println("Wednesday");
//                break;
//            case 4:
//                System.out.println("Thursday");
//                break;
//            case 5:
//                System.out.println("Friday");
//                break;
//            case 6:
//                System.out.println("Saturday");
//                break;
//            case 7:
//                System.out.println("Sunday");
//                break;
//            default:
//                System.out.println("Wrong number");


//        System.out.println("Enter your month: ");
//        int month = variableGettingDataFromConsole.nextInt();
//        System.out.println("Enter your day: ");
//        int day = variableGettingDataFromConsole.nextInt();
//        switch (month) {
//            case 1:
//                if ((day >= 1) && (day <= 21))
//                    System.out.println("Your zodiac sign is capricorn");
//                else if (day <= 31)
//                    System.out.println("Your zodiac sign is aquarius");
//                else
//                    System.out.println("Wrong day");
//                break;
//            case 2:
//                if ((day >= 1) && (day <= 21))
//                    System.out.println("Your zodiac sign is aquarius");
//                else if (day <= 29)
//                    System.out.println("Your zodiac sign is pisces");
//                else
//                    System.out.println("Wrong day");
//                break;
//            case 3:
//                if ((day >= 1) && (day <= 21))
//                    System.out.println("Your zodiac sign is pisces");
//                else if (day <= 31)
//                    System.out.println("Your zodiac sign is aries");
//                else
//                    System.out.println("Wrong day");
//                break;
//            case 4:
//                if ((day >= 1) && (day <= 21))
//                    System.out.println("Your zodiac sign is aries");
//                else if (day <= 30)
//                    System.out.println("Your zodiac sign is taurus");
//                else
//                    System.out.println("Wrong day");
//                break;
//            case 5:
//                if ((day >= 1) && (day <= 21))
//                    System.out.println("Your zodiac sign is taurus");
//                else if (day <= 31)
//                    System.out.println("Your zodiac sign is gemini");
//                else
//                    System.out.println("Wrong day");
//                break;
//            case 6:
//                if ((day >= 1) && (day <= 21))
//                    System.out.println("Your zodiac sign is gemini");
//                else if (day <= 30)
//                    System.out.println("Your zodiac sign is cancer");
//                else
//                    System.out.println("Wrong day");
//                break;
//            case 7:
//                if ((day >= 1) && (day <= 21))
//                    System.out.println("Your zodiac sign is cancer");
//                else if (day <= 31)
//                    System.out.println("Your zodiac sign is leo");
//                else
//                    System.out.println("Wrong day");
//                break;
//            case 8:
//                if ((day >= 1) && (day <= 21))
//                    System.out.println("Your zodiac sign is leo");
//                else if (day <= 31)
//                    System.out.println("Your zodiac sign is virgo");
//                else
//                    System.out.println("Wrong day");
//                break;
//            case 9:
//                if ((day >= 1) && (day <= 21))
//                    System.out.println("Your zodiac sign is virgo");
//                else if (day <= 30)
//                    System.out.println("Your zodiac sign is libra");
//                else
//                    System.out.println("Wrong day");
//                break;
//            case 10:
//                if ((day >= 1) && (day <= 21))
//                    System.out.println("Your zodiac sign is libra");
//                else if (day <= 31)
//                    System.out.println("Your zodiac sign is scorpio");
//                else
//                    System.out.println("Wrong day");
//                break;
//            case 11:
//                if ((day >= 1) && (day <= 21))
//                    System.out.println("Your zodiac sign is scorpio");
//                else if (day <= 30)
//                    System.out.println("Your zodiac sign is sagittarius");
//                else
//                    System.out.println("Wrong day");
//                break;
//            case 12:
//                if ((day >= 1) && (day <= 21))
//                    System.out.println("Your zodiac sign is sagittarius");
//                else if (day <= 31)
//                    System.out.println("Your zodiac sign is capricorn");
//                else
//                    System.out.println("Wrong day");
//                break;
//            default:
//                System.out.println("Wrong month");
//        }
//
//
//
//
//        System.out.println("Enter First Name, Last name, height and tell is person a student: ");
//        String studentFirstName = variableGettingDataFromConsole.nextLine();
//        String studentLastName = variableGettingDataFromConsole.nextLine();
//        int studentAge = variableGettingDataFromConsole.nextInt();
//        double studentHeight = variableGettingDataFromConsole.nextDouble();
//        boolean isStudent = variableGettingDataFromConsole.nextBoolean();
//        System.out.println("His name is " + studentFirstName + " " + studentLastName);
//        System.out.println("He is " + studentAge + " years old");
//        System.out.println("He is " + studentHeight + " meters tall");
//        if (isStudent == true)
//            System.out.println("He is  a student");
//        else
//            System.out.println("He is not a student");
//
//
//        System.out.println("Enter height and width of rectangle: ");
//        double rectangleHeight = variableGettingDataFromConsole.nextDouble();
//        double rectangleWidth = variableGettingDataFromConsole.nextDouble();
//        double rectangleSquare = rectangleHeight * rectangleWidth;
//        double rectanglePerimeter = 2 * (rectangleWidth + rectangleHeight);
//        System.out.print("The perimeter of a rectangle is " + rectanglePerimeter);
//        System.out.println(" and the square is " + rectangleSquare);
//
//        System.out.println("Enter hours and minutes: ");
//        int hours1 = variableGettingDataFromConsole.nextInt();
//        int minutes1 = variableGettingDataFromConsole.nextInt();
//        int totalMin1 = hours1 * 60 + minutes1;
//        System.out.println(hours1 + " and " + minutes1 + " is " + totalMin1 + " minutes");
//
//        System.out.println("Enter minutes: ");
//        int totalMin2 = variableGettingDataFromConsole.nextInt();
//        int hours2 = totalMin2 / 60;
//        int minutes2 = totalMin2 % 60;
//        System.out.println(totalMin2 + " is " + hours2 + " hours and " + minutes2 + " minutes");
//
//
//        System.out.println("Enter price: ");
//        double priceOfGoods = variableGettingDataFromConsole.nextDouble();
//        System.out.println("Enter discout: ");
//        int discount = variableGettingDataFromConsole.nextInt();
//        double newPrice = priceOfGoods - (priceOfGoods * discount / 100);
//        System.out.println("The discount price of goods is " + newPrice + " AZN");
//
//
//
//        System.out.println("Enter your First name: ");
//        String firstName = variableGettingDataFromConsole.nextLine();
//        System.out.println("Enter your Last name: ");
//        String lastName = variableGettingDataFromConsole.nextLine();
//        System.out.println("Enter your age: ");
//        int age = variableGettingDataFromConsole.nextInt();
//        double balance = 0;
//        System.out.println("If you want deposit enter 1, ");
//        System.out.println("If you want get balance info enter 2, ");
//        System.out.println("If you want withdraw enter 3, ");
//        int option = variableGettingDataFromConsole.nextInt();
//        switch (option) {
//            case 1:
//                System.out.println("How much money do you want to deposit? ");
//                double deposit = variableGettingDataFromConsole.nextDouble();
//                balance += deposit;
//                break;
//            case 2:
//                if (balance == 0)
//                    break;
//                System.out.println("Your balance is " + balance);
//            case 3:
//                System.out.println("How much money do you want to withdraw? ");
//                double withdraw = variableGettingDataFromConsole.nextDouble();
//                if (balance >= withdraw)
//                    balance -= withdraw;
//                else
//                    System.out.println("You do not have enough money!");
//                break;
//            default:
//                System.out.println("Wrong number");
//        }
//        System.out.println(balance);
    }
}