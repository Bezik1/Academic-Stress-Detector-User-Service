package com.userservice.userservice.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.userservice.userservice.repository.UserRepository;
import com.userservice.userservice.model.User;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User registerUser(String username, String email, String password) {
        String hashedPassword = passwordEncoder.encode(password);

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(hashedPassword);

        return userRepository.save(user);
    }

    public void login(String email, String password) {
        
    }

    public void removeByUserId(Long userId) {
        userRepository.deleteById(userId);
    }
}
