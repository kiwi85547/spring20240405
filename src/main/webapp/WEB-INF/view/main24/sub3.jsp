<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <td>#</td>
        <td>중복이 제거된 country</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${countries}" var="country" varStatus="status">
    <tr>
        <td>${status.count}</td>
        <td>${country}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
