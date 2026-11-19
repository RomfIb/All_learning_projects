import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static volatile Boolean running = true;
    public static void main(String[] args) throws Exception {
        Counter counter = new Counter();
        Runnable task = () -> {
          for (int i = 0; i < 100_000; i++) {
              counter.increment();
          }
        };
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(counter.getValue());

        AtomicInteger atomicCounter = new AtomicInteger(0);
//        atomicCounter.incrementAndGet();
//        atomicCounter.incrementAndGet();
//        System.out.println(atomicCounter);
//        System.out.println(atomicCounter.get());
//        atomicCounter.incrementAndGet();
//        System.out.println(atomicCounter);

        Runnable atomicTask = () -> {
            for (int i = 0; i < 100000; i++) {
                atomicCounter.incrementAndGet();
            }
        };
        Thread atomicThread1 = new Thread(atomicTask);
        Thread atomicThread2 = new Thread(atomicTask);
        atomicThread1.start();
        atomicThread2.start();
        atomicThread1.join();
        atomicThread2.join();
        System.out.println(atomicCounter.get());


        Thread thread = new Thread(() -> {
            while (running) {
                System.out.println("thead doing something");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();
        Thread.sleep(3000);
        running = false;
        thread.join();
        System.out.println("main thread finished");


//        for (int i = 0; i < 10; i++) {
//            Thread thread3 = new Thread(() -> {
//                System.out.println("working");
//            });
//            thread3.start();
//        }

        ExecutorService executor = Executors.newFixedThreadPool(2);
//        //..
//        executor.execute(() -> {
//            System.out.println("task executing by " + Thread.currentThread().getName());
//        });

//        for (int i = 1; i <= 10; i++) {
//            int donerNumber = i;
//            executor.execute(() -> {
//                System.out.println("doner " + donerNumber + " delivered by kuryer " + Thread.currentThread().getName());
//                try {
//                    Thread.sleep(3000);
//                    System.out.println("doner " + donerNumber + " delivered by kuryer " + Thread.currentThread().getName());
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//        }


        Callable<Integer> taskCallable = () -> {
            Integer a = 10;
            Integer b = 20;
            try {
                Thread.sleep(1000);

            }
            catch (InterruptedException e) {
                e.getStackTrace();
            }
            System.out.println("30 from callable");
            return a+b;
        };
//        Integer result = taskCallable.call();
//        System.out.println(result);

        Future<Integer> future = executor.submit(taskCallable);
        System.out.println(future.isDone());
        try {
            System.out.println(future.get(3000, TimeUnit.MILLISECONDS));
        }
        catch (TimeoutException e) {
            e.getStackTrace();
        }
        System.out.println("task submitted");

        Callable<Integer> task1 = () -> {
          Integer a = 10;
          Integer b = 40;
          return a + b;
        };

        Callable<Integer> task2 = () -> {
            Integer a = 30;
            Integer b = 20;
            return a + b;
        };

        Future<Integer> future1 = executor.submit(task1);
        Future<Integer> future2 = executor.submit(task2);
        System.out.println(future1.get() + future2.get());
        executor.shutdown();

        AtomicInteger atomicInteger = new AtomicInteger(0);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.execute(() -> {
                for (int j = 0; j < 1000; j++) {
                    atomicInteger.incrementAndGet();
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
        executorService.shutdown();
        Boolean finished = executorService.awaitTermination(300, TimeUnit.MILLISECONDS);
        if (finished) {
            System.out.println("counter = " + atomicInteger.get());
        }
        else {
            System.out.println("Tasks from pool are not finished yet");
        }
    }
}