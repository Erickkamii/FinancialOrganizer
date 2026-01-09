package io.github.erickkamii.domain;

import java.io.InputStream;

public record BankStatementSource(
        InputStream content,
        String fileName
) {
}
