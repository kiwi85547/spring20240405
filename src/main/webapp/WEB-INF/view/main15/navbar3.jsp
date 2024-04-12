<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<style>
    .menu-item{
        border:1px solid black;
    }
    .active{
        font-style: italic;
        background-color: chartreuse;
    }

</style>
<div>
    <a href="/main15/sub5">
        <span class="${cur eq 'sub5' ? 'active' : ''}">sub5</span>
    </a>
    <a href="/main15/sub6">
        <span class="${cur eq 'sub6' ? 'active' : ''}">sub6</span>
    </a>
</div>
