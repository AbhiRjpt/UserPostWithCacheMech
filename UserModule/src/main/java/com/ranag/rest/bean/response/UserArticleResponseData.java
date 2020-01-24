package com.ranag.rest.bean.response;

public class UserArticleResponseData extends OrgResponseData{
    private int userId;
    private int artileId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getArtileId() {
        return artileId;
    }

    public void setArtileId(int artileId) {
        this.artileId = artileId;
    }

    @Override
    public String toString() {
        return "UserArticleResponseData{" +
                "userId=" + userId +
                ", artileId=" + artileId +
                '}';
    }
}
