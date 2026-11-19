public class MyThread2 extends Thread{
    private String threadName;

    public MyThread2(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++)
            System.out.println(threadName + ":" + i);
    }
}
