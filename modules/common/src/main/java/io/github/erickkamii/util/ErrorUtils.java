package io.github.erickkamii.util;

public class ErrorUtils {

    public static void throwIf(boolean condition, RuntimeException exception) {
        if (condition) {
            throw exception;
        }
    }
}
