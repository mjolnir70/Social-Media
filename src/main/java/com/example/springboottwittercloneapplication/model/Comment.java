package com.example.springboottwittercloneapplication.model;

import jakarta.persistence.*;

@Entity
public class Comment{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String commentBody;
    @ManyToOne
    private Post post;
    @ManyToOne
    private User user;

    public void setId(long id) {
        this.id = id;
    }
    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }
    public void setPost(Post post) {
        this.post = post;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }
    public String getCommentBody() {
        return commentBody;
    }
    public Post getPost() {
        return post;
    }
    public User getUser() {
        return user;
    }
}
