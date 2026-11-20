package Exceptions;

public class OrderStorageFullException extends RuntimeException {
    public OrderStorageFullException(String message) {
        super(message);
    }
}
