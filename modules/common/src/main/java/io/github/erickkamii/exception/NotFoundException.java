package io.github.erickkamii.exception;

public class NotFoundException extends RuntimeException implements HttpMappableException{
    private static int status = 404;
    public NotFoundException(String message, int status) {
        super(message);
        NotFoundException.status = status;
    }
    @Override
    public int getStatus() {
        return status;
    }
}
