//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();// 2-й поток
        System.out.println(Thread.currentThread().getName());// 1-ый поток
        MyThread2 myThread2_1 = new MyThread2("thread a");
        MyThread2 myThread2_2 = new MyThread2("thread b");
        myThread2_1.start();
        myThread2_2.start();
        Thread myThread3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        myThread3.run();
        myThread3.start();

        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask);
        thread.start();

        Runnable task = () -> {
            for (int i = 1; i <= 5; i++)
                System.out.println(Thread.currentThread().getName() + ":" + i);
        };
        Thread thread1 = new Thread(task);
        thread1.start();

        new Thread(() -> {
            for (int i = 1; i <= 5; i++)
                System.out.println(Thread.currentThread().getName() + ":" + i);
        }).start();

        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
            Thread.sleep(2000);
        }
        System.out.println("Finished");


        Runnable timer1 = () -> {
        for (int i = 1; i <= 5; i++) {
            System.out.println("timer1: " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        };

        Runnable timer2 = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("timer2: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        };
        new Thread(timer1).start();
        new Thread(timer2).start();

        Thread thread2 = new Thread(() -> System.out.println("thread2 started"));
        Thread.sleep(2000);
        System.out.println(thread2.isAlive());
        System.out.println("thread2 finished");
        thread2.start();
        System.out.println(thread2.isAlive());
        thread2.join(2000);
        System.out.println(thread2.isAlive());
        System.out.println("main finished");

        //1 NEW
        //.start()
        //2 RUNNABLE
        //2.1 BLOCKED
        //2.2 WAITING - join()
        //2.3 TIMED WAITING - join(1000)
        //3 TERMINATED

        Thread thread3 = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        System.out.println(thread3.getState());
        thread3.start();
        System.out.println(thread3.getState());

        Runnable thread4 = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("digit: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        };

        Runnable thread5 = () -> {
            for (char c = 'a'; c <= 'e'; c++) {
                System.out.println("letter: " + c);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        };
        new Thread(thread4).start();
        new Thread(thread5).start();

        Thread digits = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("digit: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }, "digit_thread");

        Thread letters = new Thread(() -> {
            for (char c = 'a'; c <= 'e'; c++) {
                System.out.println("letter: " + c);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }, "letter_thread");
        digits.start();
        letters.start();
    }
}