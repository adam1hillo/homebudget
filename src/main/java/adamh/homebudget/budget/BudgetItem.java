package adamh.homebudget.budget;

import java.math.BigDecimal;

class BudgetItem {

    private String description;
    private BigDecimal value;
    private BudgetItemType type;

    BudgetItem(String description, BigDecimal value, BudgetItemType type) {
        this.description = description;
        this.value = value;
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BudgetItemType getType() {
        return type;
    }

    public void setType(BudgetItemType type) {
        this.type = type;
    }
}
