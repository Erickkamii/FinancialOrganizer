package io.github.erickkamii.domain;

import io.github.erickkamii.enums.BankType;
import io.github.erickkamii.enums.Currency;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParsedStatement {
    private BankType bankType;
    private StatementPeriod period;
    private List<Transaction> transactions;
    private BigDecimal balanceStart;
    private BigDecimal balanceEnd;
    private Currency currency;
}
