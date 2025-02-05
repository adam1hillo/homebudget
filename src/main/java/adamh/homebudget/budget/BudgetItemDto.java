package adamh.homebudget.budget;

import java.math.BigDecimal;

public class BudgetItemDto {
    private final String description;
    private final BigDecimal value;

    public BudgetItemDto(String description, BigDecimal value) {
        this.description = description;
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getValue() {
        return value;
    }
}
