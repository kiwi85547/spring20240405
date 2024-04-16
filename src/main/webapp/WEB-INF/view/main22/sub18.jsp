<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty message}">
    <p style="background-color: cadetblue; padding: 5px">${message}</p>
</c:if>
<h3>로그인 성공하였습니다 짝짝짝</h3>
</body>
</html>
