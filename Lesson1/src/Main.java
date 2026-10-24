//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, Rauf!");
        System.out.println("I am starting to learn Java");
        System.out.print("Good luck, ");
        System.out.println("Rauf");
        System.out.println(1+1);
        System.out.println("1"+1);
        double a = 10;
        int b = 3;
        double c = 2.2;
        float d = 3.0f;
        boolean i = true;
        char t = 'a';
        String s = "Hello";
        long l = 8_000_000_000L;
        System.out.println("a = " + (a + b));
        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(a/b);
        System.out.println(a%b);
        double result = a/b;
        System.out.println(result);
        b = 2;
        System.out.println(b);
        b += 3; // b = b + 3;
        System.out.println(b);
        b = b + 1;
        b += 1;
        int i1 = b++;
        int salaryOfEmployee = 1000;
        double priceOfApples = 1.5;
        int countOfApples = 3;
        double sum = priceOfApples * countOfApples;
        System.out.println("We gain " + sum + " AZN");
        int salaryOfEmployee2 = 1000;
        int bonusOfEmployee = 500;
        int totalSalary = salaryOfEmployee2 + bonusOfEmployee;
        System.out.println(totalSalary);
        int sec = 125;
        int min = sec / 60;
        int remain = sec % 60;
        System.out.println("It is " + min + " minutes and " + remain + " seconds");
        double priceOfFoods = 100;
        int sale = 15;
        double newPrice = priceOfFoods - (priceOfFoods * sale / 100);
        System.out.println(newPrice);
    }
}