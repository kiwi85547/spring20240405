<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty message}">
    <div style="background-color: cadetblue; padding: 10px">
            ${message}
    </div>
</c:if>
<h3>
    고객 정보 수정
</h3>
<form action="">
    번호
    <%--    name = submit 버튼을 눌렀을 때 붙는 리퀘스트 파라미터 이름--%>
    <%--    /main32/sub7?id=3--%>
    <input type="number" name="id">
    <button>조회</button>
</form>
<hr>
<c:if test="${empty customer}">
    조회된 결과가 없습니다.
</c:if>
<c:if test="${not empty customer}">
    <form action="/main32/sub7/update" method="post" onsubmit="return confirm('수정하시겠습니까?')">
        <div>아이디
                <%--        input엘리멘트의 name 어트리뷰트를 작성해야 submit버튼 눌렀을 때 리퀘스트파라미터로 받을 수 있음--%>
                <%--           name은 query String의 payload로 붙음. 받을 때 이 값으로 받아야 함 --%>
            <input type="text" name="id" value="${customer.id}">
        </div>
        <div>이름
            <input type="text" name="name" value="${customer.name}">
        </div>
        <div>컨택네임
            <input type="text" name="contactName" value="${customer.contactName}">
        </div>
        <div>주소
            <input type="text" name="address" value="${customer.address}">
        </div>
        <div>도시
            <input type="text" name="city" value="${customer.city}">
        </div>
        <div>국가
            <input type="text" name="country" value="${customer.country}">
        </div>
        <div>우편번호
            <input type="text" name="postalCode" value="${customer.postalCode}">
        </div>
        <div>
            <input type="submit" value="수정">
        </div>
    </form>
</c:if>
</body>
</html>
