<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="profileImg" value="/res/img/defaultProfile.png" />
<c:if test="${sessionScope.loginUser.profileimg != null}">
    <c:set var="profileImg" value="/images/user/${sessionScope.loginUser.iuser}/${sessionScope.loginUser.profileimg}" />
</c:if>
<div id="data" data-iuser="${sessionScope.loginUser.iuser}"></div>
<div class="flex-container flex-direction-column flex-align-center">
    <div id="profile-view" class="pointer circular--img wh-300"><img src="${profileImg}"></div>
    <input type="file" id="profile-file" class="hidden" accept="image/*">
    <div>아이디: ${sessionScope.loginUser.uid}</div>
    <div>이름: ${sessionScope.loginUser.nm}</div>
    <div>성별: ${sessionScope.loginUser.gender == 1 ? '남성' : '여성'}</div>
</div>