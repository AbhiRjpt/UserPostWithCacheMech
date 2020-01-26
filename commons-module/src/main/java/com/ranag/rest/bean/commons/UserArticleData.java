package com.ranag.rest.bean.commons;

public class UserArticleData {
    private int articleId;
    private int userId;
    private String article_title;
    private String article_text;
    private String article_image;
    private String created_at;
    private String updated_at;


    public int getArticleId() {
        return articleId;
    }

    public UserArticleData setArticleId(int articleId) {
        this.articleId = articleId;
        return this;
    }

    public int getUserId() {
        return userId;
    }

    public UserArticleData setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public String getArticle_title() {
        return article_title;
    }

    public UserArticleData setArticle_title(String article_title) {
        this.article_title = article_title;
        return this;
    }

    public String getArticle_text() {
        return article_text;
    }

    public UserArticleData setArticle_text(String article_text) {
        this.article_text = article_text;
        return this;
    }

    public String getArticle_image() {
        return article_image;
    }

    public UserArticleData setArticle_image(String article_image) {
        this.article_image = article_image;
        return this;
    }

    public String getCreated_at() {
        return created_at;
    }

    public UserArticleData setCreated_at(String created_at) {
        this.created_at = created_at;
        return this;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public UserArticleData setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
        return this;
    }

    @Override
    public String toString() {
        return "UserArticleData{" +
                "articleId=" + articleId +
                ", userId=" + userId +
                ", article_title='" + article_title + '\'' +
                ", article_text='" + article_text + '\'' +
                ", article_image='" + article_image + '\'' +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }
}
