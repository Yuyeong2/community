package com.koreait.community;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class MyCustomJstlTag extends SimpleTagSupport {
    private String idVal;
    private String classVal;
    private int iuser;
    private String profileImgVal;

    public MyCustomJstlTag() {
        this.idVal = "";
        this.classVal = "";
        this.iuser = 0;
        this.profileImgVal = "";
    }

    public void setIdVal(String idVal) {
        this.idVal = idVal;
    }

    public void setClassVal(String classVal) {
        this.classVal = classVal;
    }

    public void setIuser(int iuser) {
        this.iuser = iuser;
    }

    public void setProfileImgVal(String profileImgVal) {
        this.profileImgVal = profileImgVal;
    }

    @Override
    public void doTag() throws JspException, IOException {
        try {
            String fixProfileImgVal = "/res/img/defaultProfile.png";
            if(profileImgVal != null) {
                fixProfileImgVal = String.format("/images/user/%s/%s", iuser, profileImgVal);
            }
            String result = String.format("<div id=\"%s\" class=\"%s\"><img src=\"%s\"></div>", idVal, classVal, fixProfileImgVal);

            getJspContext().getOut().write(result);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SkipPageException("Exception in MyCustomJstlTag");
        }
    }
}