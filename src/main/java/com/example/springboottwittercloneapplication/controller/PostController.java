package com.example.springboottwittercloneapplication.controller;

import com.example.springboottwittercloneapplication.dto.CommentDto;
import com.example.springboottwittercloneapplication.dto.PostDto;
import com.example.springboottwittercloneapplication.model.Comment;
import com.example.springboottwittercloneapplication.model.Post;
import com.example.springboottwittercloneapplication.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public String createPost(@RequestParam Long postId, @RequestBody PostDto postDto) {
        return postService.createPost(postDto.getPostBody(), postDto.getUserId());
    }

    @GetMapping
    public Optional<Post> getPostById(@RequestParam Long postId) {
        return postService.getPostById(postId);
    }

    @PatchMapping
    public String editPost(@RequestBody PostDto postDto) {
        return postService.editPost(postDto.getPostId(), postDto.getPostBody());
    }

    @DeleteMapping
    public String deletePost(@RequestParam Long postId) {
        return postService.deletePost(postId);
    }

    @PostMapping("/comment")
    public String createComment(@RequestBody CommentDto commentDto) {
        return postService.createComment(commentDto.getPostId(), commentDto.getUserId(), commentDto.getCommentBody());
    }

    @GetMapping("/comment")
    public Optional<Comment> getCommentById(@RequestParam Long commentId) {
        return postService.getCommentById(commentId);
    }

    @PatchMapping("/comment")
    public String editComment(@RequestBody CommentDto commentDto) {
        return postService.editComment(commentDto.getCommentId(), commentDto.getCommentBody());
    }

    @DeleteMapping("/comment")
    public String deleteComment(@RequestParam Long commentId) {
        return postService.deleteComment(commentId);
    }
}
