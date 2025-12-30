package io.github.erickkamii.domain;

import io.github.erickkamii.enums.TransactionType;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {
    private String id;
    private LocalDateTime date;
    private BigDecimal amount;
    private TransactionType type;
    private String category;
    private String rawDescription;
}
