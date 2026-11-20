import Exception.*;
import Enum.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();

        try {
            Product incorrectProduct = new Product(100,"Motal pendir", "Cheese", -15.0);
        }
        catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        try {
            shop.addProduct(new Product(1, "Beef", "Meat", 20.0));
            shop.addProduct(new Product(2,"Parmesan", "Cheese", 15.0));
            shop.addProduct(new Product(3,"Holland","Cheese", 16.0));
            shop.addProduct(new Product(4, "Lamb", "Meat", 23.0));
            shop.addProduct(new Product(5, "Motal", "Cheese", 14.0));
        }
        catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        try {
            Product p1 = shop.findProductById(2);
            System.out.println("Product " + p1.name() + " is found");

            Product p2 = shop.findProductById(102);
        }
        catch (ProductNotFoundException e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println("Before deleting meat: " + shop.getCategoriesSet());
            shop.removeProductById(1);
            shop.removeProductById(4);
            System.out.println("After deleting meat: " + shop.getCategoriesSet());

            shop.removeProductById(1);
        }
        catch (ProductNotFoundException e) {
            System.err.println(e.getMessage());
        }

        System.out.println(shop.getMostExpensiveProduct());
        System.out.println(shop.getProductsByCategory("Cheese"));


        BankOperation bank = new BankOperation();

        bank.addTransaction(OperationType.DEPOSIT, 1000.0);
        bank.addTransaction(OperationType.WITHDRAW, 500.0);
        bank.addTransaction(OperationType.TRANSFER, 250.0);
        bank.addTransaction(OperationType.TRANSFER, 150.0);
        System.out.println("First transaction " + bank.getFirstTransaction());
        System.out.println("Last transaction " + bank.getLastTransaction());
        System.out.println(bank.getTotalAmountByType());
        System.out.println("Remove last: " + bank.removeLastTransaction());
        System.out.println(bank.getTotalAmountByType());
    }
}