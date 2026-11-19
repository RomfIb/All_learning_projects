@FunctionalInterface
public interface Calculation {
    int calculate(int a, int b);
    default int multiply(int a, int b) {
        return 0;
    }
}