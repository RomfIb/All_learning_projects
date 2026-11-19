import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SingleTone connection1 = SingleTone.getInstance();
        SingleTone connection2 = SingleTone.getInstance();
        System.out.println(connection1.equals(connection2));
        System.out.println(connection1);
        System.out.println(connection2);

        CarPrototype car1 = new CarPrototype("Mercedes","E-class");
//        Prototype car2 = new Prototype("Mercedes","E-class");
        CarPrototype car2 = car1.copy();
        System.out.println(car1 == car2);
        car2.setColor("white");

        List<Order> orderList = List.of(
                new Order(1, "Meat", 20.0, 2),
                new Order(2, "Cheese", 17.0, 5),
                new Order(3, "Doner", 3.5, 5),
                new Order(4, "Ayran", 2.0, 3),
                new Order(5, "Bread", 0.65, 10)
        );

        ExecutorService orderExecutor = Executors.newFixedThreadPool(3);
        AtomicInteger processedCount = new AtomicInteger(0);
        List<Future<Double>> futures = new ArrayList<>();
        Double total = 0.0;
        try {
            for (Order order: orderList) {
                Future<Double> future = orderExecutor.submit(new OrderTask(order, processedCount));
                futures.add(future);
                total += future.get();
            }
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        catch (ExecutionException e) {
            Thread.currentThread().interrupt();
        }
        finally {
            orderExecutor.shutdown();
        }
        System.out.println("Processed for now: " + processedCount.get());
        System.out.println("Total for now: " + total);
    }
}