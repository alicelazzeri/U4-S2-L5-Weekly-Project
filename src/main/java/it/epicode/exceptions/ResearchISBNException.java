package it.epicode.exceptions;

public class ResearchISBNException extends RuntimeException {
    public ResearchISBNException(String s, Exception e) {
        super();
    }
    public ResearchISBNException(String message) {
        super(message);
    }
}
