package com.userservice.userservice.errors.Session;

public class SessionNotFoundException extends RuntimeException {
    public SessionNotFoundException(Long sessionId, Exception e) {
        super("Session not found with id: " + sessionId, e);
    }
}