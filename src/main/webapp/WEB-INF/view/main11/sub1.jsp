<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Expression Language</p>
<p>간단한 연산 사용 가능</p>
<p>산술연산, 논리연산, 비교연산, 삼항연산</p>

<h3>산술연산, +,-, *, /, %</h3>
<p>${5+3}</p>
<p>${7-3}</p>
<p>${8*3}</p>
<p>${6/2}</p>

<%--3.5--%>
<p>${7/2}</p>
<%--3.5--%>
<p>${7 div 2}</p>

<p>${15%4}</p>
<p>${15 mod 4}</p>

<%--문자열 사용 가능--%>
<%--7   문법이 자바와 다름--%>
<p>${"3"+"4"}</p>

<%--자바와 다름 --%>
<p>${num1}+${num2}=${num1+num2}</p>

<h3>비교연산 >,<,>=,<=,= 키워드연산</h3>
<p>${5>3}</p>
<p>${5 gt 3}</p>

<p>${5<3}</p>
<p>${5 lt 3}</p>

<p>${5>=3}</p>
<p>${5 ge 3}</p>

<p>${5<=3}</p>
<p>${5 le 3}</p>

<p>${5==3}</p>
<p>${5 eq 3}</p>

<%--유니코드가 대문자가 더 작음--%>
<p>${"hello"<"spring"}</p>
<%----%>
<p>${"hello"<"Spring"}</p>
<p>${11<2}</p>

<%--수와 수가 아닌 것을 연산하면 수로 바뀜--%>
<p>${"11"<2}</p>
<p>${11<"2"}</p>
<%--<p>${11<"two"}</p> 에러--%>

<h3>논리연산 &&, ||, !</h3>
<p>${true && true}</p>
<p>${true && true}</p>
<p>${true && true}</p>
<p>${true && true}</p>


<p>${true && true}</p>
<p>${true && true}</p>
<p>${true && true}</p>
<p>${true && true}</p>

<h4>!</h4>
<p>${!true}</p>
<p>${!false}</p>
<h4>not</h4>
<p>${not true}</p>
<p>${not true}</p>

<%--키워드 연산 : and , or--%>

<h3>삼항연산자</h3>
<p>${true?"hello":"world"}</p>
<p>${false?"hello":"world"}</p>
<p>${age1 ge 20 ? "투표가능" : "투표불가능"}</p>
<p>${age2 ge 20 ? "투표가능" : "투표불가능"}</p>

<hr>
<p>가격이 ${price}원인 물건 ${quantity}개의 총가격은 ${quantity * price}원 입니다.</p>
</body>
</html>
