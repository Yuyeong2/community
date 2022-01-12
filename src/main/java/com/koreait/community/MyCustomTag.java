package com.koreait.community;

public class MyCustomTag {

    public static String profileImg(String idVal, String classVal, String iuser, String profileImgVal) {
        String fixProfileImgVal = "/res/img/defaultProfile.png";
        if(profileImgVal != null) {
            fixProfileImgVal = String.format("/images/user/%s/%s", iuser, profileImgVal);
        }
        return String.format("<div id=\"%s\" class=\"%s\"><img src=\"%s\"></div>", idVal, classVal, fixProfileImgVal);
    }
}