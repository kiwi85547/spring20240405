<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>choose, when, otherwise</h3>
<c:choose>
    <c:when test="false">1</c:when>
    <c:when test="true">2</c:when>
    <c:otherwise>3</c:otherwise>
</c:choose>
<hr>
<c:choose>
    <c:when test="${age < 13}">어린이용 콘텐츠</c:when>
    <c:when test="${age <= 19}">청소년용 콘텐츠</c:when>
    <c:otherwise>성인용 콘텐츠</c:otherwise>
</c:choose>


</body>
</html>
