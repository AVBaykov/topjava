<%@ page import="ru.javawebinar.topjava.util.TimeUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<table align="center" cellspacing="0" cellpadding="10" rules="all"
       border="3" width="50%">
    <caption><h2>Еда</h2></caption>
    <tr>
        <th>Дата/время</th>
        <th>Описание</th>
        <th>Калории</th>
    </tr>
    <c:forEach var="item" items="${meals}">
        <jsp:useBean id="item" type="ru.javawebinar.topjava.model.MealWithExceed"/>
        <tr style="${item.exceed ? 'color:red' : 'color:green'}">
            <td><%=TimeUtil.parseDate(item.getDateTime())%>
            </td>
            <td>${item.description}</td>
            <td>${item.calories}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
