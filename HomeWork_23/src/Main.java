import java.util.List;
import java.util.concurrent.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static String leader = "Nobody";
    private static Integer maxStage = 0;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Runner> runners = List.of(
                new Runner("Runner 1", List.of(300, 1100, 1100, 500, 400)),
                new Runner("Runner 2", List.of(700, 400, 500, 1200, 900)),
                new Runner("Runner 3", List.of(1100, 800, 400, 300, 300))
        );

        ExecutorService runnersExecutor = Executors.newFixedThreadPool(runners.size());
        List<Future<String>> futures = runners
                .stream()
                .map(runner -> runnersExecutor.submit(() -> running(runner)))
                .toList();
        System.out.println("======RESULTS======");
        for (Future<String> future: futures) {
            System.out.println(future.get());
        }
        runnersExecutor.shutdown();

        ExecutorService calculatorExecutor = Executors.newFixedThreadPool(4);
        Double a = 20.0;
        Double b = 4.0;
        Callable<Double> add = () -> {
            System.out.println("Add in thread " + Thread.currentThread().getName());
            return a + b;
        };
        Callable<Double> subtract = () -> {
            System.out.println("Subtract in thread " + Thread.currentThread().getName());
            return a - b;
        };
        Callable<Double> multiply = () -> {
            System.out.println("Multiply in thread " + Thread.currentThread().getName());
            return a * b;
        };
        Callable<Double> divide = () -> {
            System.out.println("Divide in thread " + Thread.currentThread().getName());
            if (b == 0) {
                throw new ArithmeticException("Cannot divide by zero");
            }
            return a / b;
        };

        Future<Double> addFuture = calculatorExecutor.submit(add);
        Future<Double> subtractFuture = calculatorExecutor.submit(subtract);
        Future<Double> multiplyFuture = calculatorExecutor.submit(multiply);
        Future<Double> divideFuture = calculatorExecutor.submit(divide);
        System.out.println("Add: " + addFuture.get());
        System.out.println("Subtract: " + subtractFuture.get());
        System.out.println("Multiply: " + multiplyFuture.get());
        System.out.println("Divide: " + divideFuture.get());
        calculatorExecutor.shutdown();


        TrafficLight trafficLight = new TrafficLight();
        Thread trafficThread = new Thread(() -> {
            while (trafficLight.getRunning()) {
                System.out.println("Current light: " + trafficLight.getColor());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Traffic thread is stopped");
        });
        trafficThread.start();
        for (int i = 0; i < 4; i++) {
            Thread.sleep(2000);
            trafficLight.switchColor();
        }
        trafficLight.stop();
        System.out.println("Main thread stopping traffic light");
        trafficThread.join();
        System.out.println("Traffic light is ended");

        Integer initialTickets = 10;
        Integer planPerCashier = 5;
        Integer cashiersCount = 3;

        TicketBox box = new TicketBox(initialTickets);
        ExecutorService cinemaExecutor = Executors.newFixedThreadPool(cashiersCount);

        for (int i = 0; i < cashiersCount; i++) {
            Cashier cashier = new Cashier("Cashier " + (i+1), box, planPerCashier);
            cinemaExecutor.submit(() -> cashier.startSelling());
        }
        cinemaExecutor.shutdown();
    }


    public static String running(Runner runner) throws InterruptedException {
        Integer total = 0;
        for (int i = 0; i < runner.times().size(); i++) {
            Integer stageTime = runner.times().get(i);
            Thread.sleep(stageTime);
            total += stageTime;
            checkLeader(runner.name(), i + 1);
        }
        return runner.name() + ": " + total + "ms";
    }
    public static synchronized void checkLeader(String name, Integer stage) {
        System.out.println(name + " -> stage " + stage);
        if (stage > maxStage) {
            if (!leader.equals(name) && !leader.equals("Nobody")) {
                System.out.println(name + " overtook " + leader);
            }
            maxStage = stage;
            leader = name;
        }
    }
}