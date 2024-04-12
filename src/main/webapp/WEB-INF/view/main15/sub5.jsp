<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="cur" value="sub5" scope="request"/>
<c:import url="navbar3.jsp"/>
<div>
    ${current5} ${current6}
    sub5 콘텐츠
</div>
</body>
</html>
