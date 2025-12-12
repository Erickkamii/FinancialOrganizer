package io.github.erickkamii.llm;

import java.math.BigDecimal;
import java.util.List;

public record FinantialContext(
        String username,
        BigDecimal amountSpentLastMonth,
        BigDecimal amountReceivedLastMonth,
        List<String> biggestExpenses,
        String financialGoal
) {
}
