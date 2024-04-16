<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>고객 테이블</h3>
<table>
    <thead>
    <tr>
        <td>#</td>
        <td>이름</td>
        <td>도시</td>
        <td>country</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customers}" varStatus="status">

    <tr>
        <td>${status.count}</td>
        <td>${customers.customerName}</td>
        <td>${customers.city}</td>
        <td>${customers.country}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
