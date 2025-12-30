package io.github.erickkamii.service;

import io.github.erickkamii.domain.ParsedStatement;
import io.github.erickkamii.enums.BankType;
import io.github.erickkamii.exception.NotFoundException;
import io.github.erickkamii.request.ImportRequest;
import io.github.erickkamii.strategy.BankStatementParser;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;


@ApplicationScoped
public class ImportService {

    @Inject
    Instance<BankStatementParser> parsers;

    public ParsedStatement importFile(ImportRequest importRequest) {
        BankStatementParser parser = helper(importRequest.bankType());
        return parser.parse(importRequest.file().uploadedFile().toFile());
    }

    private BankStatementParser helper(BankType bankType) {
        return parsers.stream()
                .filter(p -> p.getBankType() == bankType)
                .findFirst()
                .orElseThrow(()->new NotFoundException("Parser not found for: "+ bankType.name(), 404));
    }
}
