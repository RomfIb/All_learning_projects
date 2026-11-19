public class Counter {
    private int value = 0;

    public synchronized int getValue() {
        return this.value;
    }

    public synchronized void increment() {
        this.value++;
    }
}
