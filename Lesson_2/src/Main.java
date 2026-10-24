import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner variableGettingDataFromConsole = new Scanner(System.in);
//        //Teacher t = new Teacher();
//        //String name = variableGettingDataFromConsole.nextLine();
//        //System.out.println("Hello, " + name);
//        //int width = variableGettingDataFromConsole.nextInt();
//        int lengh = variableGettingDataFromConsole.nextInt();
//        variableGettingDataFromConsole.nextLine();
//        System.out.println("Square = " + (width * lengh));
//        double salary = 0.0;
//        //salary = variableGettingDataFromConsole.nextDouble();
//        //System.out.println(salary);
//
//        System.out.print("Enter age: ");
//        int age = variableGettingDataFromConsole.nextInt();
//        if (age < 12) {
//            System.out.println("You are child!");
//        }
//        else if (age < 15) {
//            System.out.println("You are teenager");
//        }
//        else if (age < 40)
//            System.out.println("You are young");
//        else {
//            System.out.println("You are old!");
//        }
//        if ((age >= 15) && (age < 40)) {
//            System.out.println("You are young!");
//        }
//        else if ((age < 15) && (age >= 12)) {
//            System.out.println("You are teenager");
//        }
//        else if (age < 12)
//            System.out.println("You are child");
//        else {
//            System.out.println("You are old!");
//        }
//        boolean hasDrivingLicence = false;
//        boolean hasDocumentID = false;
//        if (hasDrivingLicence || hasDocumentID)
//            System.out.println("You can enter");
//        else
//            System.out.println("You cannot enter");
//        boolean passwordIsCorrect = false;
//        if (!passwordIsCorrect)
//            System.out.println("You can log in");
//        if (passwordIsCorrect == true)
//            System.out.println("You can log in");
//        if (passwordIsCorrect != true)
//            System.out.println("You cannot log in");
//        String originalPassword = "12345678";
//        String password = variableGettingDataFromConsole.nextLine();
//        if (password.equals(originalPassword))
//            System.out.println("You can log in");
//
        System.out.println("Enter first value: ");
        double value1 = variableGettingDataFromConsole.nextDouble();
        System.out.println("Enter second value: ");
        double value2 = variableGettingDataFromConsole.nextDouble();
        System.out.println("Choose operation: ");
        char operation = variableGettingDataFromConsole.next().charAt(0);
        if (operation == '+')
            System.out.println(value1 + value2);
        else if (operation == '-')
            System.out.println(value1 - value2);
        else if (operation == '*')
            System.out.println(value1 * value2);
        else {
            if (value2 != 0)
                System.out.println(String.format("%.2f", value1 / value2));
            else
                System.out.println("Second value cannot be null");
        }
//        System.out.println("Enter number of month: ");
//        int number = variableGettingDataFromConsole.nextInt();
//        switch (number) {
//            case 1:
//                System.out.println("January");
//                break;
//            case 2:
//                System.out.println("February");
//                break;
//            case 3:
//                System.out.println("March");
//                break;
//            case 4:
//                System.out.println("April");
//                break;
//            case 5:
//                System.out.println("May");
//                break;
//            case 6:
//                System.out.println("June");
//                break;
//            case 7:
//                System.out.println("July");
//                break;
//            case 8:
//                System.out.println("August");
//                break;
//            case 9:
//                System.out.println("September");
//                break;
//            case 10:
//                System.out.println("October");
//                break;
//            case 11:
//                System.out.println("November");
//                break;
//            case 12:
//                System.out.println("December");
//                break;
//            default:
//                System.out.println("Wrong number");
//        }
//        int number = variableGettingDataFromConsole.nextInt();
//        System.out.println("Enter number: ");
//        if (number < 0)
//            System.out.println("Number is negative");
//        else if (number > 0)
//            System.out.println("Number is positive");
//        else
//            System.out.println("Number is 0");
//
//        System.out.println("Enter your values: ");
//        int value1 = variableGettingDataFromConsole.nextInt();
//        int value2 = variableGettingDataFromConsole.nextInt();
//        int value3 = variableGettingDataFromConsole.nextInt();
//        int max = value1;
//        if (value2 > max)
//            max = value2;
//        if (value3 > max)
//            max = value3;
//        System.out.println(max);
//
//        int a = 5;
//        int b = 8;
//        int c = a;
//        a = b;
//        b = c;
//        System.out.println(a);
//        System.out.println(b);

        System.out.println("Enter month number: ");
        int month = variableGettingDataFromConsole.nextInt();
        switch (month) {
            case 1:
            case 2:
            case 12:
                System.out.println("winter");
            case 3:
            case 4:
            case 5:
                System.out.println("spring");
            case 6:
            case 7:
            case 8:
                System.out.println("summer");
            case 9:
            case 10:
            case 11:
                System.out.println("autumn");
            default:
                System.out.println("wrong number");
        }
    }
}