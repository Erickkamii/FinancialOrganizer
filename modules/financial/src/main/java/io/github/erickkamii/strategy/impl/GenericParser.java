package io.github.erickkamii.strategy.impl;

import io.github.erickkamii.domain.ParsedStatement;
import io.github.erickkamii.enums.BankType;
import io.github.erickkamii.strategy.BankStatementParser;

import java.io.File;

public class GenericParser implements BankStatementParser {
    @Override
    public ParsedStatement parse(File file) {
        return new ParsedStatement();
    }

    @Override
    public BankType getBankType() {
        return BankType.GENERIC;
    }
}
