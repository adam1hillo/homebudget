package adamh.homebudget.budget;

import java.math.BigDecimal;
import java.util.List;

public class BudgetService {
    private BudgetItemDao budgetItemDao = new BudgetItemDao();

    public void addIncome(BudgetItemDto budgetItemDto) {
        addBudgetItem(budgetItemDto, BudgetItemType.INCOME);
    }
    public void addExpense(BudgetItemDto budgetItemDto) {
        addBudgetItem(budgetItemDto, BudgetItemType.EXPENSE);
    }

    private void addBudgetItem(BudgetItemDto budgetItemDto, BudgetItemType budgetItemType) {
        BudgetItem budgetItem = BudgetItemMapper.toEntity(budgetItemDto, budgetItemType);
        budgetItemDao.save(budgetItem);
    }

    public List<BudgetItemDto> findAllExpenses() {
        return findAllItemsByType(BudgetItemType.EXPENSE)
                .stream()
                .map(BudgetItemMapper::fromEntity)
                .toList();
    }

    public List<BudgetItemDto> findAllIncomes() {
        return findAllItemsByType(BudgetItemType.INCOME)
                .stream()
                .map(BudgetItemMapper::fromEntity)
                .toList();
    }

    private List<BudgetItem> findAllItemsByType(BudgetItemType type) {
        return budgetItemDao.findAllItemsByType(type);
    }

    public BudgetSummaryDto getSummary() {
        BigDecimal incomesSum = getIncomesSum();
        BigDecimal expensesSum = getExpensesSum();
        BigDecimal balance = incomesSum.subtract(expensesSum);
        return new BudgetSummaryDto(incomesSum,expensesSum, balance);
    }


    private BigDecimal getIncomesSum() {
        return getItemsSum(findAllItemsByType(BudgetItemType.INCOME));
    }

    private BigDecimal getExpensesSum() {
        return getItemsSum(findAllItemsByType(BudgetItemType.EXPENSE));
    }

    private BigDecimal getItemsSum(List<BudgetItem> items) {
        return items.stream()
                .map(BudgetItem::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
