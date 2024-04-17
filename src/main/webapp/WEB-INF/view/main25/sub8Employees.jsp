<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <style>
        table,tr,th,td{
            border: 1px solid black;
            border-collapse: collapse;
        }
        table{
            width: 100%;
        }
        thead{
            background-color: cadetblue;
        }
        td:first-child{
            text-align: center;
        }
    </style>
</head>
<body>
<h3>직원 정보 조회</h3>
<form action="">
    <input type="text" name="name" placeholder="조회할 이름을 입력해 주세요">
    <input type="submit" value="조회">
</form>
<hr>
<c:if test="${empty employees}" var="emptyEmployees">
    <p>조회된 내용이 없습니다.</p>
</c:if>
<c:if test="${not emptyEmployees}">
    <table>
        <thead>
        <tr>
            <th>EmployeeID</th>
            <th>LastName</th>
            <th>FirstName</th>
            <th>BirthDate</th>
            <th>Photo</th>
            <th>Notes</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${employees}" var="employee">
            <tr>
                <td>${employee.employeeID}</td>
                <td>${employee.lastName}</td>
                <td>${employee.firstName}</td>
                <td>${employee.birthDate}</td>
                <td>${employee.photo}</td>
                <td>${employee.notes}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
</body>
</html>
