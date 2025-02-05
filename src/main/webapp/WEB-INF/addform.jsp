<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Dodaj wpływ lub wydatek</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
    <main>
        <h1>Nowy wpływ lub wydatek</h1>
        <form action="${pageContext.request.contextPath}/add" method="post">
            <fieldset>
                <legend>Dodaj nową pozycję</legend>
                <label class="keybord-inputs">
                    Opis wpływu / wydatku
                    <input name="description" placeholder="np. Rachunek za telefon">
                </label>
                <label class="keybord-inputs">
                    Kwota (zł)
                    <input name="amount" type="number" step="0.01" placeholder="np. 99.95">
                </label>
                <section>
                    <label>
                        Wpływ
                        <input type="radio" name="type" value="INCOME">
                    </label>
                    <label>
                        Wydatek
                        <input type="radio" name="type" value="EXPENSE">
                    </label>
                </section>
                <button>Zapisz</button>
            </fieldset>
        </form>
    </main>
</body>
</html>
