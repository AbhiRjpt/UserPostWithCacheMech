package com.ranag.rest.bean.response;

import com.ranag.rest.bean.commons.UserArticleData;

import java.util.List;

public class UserFetchedArticleResponseData extends OrgResponseData{
    private List<UserArticleData> userArticleDataList;

    public List<UserArticleData> getUserArticleDataList() {
        return userArticleDataList;
    }

    public void setUserArticleDataList(List<UserArticleData> userArticleDataList) {
        this.userArticleDataList = userArticleDataList;
    }

    @Override
    public String toString() {
        return "UserFetchedArticleResponseData{" +
                "userArticleDataList=" + userArticleDataList +
                '}';
    }
}
