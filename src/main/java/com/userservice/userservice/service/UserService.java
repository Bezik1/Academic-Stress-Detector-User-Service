package com.userservice.userservice.service;

import org.springframework.stereotype.Service;

import com.userservice.userservice.repository.UserRepository;
import com.userservice.userservice.errors.UserWithUsernameNotFoundException;
import com.userservice.userservice.errors.User.UserNotFoundException;
import com.userservice.userservice.model.User;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
            .orElseThrow(() -> new UserWithUsernameNotFoundException(username, null));
    }

    public User findById(Long userId) {
        return userRepository.findById(userId)
            .orElseThrow(() -> new UserNotFoundException(userId, null));
    }

    public void removeByUserId(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new UserNotFoundException(userId, null);
        }
        userRepository.deleteById(userId);
    }

    public User updateUser(Long userId, String email, String username) {
        User existing = findById(userId);
        if (email != null && !email.isEmpty()) existing.setEmail(email);
        if (username != null && !username.isEmpty()) existing.setUsername(username);
        return userRepository.save(existing);
    }
}