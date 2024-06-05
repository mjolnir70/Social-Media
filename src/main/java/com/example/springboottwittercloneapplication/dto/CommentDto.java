package com.example.springboottwittercloneapplication.dto;

public class CommentDto {
    private Long commentId;
    private String commentBody;
    private Long postId;
    private Long userId;

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCommentId() {
        return commentId;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public Long getPostId() {
        return postId;
    }

    public Long getUserId() {
        return userId;
    }


}
