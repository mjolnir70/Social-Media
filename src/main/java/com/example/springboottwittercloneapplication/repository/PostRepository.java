package com.example.springboottwittercloneapplication.repository;

import com.example.springboottwittercloneapplication.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
