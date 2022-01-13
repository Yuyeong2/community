<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <h1>비밀번호 변경</h1>
    <div class="msg">${msg}</div>
    <form action="/user/mypage/password" id="upwChange" method="post">
        <div><label>현재 비밀번호 : <input type="password" name="currentupw"></label></div>
        <div><label>변경 비밀번호 : <input type="password" name="upw"></label></div>
        <div><label>확인 비밀번호 : <input type="password" id="confirmupw"></label></div>
        <div><input type="submit" value="변경"></div>
    </form>
</div>