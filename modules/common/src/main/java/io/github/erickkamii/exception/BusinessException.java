package io.github.erickkamii.exception;

public class BusinessException extends RuntimeException implements HttpMappableException{
    private static int status;
    public BusinessException(String message, int status) {
        super(message);
        BusinessException.status = status;
    }
    @Override
    public int getStatus() {
        return status;
    }
}
