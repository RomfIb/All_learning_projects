public class SingleTone {
    private static final SingleTone instance = new SingleTone();
    public SingleTone() {
        System.out.println("Instance created");
    }
    public static SingleTone getInstance() {
        return instance;
    }
}