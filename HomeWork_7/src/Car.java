public class Car {
    private Engine engine;
    public Car () {
        engine = new Engine();
    }

    public void start () {
        engine.start();
    }
}
