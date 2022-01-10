<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>로그인</h1>
<div>${requestScope.msg}</div>
<form action="/user/login" method="post" id="login_frm">
    <div><label>id : <input type="text" name="uid" value="${requestScope.tryLogin.uid}"></label></div>
    <div><label>password : <input type="password" name="upw"></label></div>
    <div>
        <input type="submit" value="LOGIN">
    </div>
</form>
<div><a href="/user/join">join</a></div>