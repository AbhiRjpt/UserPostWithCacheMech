package com.ranag.rest.bean.commons;

public class UserData {
    private int userId;
    private String user_name;
    private String email;
    private String password;
    private String created_at;
    private String updated_at;

    public int getUserId() {
        return userId;
    }

    public UserData setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public String getUser_name() {
        return user_name;
    }

    public UserData setUser_name(String user_name) {
        this.user_name = user_name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserData setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserData setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getCreated_at() {
        return created_at;
    }

    public UserData setCreated_at(String created_at) {
        this.created_at = created_at;
        return this;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public UserData setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
        return this;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "userId=" + userId +
                ", user_name='" + user_name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }
}
