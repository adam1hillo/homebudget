package adamh.homebudget.budget;

import java.math.BigDecimal;

public class BudgetSummaryDto {
    private final BigDecimal incomes;
    private final BigDecimal expenses;
    private final BigDecimal balance;

    public BudgetSummaryDto(BigDecimal incomes, BigDecimal expenses, BigDecimal balance) {
        this.incomes = incomes;
        this.expenses = expenses;
        this.balance = balance;
    }

    public BigDecimal getIncomes() {
        return incomes;
    }

    public BigDecimal getExpenses() {
        return expenses;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
