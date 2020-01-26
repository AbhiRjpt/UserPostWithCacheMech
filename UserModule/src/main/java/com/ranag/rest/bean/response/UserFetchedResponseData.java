package com.ranag.rest.bean.response;

import com.ranag.rest.bean.commons.UserData;

import java.util.List;

public class UserFetchedResponseData extends OrgResponseData {
    List<UserData> userDataList;

    public List<UserData> getUserDataList() {
        return userDataList;
    }

    public void setUserDataList(List<UserData> userDataList) {
        this.userDataList = userDataList;
    }

    @Override
    public String toString() {
        return "UserFetchedResponseData{" +
                "userDataList=" + userDataList +
                '}';
    }
}
