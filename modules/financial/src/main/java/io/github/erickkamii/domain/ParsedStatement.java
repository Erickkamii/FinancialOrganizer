package io.github.erickkamii.domain;

import io.github.erickkamii.enums.BankType;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ParsedStatement {
    @NonNull
    private BankType bankType;
    @NonNull
    private StatementPeriod period;
    @NonNull
    private List<Transaction> transactions;
}
