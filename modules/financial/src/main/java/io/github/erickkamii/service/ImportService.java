package io.github.erickkamii.service;

import io.github.erickkamii.domain.BankStatementSource;
import io.github.erickkamii.domain.ParsedStatement;
import io.github.erickkamii.enums.BankType;
import io.github.erickkamii.exception.ParserConfigurationException;
import io.github.erickkamii.request.ImportRequest;
import io.github.erickkamii.strategy.BankLiteral;
import io.github.erickkamii.strategy.BankStatementParser;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;

import java.io.InputStream;


@ApplicationScoped
public class ImportService {

    @Inject
    Instance<BankStatementParser> parsers;

    public ParsedStatement importFile(ImportRequest importRequest) {
        BankStatementParser parser = resolveParser(importRequest.bankType());

        BankStatementSource source = new BankStatementSource(
                (InputStream) importRequest.file().uploadedFile(),
                importRequest.file().fileName()
        );
        return parser.parse(source);
    }

    private BankStatementParser resolveParser(BankType bankType) {
        try {
            return parsers.select(new BankLiteral(bankType))
                    .get();
        } catch (Exception e) {
            throw new ParserConfigurationException(bankType);
        }
    }

}
