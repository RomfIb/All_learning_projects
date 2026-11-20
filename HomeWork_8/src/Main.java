import Exceptions.InvalidPaymentMethodException;

import java.lang.invoke.WrongMethodTypeException;
import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        OrderService orderService = new OrderService(10);
        BankAccount bankAccount = new BankAccount("AS3", 15000.0);
        Customer customer =new Customer("Alex", 25, 1, bankAccount);
        Product[] products = {
                new Product("Mouce", 1200.0),
                new Product("Keyboard", 2500.0),
                new Product("Laptop", 10000.0)
        };

        while (true) {
            System.out.println("\n------MAIN MENU------");
            System.out.println("Customer: " + customer.getName() + " balance: "
                    + customer.getCustomerAccount().getAccountBalance());
            System.out.println("1. See available products and buy");
            System.out.println("2. Deposit balance");
            System.out.println("3. See order history");
            System.out.println("4. EXIT");
            System.out.println("Choose option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                System.out.println("\n----PRODUCT LIST-----");
                for (int i = 0; i < products.length; i++) {
                    System.out.println((i + 1) + ".____" + products[i].getProductName() + "_____" +
                            products[i].getProductPrice());
                }
                System.out.println("Enter product number you want to buy");
                int prodChoice = scanner.nextInt();
                scanner.nextLine();

                if ((prodChoice > 0) && (prodChoice <= products.length)) {
                    Product selectedProduct = products[prodChoice - 1];
                    System.out.println("Choose payment method: Card or Cash");
                    String paymentMethod = scanner.nextLine();
                    try {
                        orderService.createOrder(customer, selectedProduct, paymentMethod);
                    }
                    catch (InvalidPaymentMethodException e) {
                        System.err.println(e.getMessage());
                    }
                    finally {
                        System.out.println("Освобождение ресурсов");
                    }
                }
            } else if (option == 2) {
                System.out.println("\n Enter amount to deposit: ");
                Double amount = scanner.nextDouble();
                customer.getCustomerAccount().deposit(amount);
            } else if (option == 3) {
                orderService.printAllOrders();
            } else if (option == 4) {
                System.out.println("-----GOOD BUY-----");
                break;
            } else {
                System.out.println("Wrong option");
            }
        }
        scanner.close();
    }
}