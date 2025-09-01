package com.userservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.userservice.model.User;
import com.userservice.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllPosts() {
        return userRepository.findAll();
    }

    public User addPost(User post) {
        return userRepository.save(post);
    }

    public void removeByUserId(Long userId) {
        userRepository.deleteById(userId);
    }
}
