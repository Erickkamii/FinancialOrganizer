package io.github.erickkamii.exception;

public class DomainException extends RuntimeException implements HttpMappableException{
    private static int status;
    public DomainException(String message, int status) {
        super(message);
        DomainException.status = status;
    }
    @Override
    public int getStatus() {
        return status;
    }
}
