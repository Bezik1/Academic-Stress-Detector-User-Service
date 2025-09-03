package com.userservice.userservice.errors.Session;

public class SessionSavingExcepiton extends RuntimeException {
    public SessionSavingExcepiton(Exception e) {
        super("Failed to save session", e);
    }
}