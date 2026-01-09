package io.github.erickkamii.exception;

public class ApiException extends RuntimeException implements HttpMappableException {
    private static int status;
    public ApiException(String message, int status) {
        super(message);
        ApiException.status = status;
    }
    @Override
    public int getStatus() {
        return status;
    }
}
