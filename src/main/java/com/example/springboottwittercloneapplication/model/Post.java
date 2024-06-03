package com.example.springboottwittercloneapplication.model;

import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String postBody;
    private LocalDateTime date;
    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<com.example.springboottwittercloneapplication.model.Comment> comments;

    public void setId(long id) {
        this.id = id;
    }
    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public long getId() {
        return id;
    }
    public String getPostBody() {
        return postBody;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public User getUser() {
        return user;
    }
    public List<Comment> getComments() {
        return comments;
    }
}
