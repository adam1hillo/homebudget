<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Budżet domowy</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
<main>
    <h1>Budżet domowy</h1>
    <section class="summary">
        <h2>Podsumowanie</h2>
        <p>Wpływy: ${requestScope.summary.incomes}zł</p>
        <p>Wydatki: ${requestScope.summary.expenses}zł</p>
        <p>Bilans: ${requestScope.summary.balance}zł</p>
    </section>
    <a href="${pageContext.request.contextPath}/add">Dodaj nowy wpływ lub wydatek</a>
    <c:if test="${not empty requestScope.incomes}">
        <section>
            <h2>Wpływy</h2>
            <table class="incomes">
                <thead>
                    <tr>
                        <th>Opis</th>
                        <th>Kwota</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="income" items="${requestScope.incomes}">
                        <tr>
                            <td><c:out value="${income.description}"/></td>
                            <td>${income.value}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </section>
    </c:if>
    <c:if test="${not empty requestScope.expenses}">
        <section>
            <h2>Wydatki</h2>
            <table class="expenses">
                <thead>
                    <tr>
                        <th>Opis</th>
                        <th>Kwota</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="expense" items="${requestScope.expenses}">
                        <tr>
                            <td><c:out value="${expense.description}"/></td>
                            <td>${expense.value}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </section>
    </c:if>
</main>
</body>
</html>
