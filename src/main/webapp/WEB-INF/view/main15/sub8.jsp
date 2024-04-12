<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--중복된 어트리뷰트를 넣는건 좋은 코드가 아님--%>
<c:set var="attr1" value="page value1" scope="page" />
<c:set var="attr1" value="request value1" scope="request" />
<c:import url="navbar5.jsp"/>

<div>
    <div>
<%--        page value1--%>
        <p>${attr1}, ${pageScope.attr1}, ${pageScope["attr1"]}</p>
    </div>
    <div>
<%--        request value1--%>
        <p>${requestScope.attr1}, ${requestScope["attr1"]}</p>
    </div>
</div>


</body>
</html>
