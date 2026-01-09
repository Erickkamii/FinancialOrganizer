package io.github.erickkamii.strategy.impl;

import io.github.erickkamii.domain.BankStatementSource;
import io.github.erickkamii.domain.ParsedStatement;
import io.github.erickkamii.strategy.BankStatementParser;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SantanderParser implements BankStatementParser {
    @Override
    public ParsedStatement parse(BankStatementSource file) {
        return new ParsedStatement();
    }

}
