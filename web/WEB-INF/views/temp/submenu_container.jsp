
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<div class="submenu-section">
    <div class="p10">
        <ul>
            <li><a href="">프로필</a></li>
            <li><a href="">비밀번호변경</a></li>
        </ul>
    </div>
    <div>
        <tiles:insertAttribute name="content" />
    </div>
</div>
