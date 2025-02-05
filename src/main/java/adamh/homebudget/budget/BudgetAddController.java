package adamh.homebudget.budget;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/add")
public class BudgetAddController extends HttpServlet {

    private BudgetService budgetService = new BudgetService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/addform.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        BigDecimal value = new BigDecimal(request.getParameter("amount"));
        BudgetItemType type = BudgetItemType.valueOf(request.getParameter("type"));
        BudgetItemDto budgetItemDto = new BudgetItemDto(description, value);
        if (type == BudgetItemType.INCOME) {
            budgetService.addIncome(budgetItemDto);
        } else if (type == BudgetItemType.EXPENSE) {
            budgetService.addExpense(budgetItemDto);
        }
        response.sendRedirect(request.getContextPath() +"/");
    }
}
