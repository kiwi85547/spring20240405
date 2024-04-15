<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@ModelAttribute의 값을 정하면 이렇게--%>
${data.city}입니다.
<%--@ModelAttribute를 정하지 않으면 lowerCamelCase로 myBean202--%>
<%--${myBean202.city}입니다.--%>
</body>
</html>
