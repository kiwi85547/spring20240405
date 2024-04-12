<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
--requ시작--
<div>${requestScope.name}</div>
--requ끝--
<div>${sessionScope.city}</div>
<hr>
<div>${model}</div>
<div>${requestScope.model}</div>
<div>${sessionScope.model}</div>
</body>
</html>
