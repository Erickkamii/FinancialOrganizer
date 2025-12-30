package io.github.erickkamii.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatementPeriod {
    private LocalDate startDate;
    private LocalDate endDate;
}
