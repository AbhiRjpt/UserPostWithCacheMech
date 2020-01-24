package com.ranag.rest.bean.request;

import com.ranag.rest.bean.commons.UserPostData;

public class UserPostRequestData extends OrgRequestData {
    private UserPostData userPostData;

    public UserPostData getUserPostData() {
        return userPostData;
    }

    public void setUserPostData(UserPostData userPostData) {
        this.userPostData = userPostData;
    }

    @Override
    public String toString() {
        return "UserPostRequestData{" +
                "userPostData=" + userPostData +
                '}';
    }
}
