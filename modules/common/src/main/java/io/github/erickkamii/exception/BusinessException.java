package io.github.erickkamii.exception;

public class BusinessException extends RuntimeException {
    private static int status;
    public BusinessException(String message, int status) {
        super(message);
        BusinessException.status = status;
    }
    public int getStatus() {
        return status;
    }
}
