package io.github.erickkamii.strategy;

import io.github.erickkamii.enums.BankType;
import jakarta.enterprise.util.AnnotationLiteral;

public class BankLiteral extends AnnotationLiteral<Bank> implements Bank{
    private final BankType value;

    public BankLiteral(BankType value) {
        this.value = value;
    }

    @Override
    public BankType value() {
        return value;
    }
}
