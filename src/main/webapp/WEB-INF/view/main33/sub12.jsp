<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <style>
        table, tr, th, td {
            border-collapse: collapse;
            border: 1px solid black;
        }

        th {
            background-color: mediumturquoise;
            padding: 5px;
        }

        td {
            padding-right: 10px;
        }
    </style>
</head>
<body>
<form action="" method="post">
    <div>제목
        <input type="text" name="title" value="제목">
    </div>
    <div>이름
        <input type="text" name="name" value="이름">
    </div>
    <div>나이
        <input type="number" name="age" value="25">
    </div>
    <div>가격
        <input type="number" name="price" value="23000" step="0.01">
    </div>
    <div>출간일
        <input type="date" name="published" value="2024-04-24">
    </div>
    <div>출간날짜
        <input type="datetime-local" name="inserted" value="2024-04-24T16:20:00">
    </div>
    <div>
        <input type="submit" value="입력">
    </div>
</form>
<hr>
<h3>my_table10 레코드</h3>
<table>
    <thead>
    <tr>
        <th>제목</th>
        <th>이름</th>
        <th>나이</th>
        <th>가격</th>
        <th>출간일</th>
        <th>출간날짜</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${datas}" var="data">
        <tr>
            <td>${data.title}</td>
            <td>${data.name}</td>
            <td>${data.age}</td>
            <td>${data.price}</td>
            <td>${data.published}</td>
            <td>${data.inserted}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
