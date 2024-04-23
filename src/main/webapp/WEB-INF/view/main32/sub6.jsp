<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="background-color: bisque; padding: 10px">
    <h2>${message}</h2>
</div>
<h3>직원 조회 및 수정</h3>
<form action="">
    번호
    <input type="number" name="id">
    <button>조회</button>
</form>
<hr>
<c:if test="${empty employee}">
    조회된 직원이 없습니다.
</c:if>
<c:if test="${not empty employee}">
    <form action="/main32/sub6/update" method="post">
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
        <div>상세 내용
            <input type="text" name="notes" value="${employee.notes}">
        </div>
        <div>
                <%--            payload에 붙는 id. 자바빈과 같아야 함--%>
            <input type="text" name="employeeID" value="${employee.employeeID}">
        </div>
        <div>
            <input type="submit" value="수정">
        </div>
    </form>
</c:if>
</body>
</html>
