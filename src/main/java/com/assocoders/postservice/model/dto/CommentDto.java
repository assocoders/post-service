package com.assocoders.postservice.model.dto;

import java.time.LocalDateTime;

public record CommentDto(
        String authorFirstName,
        String authorLastName,
        LocalDateTime createdAt,
        String body,
        Long likes) {
}
