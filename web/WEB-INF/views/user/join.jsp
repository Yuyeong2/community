<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<div class="flex-container flex-center flex-direction-column">
    <h1>회원가입</h1>
    <div>${requestScope.msg}</div>
    <form action="/user/join" method="post" id="join-frm">
        <div><label>id : <input type="text" name="uid" required></label></div>
        <div><input type="button" value="아이디 중복 체크" id="id-btn-chk"><span id="id-chk-msg"></span></div>
        <div><label>pw : <input type="password" name="upw" required></label></div>
        <div><label>pw-check : <input type="password" id="upw-chk" required></label></div>
        <div><label>name : <input type="text" name="nm" required></label></div>
        <div>
            <label>female <input type="radio" name="gender" value="2" checked></label>
            <label>male <input type="radio" name="gender" value="1"></label>
        </div>
        <div>
            <input type="submit" value="JOIN">
            <input type="reset" value="RESET">
        </div>
    </form>
</div>