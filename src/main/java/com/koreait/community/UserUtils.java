package com.koreait.community;

import com.koreait.community.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
public class UserUtils {

    @Autowired
    private HttpSession hs;

    public void setLoginUser(UserEntity entity) {
        hs.setAttribute(Const.LOGIN_USER, entity);
    }

    public UserEntity getLoginUser() {
        return (UserEntity)hs.getAttribute(Const.LOGIN_USER);
    }

    public int getLoginUserPk() {
        return getLoginUser() == null ? 0 : getLoginUser().getIuser();
    }
}
