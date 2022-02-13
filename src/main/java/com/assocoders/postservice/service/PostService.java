package com.assocoders.postservice.service;

import com.assocoders.postservice.model.dto.PostRequest;
import com.assocoders.postservice.model.dto.PostResponse;
import com.assocoders.postservice.model.dto.User;
import com.assocoders.postservice.model.entity.Post;
import com.assocoders.postservice.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Collections;

@Service
public record PostService(PostRepository postRepository, RestTemplate restTemplate) {

    public PostResponse createNewPost(PostRequest postRequest) {
        User user = getCurrentUserFromUserService();

        Post post = Post.builder()
                .authorId(user.userId())
                .title(postRequest.title())
                .body(postRequest.body())
                .createdAt(LocalDateTime.now())
                .likes(0L)
                .comments(Collections.emptyList())
                .build();
        if (post.isComplete()) {
            postRepository.save(post);
        } else {
            throw new NullPointerException("Fields cannot be empty!");
        }
        return new PostResponse(post.getTitle(), user.firstName(), user.lastName(), post.getCreatedAt(), post.getBody(), post.getLikes(), post.getComments());
    }

    private User getCurrentUserFromUserService() {
        return restTemplate.getForObject("http://user-service/user/loggedInUser", User.class);
    }
}
