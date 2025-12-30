package io.github.erickkamii.strategy;

import io.github.erickkamii.domain.ParsedStatement;
import io.github.erickkamii.enums.BankType;

import java.io.File;

public interface BankStatementParser {
    ParsedStatement parse(File file);

    BankType getBankType();
}
