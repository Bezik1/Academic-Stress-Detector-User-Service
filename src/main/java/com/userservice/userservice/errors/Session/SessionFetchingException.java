package com.userservice.userservice.errors.Session;

public class SessionFetchingException extends RuntimeException {
    public SessionFetchingException(Long userId, Exception e) {
        super("Failed to fetch sessions for user with id " + userId, e);
    }
}