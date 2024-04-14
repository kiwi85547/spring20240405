<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${myBean142.name}
${myBean142List}

<p>${myBean142List[0].name}</p>
<p>${myBean142List[1].name}</p>

<c:forEach items="${myBean142List}" var="list">${list}</c:forEach>
</body>
</html>
