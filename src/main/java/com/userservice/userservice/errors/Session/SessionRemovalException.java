package com.userservice.userservice.errors.Session;

public class SessionRemovalException extends RuntimeException {
    public SessionRemovalException(Long sessionId, Exception e) {
        super("Failed to remove session with id " + sessionId, e);
    }
}