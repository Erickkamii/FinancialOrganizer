package io.github.erickkamii.exception;

public class DomainException extends RuntimeException {
    private static int status;
    public DomainException(String message, int status) {
        super(message);
        DomainException.status = status;
    }
    public int getStatus() {
        return status;
    }
}
