package io.github.erickkamii.exception;

import io.github.erickkamii.enums.BankType;

public class ParserConfigurationException extends RuntimeException implements InternalException {
    public ParserConfigurationException(BankType bankType) {
        super("Parser for bank type " + bankType + " is not configured properly.");
    }
}
