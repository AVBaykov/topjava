<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:useBean id="meal" type="ru.javawebinar.topjava.model.Meal" scope="request"/>
</head>
<body>
<section>
    <form method="post">
        <input type="hidden" name="id" value="${meal.id}">
        <p>Дата приема пищи: <input type="date" name="date" value="${meal.date}"></p>
        <p>Время приема пищи: <input type="time" name="time" value="${meal.time}"></p>
        <p>Тип приема пищи: <input type="text" name="description" value="${meal.description}"></p>
        <p>Калории из приема: <input type="number" name="calories" value="${meal.calories}"></p>
        <button type="submit">Сохранить</button>
        <button onclick="window.history.back()">Отменить</button>
    </form>
</section>
</body>
</html>
