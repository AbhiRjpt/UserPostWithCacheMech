package com.ranag.rest.bean.request;


import com.ranag.rest.bean.commons.UserData;

public class UserRequestData extends OrgRequestData {
    private UserData userData;

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    @Override
    public String toString() {
        return "UserRequestData{" +
                "userData=" + userData +
                '}';
    }
}
