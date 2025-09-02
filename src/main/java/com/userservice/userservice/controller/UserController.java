package com.userservice.userservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.userservice.userservice.model.User;
import com.userservice.userservice.service.UserService;


@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/{userId}")
    public void removeUser(@PathVariable Long userId) {
        userService.removeByUserId(userId);
    }
}
