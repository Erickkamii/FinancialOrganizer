package io.github.erickkamii.exception;

public class NotFoundException extends RuntimeException {
    private static int status = 404;
    public NotFoundException(String message, int status) {
        super(message);
        NotFoundException.status = status;
    }
    public int getStatus() {
        return status;
    }
}
