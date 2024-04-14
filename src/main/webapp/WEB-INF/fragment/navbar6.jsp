<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<style>
    .active {
        background-color: palevioletred;
    }

    a {
        border: 1px solid black;
    }
</style>
<div style="display:flex; justify-content: space-between">
    <div>
        <a class="${param.current eq 'sub10' ? 'active' : ''}" href="/main17/sub10">sub10</a>
        <a class="${param.current eq 'sub11' ? 'active' : ''}" href="/main17/sub11">sub11</a>
        <a class="${param.current eq 'sub12' ? 'active' : ''}" href="/main17/sub12">sub12</a>
    </div>
    <div>
        <c:if test="${not empty sessionScope.userName}" var="loggedIn">
            ${sessionScope.userName}님

            <a href="/main17/sub9">logout</a>
        </c:if>
        <c:if test="${not loggedIn}">
            guest님</c:if>
    </div>
</div>