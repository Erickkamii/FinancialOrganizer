package io.github.erickkamii.strategy.impl;

import io.github.erickkamii.domain.BankStatementSource;
import io.github.erickkamii.domain.ParsedStatement;
import io.github.erickkamii.strategy.BankStatementParser;

public class GenericParser implements BankStatementParser {
    @Override
    public ParsedStatement parse(BankStatementSource file) {
        return new ParsedStatement();
    }

}
