package com.userservice.userservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.userservice.model.Session;
import com.userservice.userservice.service.SessionService;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final SessionService sessionService;

    public PostController(SessionService postService) {
        this.sessionService = postService;
    }

    @GetMapping
    public List<Session> getAllSessions() {
        return sessionService.getAllSessions();
    }

    @PostMapping
    public Session addSession(@RequestBody Session post) {
        return sessionService.addSession(post);
    }

    @GetMapping("/user/{userId}")
    public List<Session> getSessionsByUser(@PathVariable Long userId) {
        return sessionService.getSessionsByUserId(userId);
    }

    @PutMapping("/user/{userId}")
    public Session updateSession(@PathVariable Long sessionId, @RequestBody Session session) {
        return sessionService.updateSession(sessionId, session);
    }

    @DeleteMapping("{sessionId}")
    public void removeSession(@PathVariable Long sessionId) {
        sessionService.removeSessionById(sessionId);
    }
}
