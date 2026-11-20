import Exceptions.InvalidPaymentMethodException;
import Exceptions.OrderStorageFullException;

public class OrderService {
    private Order[] orders;
    private int orderCount = 0;
    private int orderNumberCounter = 1;

    public OrderService(int capacity) {
        this.orders = new Order[capacity];
    }

    public void createOrder(Customer customer, Product product, String method) {
        if ((!method.equalsIgnoreCase("Card")) && (!method.equalsIgnoreCase("Cash"))) {
            //System.out.println("Wrong payment method");
            //return;
            throw new InvalidPaymentMethodException("This method is not allowed!\n " +
                    "You have to choose card or cash!");
        }
        if (orderCount >= orders.length) {
//            System.out.println("Orders full");
//            return;
            throw new OrderStorageFullException("Order archive is full! Max capacity: " + orders.length);
        }

        if (customer.getCustomerAccount().getAccountBalance() >= product.getProductPrice()) {
            customer.getCustomerAccount().widthraw(product.getProductPrice());

            Order newOrder = new Order(orderNumberCounter++, customer, product, method);
            orders[orderCount] = newOrder;
            orderCount++;
            System.out.println("Order created " + newOrder);
        }
        else
            System.out.println("Low balance");
    }

    public void printAllOrders() {
        System.out.println("---------All orders-----------");
        if (orderCount == 0) {
            System.out.println("No orders have been made");
        }
        else {
            for (int i = 0; i < orderCount; i++) {
                System.out.println(orders[i]);
            }
        }
    }


}
