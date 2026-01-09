package io.github.erickkamii.strategy;

import io.github.erickkamii.enums.BankType;
import jakarta.inject.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Bank {
    BankType value();
}
