package it.epicode.exceptions;

public class ResearchAuthorException extends RuntimeException {
    public ResearchAuthorException(String s, Exception e) {
        super();
    }

    public ResearchAuthorException(String message) {
        super(message);
    }
}
