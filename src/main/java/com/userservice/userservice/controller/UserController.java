package com.userservice.userservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.userservice.userservice.dto.UserDto;
import com.userservice.userservice.errors.User.UserNotFoundException;
import com.userservice.userservice.model.User;
import com.userservice.userservice.service.UserService;


@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<?> getCurrentUser(Authentication authentication) {
        try {
            Long principalId = Long.valueOf(authentication.getPrincipal().toString());
            User user = userService.findById(principalId);
            return ResponseEntity.ok(new UserDto(user));
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{userId}")
    @PreAuthorize("@security.isOwner(authentication, #userId) or @security.isAdmin(authentication)")
    public ResponseEntity<?> removeUser(@PathVariable Long userId) {
        try {
            userService.removeByUserId(userId);
            return ResponseEntity.noContent().build();
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{userId}")
    @PreAuthorize("@security.isOwner(authentication, #userId) or @security.isAdmin(authentication)")
    public ResponseEntity<?> updateUser(
            @PathVariable Long userId,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String username) {
        try {
            User updated = userService.updateUser(userId, email, username);
            return ResponseEntity.ok(new UserDto(updated));
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}