package com.userservice.userservice.errors.Session;

public class AllSessionsFetchingException extends RuntimeException {
    public AllSessionsFetchingException(Exception e) {
        super("Failed to fetch all sessions", e);
    }
}
