<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--Map은 순서 보장 안됨--%>
<c:forEach items="${foods}" var="food">
    <p>${food}</p>
</c:forEach>

<c:forEach items="${myList}" var="entry">
    <p>${entry.key}:${entry.value}</p>
</c:forEach>
<hr>
<c:forEach items="${cars}" var="item">
    <p>브랜드: ${item.key}, 국가: ${item.value}</p>
</c:forEach>
<hr>
<c:forEach items="${myList2}" var="elem">
    <p>${elem}</p>
</c:forEach>
</body>
</html>
