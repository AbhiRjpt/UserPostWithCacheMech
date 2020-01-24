package com.ranag.rest.bean.response;

public class UserResponseData extends OrgResponseData {
    private int userId;
    private String userName;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    @Override
    public String toString() {
        return "UserResponseData{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
