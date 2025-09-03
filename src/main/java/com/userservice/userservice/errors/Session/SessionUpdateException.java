package com.userservice.userservice.errors.Session;

public class SessionUpdateException extends RuntimeException {
    public SessionUpdateException(Long sessionId, Exception e) {
        super("Failed to update session with id " + sessionId, e);
    }
}