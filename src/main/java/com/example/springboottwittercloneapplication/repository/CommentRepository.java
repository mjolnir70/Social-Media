package com.example.springboottwittercloneapplication.repository;

import com.example.springboottwittercloneapplication.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
