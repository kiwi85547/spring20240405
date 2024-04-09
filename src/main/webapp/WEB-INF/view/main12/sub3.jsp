<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach begin="1" end="2">
        <p>반복 출력 할 코드</p>
    </c:forEach>
<hr>
    <c:forEach begin="0" end="2">
        <p>forEach 테스트</p>
    </c:forEach>
<hr>
<c:forEach begin="1" end="9" var="num">
    <p>2 x ${num} = ${2*num}</p>
</c:forEach>
    <h5>구구단 ${dan}단</h5>
    <c:forEach begin="1" end="9" var="num">
    <p>${dan} x ${num} = ${dan*num}</p>
</c:forEach>
<hr>
<h5>구구단 ${dan}단 거꾸로</h5>
<%--todo : 거꾸로 출력 *9 ~ *1--%>
<c:forEach begin="1" end="9" var="num">
    <p> ${dan} x ${10-num} = ${dan*(10-num)} </p>
</c:forEach>
</body>
</html>
