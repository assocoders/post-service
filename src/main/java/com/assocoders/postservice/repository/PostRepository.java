package com.assocoders.postservice.repository;

import com.assocoders.postservice.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
