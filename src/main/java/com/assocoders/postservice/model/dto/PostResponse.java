package com.assocoders.postservice.model.dto;


import com.assocoders.postservice.model.entity.Comment;

import java.time.LocalDateTime;
import java.util.List;

public record PostResponse(
        String title,
        String authorFirstName,
        String authorLastName,
        LocalDateTime createdAt,
        String body,
        Long likes,
        List<Comment> comments) {
}
