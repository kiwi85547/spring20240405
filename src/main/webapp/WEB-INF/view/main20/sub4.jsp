<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--form : 어디로 무엇을 어떻게 보내라--%>
<%--action : 어디로--%>
<%--method : 어떻게--%>
<form action="/main20/sub5">
<%--request parameter로 보내기. name을 작성해야함 ?name= --%>
<%--    name : 무엇을--%>
    <input type="text" name="player" placeholder="이름을 입력해 주세요.">
    <input type="submit">
</form>
<%--todo : /main20/sub6 요청 경로에서 일하는 메소드 작성, sub6.jsp 작성--%>
<form action="/main20/sub6">
    주소 :
    <input type="text" name="address">
    <div>
    종류 :
        <input type="text" name="type">
    </div>
    <input type="submit">
</form>
<hr>
<form action="/main20/sub8">
    <div>
    이름
    <input type="text" name="name"/>
    </div>
    <div>
    나이
<%--        name attribute값 꼭 주기. request parameter가 age로 결정됨--%>
    <input type="number" name="age" min="1" max="100"/>
    </div>
    <div>생년월일
        <input type="date" name="birth">
    </div>
    <div>
        주소
        <input type="text" name="address">
    </div>
    <div>
        취미
        <input type="text" name="hobby">
    </div>
    <div>
        <input type="submit">
    </div>
</form>
</body>
</html>