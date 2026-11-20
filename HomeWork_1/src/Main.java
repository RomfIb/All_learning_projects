//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String studentFirstName = "John";
        String studentLastName = "Smith";
        int studentAge = 20;
        double studentHeight = 1.80;
        boolean isStudent = true;
        System.out.println("His name is " + studentFirstName + " " + studentLastName);
        System.out.println("He is " + studentAge + " years old");
        System.out.println("He is " + studentHeight + " meters tall");
        System.out.println("He is " + isStudent + " student");

        double rectangleHeight = 5.85;
        int rectangleWidth = 3;
        double rectangleSquare = rectangleHeight * rectangleWidth;
        double rectanglePerimeter = 2 * (rectangleWidth + rectangleHeight);
        System.out.print("The perimeter of a rectangle is " + rectanglePerimeter);
        System.out.println(" and the square is " + rectangleSquare);

        int hours1 = 2;
        int minutes1 = 35;
        int totalMin1 = hours1 * 60 + minutes1;
        System.out.println("2 hours and 35 minutes is " + totalMin1 + " minutes");

        int totalMin2 = 135;
        int hours2 = totalMin2 / 60;
        int minutes2 = totalMin2 % 60;
        System.out.println("135 minutes is " + hours2 + " hours and " + minutes2 + " minutes");

        double priceOfGoods = 345;
        int sale = 18;
        double newPrice = priceOfGoods - (priceOfGoods * sale / 100);
        System.out.println("The discount price of goods is " + newPrice + " AZN");
    }
}