package com.example.springboottwittercloneapplication.dto;

public class PostDto {
    private Long postId;
    private String postBody;
    private Long userId;

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPostId() {
        return postId;
    }

    public String getPostBody() {
        return postBody;
    }

    public Long getUserId() {
        return userId;
    }

}
