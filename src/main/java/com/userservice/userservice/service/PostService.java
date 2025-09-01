package com.userservice.userservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.userservice.userservice.repository.PostRepository;
import com.userservice.userservice.model.Post;


@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    public List<Post> getPostsByUser(Long userId) {
        return postRepository.findByUserId(userId);
    }
}
