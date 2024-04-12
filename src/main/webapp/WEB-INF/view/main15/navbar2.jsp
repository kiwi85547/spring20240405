<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<style>
    .active{
        background-color: yellow;
    }
</style>
<div>
<%--    <span>${current1}</span>--%>
<%--    <span>${current2}</span>--%>
    <a href="/main/15/sub3">
        <span class="${current2 eq 'sub3' ? 'active': ''}" style="border:1px solid black">sub3</span>
    </a>
    <a href="/main/15/sub4">
        <span class="${current2 eq 'sub4' ? 'active': ''}" style="border:1px solid black">sub4</span>
    </a>
</div>
</body>
</html>
request 요청에 대한 처리를 진행중이라면..