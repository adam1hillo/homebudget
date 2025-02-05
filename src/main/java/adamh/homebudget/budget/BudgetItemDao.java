package adamh.homebudget.budget;

import adamh.homebudget.db.DataSourceProvider;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class BudgetItemDao {

    private final DataSource dataSource;

    BudgetItemDao() {
        try {
            this.dataSource = DataSourceProvider.getDataSource();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    void save (BudgetItem budgetItem) {
        final String sql = "INSERT INTO budget_item (description, value, type) VALUES (?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, budgetItem.getDescription());
            statement.setBigDecimal(2, budgetItem.getValue());
            statement.setString(3, budgetItem.getType().name());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    List<BudgetItem> findAllItemsByType(BudgetItemType type) {
        String sql = "SELECT description, value, type FROM budget_item WHERE type = ?";

        List<BudgetItem> items = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, type.name());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String description = resultSet.getString("description");
                BigDecimal value = resultSet.getBigDecimal("value");
                BudgetItemType itemType = BudgetItemType.valueOf(resultSet.getString("type"));
                items.add(new BudgetItem(description, value, itemType));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return items;
    }
}
