package adamh.homebudget.budget;

class BudgetItemMapper {

    static BudgetItemDto fromEntity (BudgetItem budgetItem) {
        return new BudgetItemDto(budgetItem.getDescription(), budgetItem.getValue());
    }

    static BudgetItem toEntity (BudgetItemDto budgetItemDto, BudgetItemType type) {
        return new BudgetItem(budgetItemDto.getDescription(), budgetItemDto.getValue(), type);
    }
}
