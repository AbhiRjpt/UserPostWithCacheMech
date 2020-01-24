package com.ranag.rest.bean.request;

import com.ranag.rest.bean.commons.UserArticleData;

public class UserArticleRequestData extends OrgRequestData {
    private UserArticleData userArticleData;

    public UserArticleData getUserArticleData() {
        return userArticleData;
    }

    public void setUserArticleData(UserArticleData userArticleData) {
        this.userArticleData = userArticleData;
    }

    @Override
    public String toString() {
        return "UserArticleRequestData{" +
                "userArticleData=" + userArticleData +
                '}';
    }
}
