package com.userservice.userservice.errors.User;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long userId, Exception e) {
        super("User not found with id: " + userId, e);
    }
}