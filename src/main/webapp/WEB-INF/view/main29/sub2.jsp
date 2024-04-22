<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty message}">
    <div style="background-color: lemonchiffon; padding: 10px">
            ${message}
    </div>
</c:if>
<h3>직원 조회</h3>
<form action="">
    직원번호
    <input type="number" name="id">
    <button>조회</button>
</form>
<hr>
<c:if test="${empty employee}">
    조회된 결과가 없습니다.
</c:if>
<c:if test="${not empty employee}">
    <%--    input[readonly][value]--%>
    <div>
        직원 번호
        <input type="text" readonly value="${employee.employeeID}">
    </div>
    <div>
        성
        <input type="text" readonly value="${employee.lastName}">
    </div>
    <div>
        이름
        <input type="text" readonly value="${employee.firstName}">
    </div>
    <div>
        생일
        <input type="date" readonly value="${employee.birthDate}">
    </div>
    <div>
        사진
        <input type="text" readonly value="${employee.photo}">
    </div>
    <div>
        상세정보
        <textarea name="" readonly id="" cols="30" rows="10">${employee.notes}</textarea>
    </div>
    <form action="/main29/sub2/delete" method="post" onsubmit="return confirm('삭제하시겠습니까?')">
        <div hidden="">
            <input type="text" name="id" value="${employee.employeeID}">
        </div>
        <div>
            <button style="background-color: crimson">삭제</button>
        </div>
    </form>
</c:if>
</body>
</html>
