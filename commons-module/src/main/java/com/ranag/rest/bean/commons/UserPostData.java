package com.ranag.rest.bean.commons;

public class UserPostData {
    private int postId;
    private int userId;
    private String userText;
    private String imageLink;
    private String created_at;
    private String updated_at;


    public int getPostId() {
        return postId;
    }

    public UserPostData setPostId(int postId) {
        this.postId = postId;
        return this;
    }

    public int getUserId() {
        return userId;
    }

    public UserPostData setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public String getUserText() {
        return userText;
    }

    public UserPostData setUserText(String userText) {
        this.userText = userText;
        return this;
    }

    public String getImageLink() {
        return imageLink;
    }

    public UserPostData setImageLink(String imageLink) {
        this.imageLink = imageLink;
        return this;
    }

    public String getCreated_at() {
        return created_at;
    }

    public UserPostData setCreated_at(String created_at) {
        this.created_at = created_at;
        return this;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public UserPostData setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
        return this;
    }

    @Override
    public String toString() {
        return "UserPostData{" +
                "postId=" + postId +
                ", userId=" + userId +
                ", userText='" + userText + '\'' +
                ", imageLink='" + imageLink + '\'' +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }
}
