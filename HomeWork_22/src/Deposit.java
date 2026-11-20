public class Deposit implements Runnable{
    private static Double balance = 0.0;

    public static Double getBalance() {
        return balance;
    }

    @Override
    public void run() {
          for (int i = 1; i <= 100; i++) {
              balance += 10.0;
              System.out.println("Balance = " + balance);
          }
    }
}
