<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty message}">
    <div style="background-color: mediumaquamarine">${message}</div>
</c:if>
<h3>직원 정보 조회</h3>
<form action="">
    <input type="number" name="id">
    <button>조회</button>
</form>
<hr>
<h4>${employee.employeeID}번 직원 조회</h4>
<form action="/main30/sub2/update" method="post">
    <%--    위에 있는 *번 직원 조회를 쓰려면 name 지정해줘야 함--%>
    <%--    name을 자바빈의 이름으로 해주어야 함.--%>
    <input type="hidden" name="employeeID" value="${employee.employeeID}">
    <div>성
        <input type="text" name="lastName" value="${employee.lastName}">
    </div>
    <div>이름
        <input type="text" name="firstName" value="${employee.firstName}">
    </div>
    <div>생일
        <input type="date" name="birthDate" value="${employee.birthDate}">
    </div>
    <div>사진
        <input type="text" name="photo" value="${employee.photo}">
    </div>
    <div>상세 사항
        <br>
        <textarea name="notes" id="" cols="30" rows="10">${employee.notes}</textarea>
    </div>
    <div>
        <input type="submit" value="수정">
    </div>
</form>
</body>
</html>
