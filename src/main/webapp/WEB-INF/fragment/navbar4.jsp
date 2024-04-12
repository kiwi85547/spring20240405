<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<style>
    .active{
        background-color: yellow;
        font-size: 1.4rem;
    }
    a{
        border:1px solid black;
    }
</style>
<div style="display: flex; justify-content: space-between;">
    <div>
        <a class="${param.current eq 'sub6' ? 'active' : ''}" href="/main/sub6">sub6</a>
        <a class="${param.current eq 'sub7' ? 'active' : ''}" href="/main/sub7">sub7</a>
        <a class="${param.current eq 'sub8' ? 'active' : ''}" href="/main/sub8">sub8</a>
    </div>
    <div>
        <c:if test="${not empty sessionScope.userName}" var="loggedIn">
            ${sessionScope.userName}님
        </c:if>
        <c:if test="${not loggedIn}">guest님</c:if>
    </div>
</div>
