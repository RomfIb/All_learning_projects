import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderTask implements Callable<Double> {

    private Order order;
    private AtomicInteger orderProcesseed;

    public OrderTask(Order order, AtomicInteger orderProcesseed) {
        this.order = order;
        this.orderProcesseed = orderProcesseed;
    }

    @Override
    public Double call() throws Exception {
        System.out.println("Processing order " + order.getId() + " " + order.getName() + " in thread " + Thread.currentThread().getName());
        Thread.sleep(500);
        Double total = order.calculateTotal();
        orderProcesseed.incrementAndGet();
        System.out.println("Processed order count " + orderProcesseed.get());
        return total;
    }
}