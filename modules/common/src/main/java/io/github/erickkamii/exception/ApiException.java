package io.github.erickkamii.exception;

public class ApiException extends RuntimeException {
    private static int status;
    public ApiException(String message, int status) {
        super(message);
        ApiException.status = status;
    }
    public int getStatus() {
        return status;
    }
}
