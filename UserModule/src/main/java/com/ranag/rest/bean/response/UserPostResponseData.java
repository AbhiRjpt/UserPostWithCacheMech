package com.ranag.rest.bean.response;

public class UserPostResponseData extends OrgResponseData {
    private int userId;
    private int postId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "UserPostResponseData{" +
                "userId=" + userId +
                ", postId=" + postId +
                '}';
    }
}
