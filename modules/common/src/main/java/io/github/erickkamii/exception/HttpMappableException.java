package io.github.erickkamii.exception;

public interface HttpMappableException {
    int getStatus();
    String getMessage();
}
