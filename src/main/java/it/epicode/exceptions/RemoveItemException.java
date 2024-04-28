package it.epicode.exceptions;

public class RemoveItemException extends RuntimeException {
    public RemoveItemException() {
        super();
    }
    public RemoveItemException (String message, Exception e) {
        super(message);
    }
}
