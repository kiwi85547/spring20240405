<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <%--    message가 not empty라면. 이라는 연산--%>
    <%--    message 연산의 결과가 true or false--%>
    <c:if test="${not empty message}">
        <div style="padding: 10px; background-color: burlywood">${message}</div>
    </c:if>
</div>
<h2>새 직원 입력</h2>
<form action="" method="post">
    <div>
        성
        <input type="text" name="lastName">
    </div>
    <div>
        이름
        <input type="text" name="firstName">
    </div>
    <div>
        생일
        <input type="date" name="birthDate">
    </div>
    <div>
        사진
        <input type="text" name="photo">
    </div>
    <div>
        특이사항
        <input type="text" name="notes">
    </div>
    <div>
        <input type="submit" value="입력">
    </div>
</form>
</body>
</html>
