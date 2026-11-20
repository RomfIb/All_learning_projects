import java.util.Scanner;

public class Order {
     private int orderNumber;
     private Customer customer;
     private Product product;
     private String paymentMethod;

     public Order (){

     }

    public Order(int orderNumber, Customer customer, Product product, String paymentMethod) {
        this.orderNumber = orderNumber;
        this.customer = customer;
        this.product = product;
        this.paymentMethod = paymentMethod;
    }
}
