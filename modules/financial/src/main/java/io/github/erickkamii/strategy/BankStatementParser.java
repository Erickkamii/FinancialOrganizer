package io.github.erickkamii.strategy;

import io.github.erickkamii.domain.BankStatementSource;
import io.github.erickkamii.domain.ParsedStatement;

public interface BankStatementParser {
    ParsedStatement parse(BankStatementSource file);
}
