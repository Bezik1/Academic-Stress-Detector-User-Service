package com.userservice.userservice.errors;

public class UserWithUsernameNotFoundException extends RuntimeException{
    public UserWithUsernameNotFoundException(String username, Exception e) {
        super("Cannot find user, with username: " + username, e);
    }
}
