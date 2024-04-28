package it.epicode.exceptions;

public class AddItemException extends RuntimeException {
    public AddItemException() {
        super();
    }
    public AddItemException(String message) {
        super(message);
    }
}
