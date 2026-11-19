import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        стандат 10 манат скидки до 7 лет беспл с 7 до 17 30% скидка с 18 до 64 без скидки 65+  40% скиндка студ ски
//        студент 10%. выходные 20% дороже. вводит возраст сдулент ли он выходные или нет
//
        Scanner scanner = new Scanner(System.in);
//        double priceOFTicket = 10;
//
//        // Блок считывания данных
//        System.out.print("Hello, enter your age: ");
//        int age = scanner.nextInt();
//        boolean isStudent = false;
//        if (age >= 17) {
//            System.out.print("Are you a student? ");
//            isStudent = scanner.nextBoolean();
//        }
//
//        if (isStudent == true)
//            priceOFTicket *= 0.9;
//
//        // Блок условий
//        if (age <= 0) {
//            System.out.println("Wrong age! ");
//            return;
//        }
//
//        if (age <= 7) {
//            System.out.println("Ticket is free! ");
//            priceOFTicket = 0;
//        } else {
//
//            System.out.println("Is it weekend? ");
//            boolean isWeekend = scanner.nextBoolean();
//
//            if (isWeekend == true)
//                priceOFTicket *= 1.2;
//
//            if (age < 17) {
//                System.out.println("You have 30% discount! ");
//                priceOFTicket *= 0.7;
//            }
//
//            if (age >= 65) {
//                System.out.println("You have 40 % discount! ");
//                priceOFTicket *= 0.6;
//            }
//
//
//        }
//        System.out.println("You have to pay " + priceOFTicket + " AZN!");


        //курьер служба 4 зоны центр города 3 манат, терр города 5 анат , пригород 7 манат, вне города 10
        // до 2 кило бесплатно, 2 до 5 + 3 маната, 5 до 10 + 7 манат, больше 10 не привозим
        // экспресс доставка доп 50% дороже

        //Блок считывания данных
        System.out.println("Choose your zone: ");
        System.out.println("1 is center of city");
        System.out.println("2 is city");
        System.out.println("3 is next to the city");
        System.out.println("4 is outside the city");
        double price = 3;
        int zone = scanner.nextInt();

        System.out.println("How many kilograms do you want to deliver? ");
        double kilo = scanner.nextDouble();
        if (kilo > 10) {
            System.out.println("We do not deliver more 10 kilograms! ");
            return;
        }
        if (kilo <= 0) {
            System.out.println("Wrong weight! ");
            return;
        }
        switch (zone) {
            case 1:
                price = 3;
                break;
            case 2:
                price = 5;
                break;
            case 3:
                price = 7;
                break;
            case 4:
                price = 10;
                break;
            default:
                System.out.println("Wrong zone! ");
                return;
        }
        if (kilo > 5)
            price += 7;
        else if (kilo > 2)
            price += 3;

        System.out.println("Do you want express delivery? ");
        boolean express = scanner.nextBoolean();
        System.out.println(express);
        if (express == true)
            price *= 1.5;

        System.out.println("Delivery will cost " + price + " AZN");
    }
}