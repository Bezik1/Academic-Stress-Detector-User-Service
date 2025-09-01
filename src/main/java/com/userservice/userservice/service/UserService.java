package com.userservice.userservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.userservice.userservice.repository.UserRepository;
import com.userservice.userservice.model.User;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(User post) {
        return userRepository.save(post);
    }

    public void removeByUserId(Long userId) {
        userRepository.deleteById(userId);
    }
}
