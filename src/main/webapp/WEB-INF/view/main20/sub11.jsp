<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/main20/sub12">
    <input type="text" name="type">
    <br>
    <textarea name="content"></textarea>
    <br>
    <select name="city1" id="">
        <option value="london">런던</option>
        <option value="seoul">서울</option>
        <option value="chicago">시카고</option>
    </select>
    <br>
    <input type="submit">
</form>
<hr>
<form action="/main20/sub13">
    <div>
        <div>
            <input type="radio" name="city" value="seoul">
            서울
        </div>
        <div>
            <input type="radio" name="city" value="london">
            런던
        </div>
        <div>
            <input type="radio" name="city" value="Chicago">
            시카고
        </div>
    </div>
    <input type="submit">
</form>
<%--form>div*3>input:c[name=foods]--%>
<form action="/main20/sub14">
    <div>
        <input type="checkbox" name="foods" id="" value="pizza">
    </div>
    <div>
        <input type="checkbox" name="foods" id="" value="noodle">
    </div>
    <div>
        <input type="checkbox" name="foods" id="" value="burger">
    </div>
    <div>
        <input type="submit">
    </div>
</form>
<hr>
<form action="/main20/sub15">
    <div>
        <select name="type">
            <option value="name1">조화영</option>
            <option value="name2">김수환</option>
            <option value="name3">김수아</option>
            <option value="name4">김재후</option>
        </select>
    </div>
    <div> 핸드폰 기종
        <input type="radio" name="phone" value="iphone">아이폰
        <input type="radio" name="phone" value="galaxy">갤럭시
    </div>
    <div>
        <input type="checkbox" name="book" value="java">자바
        <input type="checkbox" name="book" value="spring">스프링
    </div>
    <div>
        <input type="submit">
    </div>
</form>
</body>
</html>
