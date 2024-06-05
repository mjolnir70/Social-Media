package com.example.springboottwittercloneapplication.service;

import com.example.springboottwittercloneapplication.model.Comment;
import com.example.springboottwittercloneapplication.model.Post;
import com.example.springboottwittercloneapplication.repository.CommentRepository;
import com.example.springboottwittercloneapplication.repository.PostRepository;
import com.example.springboottwittercloneapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getPostById(Long postId) {
        return postRepository.findById(postId);
    }

    public String createPost(String postBody, Long userId) {
        return userRepository.findById(userId).map(user -> {
            Post post = new Post();
            post.setPostBody(postBody);
            post.setUser(user);
            post.setDate(new Date());
            postRepository.save(post);
            return "Post created successfully";
        }).orElse("User does not exist");
    }

    public String editPost(Long postId, String postBody) {
        return postRepository.findById(postId).map(post -> {
            post.setPostBody(postBody);
            postRepository.save(post);
            return "Post edited successfully";
        }).orElse("Post does not exist");
    }

    public String deletePost(Long postId) {
        return postRepository.findById(postId).map(post -> {
            postRepository.delete(post);
            return "Post deleted";
        }).orElse("Post does not exist");
    }

    public String createComment(Long postId, Long userId, String commentBody) {
        return postRepository.findById(postId).map(post -> {
            return userRepository.findById(userId).map(user -> {
                Comment comment = new Comment();
                comment.setCommentBody(commentBody);
                comment.setPost(post);
                comment.setUser(user);
                commentRepository.save(comment);
                return "Comment created successfully";
            }).orElse("User does not exist");
        }).orElse("Post does not exist");
    }

    public Optional<Comment> getCommentById(Long commentId) {
        return commentRepository.findById(commentId);
    }

    public String editComment(Long commentId, String commentBody) {
        return commentRepository.findById(commentId).map(comment -> {
            comment.setCommentBody(commentBody);
            commentRepository.save(comment);
            return "Comment edited successfully";
        }).orElse("Comment does not exist");
    }

    public String deleteComment(Long commentId) {
        return commentRepository.findById(commentId).map(comment -> {
            commentRepository.delete(comment);
            return "Comment deleted";
        }).orElse("Comment does not exist");
    }
}
