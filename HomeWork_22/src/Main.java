//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Thread odd = new Thread(() -> {
            int i = 1;
            while (i <= 10) {
                System.out.println(i);
                i += 2;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });
        Thread even = new Thread(() -> {
            int i = 0;
            while (i <= 10) {
                System.out.println(i);
                i += 2;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });
        //even.start();
        //odd.start();

//        double balance = 0.0;
//        Runnable deposit1 = () -> {
//          for (int i = 1; i <= 100; i++) {
//              balance += 10.0;
//          }
//        };

        Deposit deposit1 = new Deposit();
        Thread dep1 = new Thread(deposit1);
        Deposit deposit2 = new Deposit();
        Thread dep2 = new Thread(deposit2);
        //dep1.start();
        //dep2.start();
        try {
            dep1.join();
            dep2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
        System.out.println("Balance after threads = " + Deposit.getBalance());

        Runnable pdf = () -> {

            try {
                Thread.sleep(500);
                System.out.println("Pdf file opened");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };
        Runnable jpg = () -> {

            try {
                Thread.sleep(1000);
                System.out.println("Jpg file opened");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };
        Runnable mp4 = () -> {
            try {
                Thread.sleep(2000);
                System.out.println("Mp4 file opened");

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };
        Thread jpgThread = new Thread(jpg);
        Thread mp4Thread = new Thread(mp4);
        Thread pdfThread = new Thread(pdf);
        pdfThread.start();
        jpgThread.start();
        mp4Thread.start();
        try {
            pdfThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            jpgThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            mp4Thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("All files are opened");
    }
}