<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<form action="/main25/sub4">--%>
<%--action의 값이 없거나 생략되면 현재 요청 경로로 보냄--%>
<form action="">
    <h3>고객 정보</h3>
    <input type="text" name="name" value="${param.name}" placeholder="이름을 입력하세요">
    <input type="submit" value="조회">
</form>
<hr>
<div>
    <c:forEach items="${customers}" var="customer">
        <h4>이름 : ${customer.name} </h4>
        주소 : <input type="text" value="${customer.address}" readonly>
        <p>
        사는 곳 : <input type="text" value="${customer.city}" readonly>
        </p>
    </c:forEach>
<%--    <h4>이름 : ${customers} 입니다. </h4>--%>
</div>
</body>
</html>
