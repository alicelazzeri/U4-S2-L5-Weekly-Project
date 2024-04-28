package it.epicode.exceptions;

public class ResearchPublishingYearException extends RuntimeException {
    public ResearchPublishingYearException (String s, Exception e) {
        super();
    }
    public ResearchPublishingYearException(String message) {
        super(message);
    }
}
