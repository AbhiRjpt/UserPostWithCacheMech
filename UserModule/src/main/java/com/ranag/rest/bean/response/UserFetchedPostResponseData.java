package com.ranag.rest.bean.response;

import com.ranag.rest.bean.commons.UserPostData;

import java.util.List;

public class UserFetchedPostResponseData extends OrgResponseData {
    private List<UserPostData> userPostDataList;

    public List<UserPostData> getUserPostDataList() {
        return userPostDataList;
    }

    public void setUserPostDataList(List<UserPostData> userPostDataList) {
        this.userPostDataList = userPostDataList;
    }

    @Override
    public String toString() {
        return "UserFetchedPostResponseData{" +
                "userPostDataList=" + userPostDataList +
                '}';
    }
}
