package com.userservice.userservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.userservice.dto.CreateSessionRequest;
import com.userservice.userservice.model.Session;
import com.userservice.userservice.service.SessionService;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {
    private final SessionService sessionService;

    public SessionController(SessionService postService) {
        this.sessionService = postService;
    }

    @PostMapping
    @PreAuthorize("(#userId.toString() == authentication.name and hasRole('USER')) or hasRole('ADMIN')")
    public Session addSession(@RequestBody CreateSessionRequest request, Authentication authentication) {
        String userIdStr = (String) authentication.getPrincipal();
        Long userId = Long.valueOf(userIdStr);
        return sessionService.addSession(request, userId);
    }
    
    @GetMapping("/user/{userId}")
    @PreAuthorize("(#userId.toString() == authentication.name and hasRole('USER')) or hasRole('ADMIN')")
    public List<Session> getSessionsByUser(@PathVariable Long userId) {
        return sessionService.getSessionsByUserId(userId);
    }

    @PutMapping("/user/{userId}")
    @PreAuthorize("(#userId.toString() == authentication.name and hasRole('USER')) or hasRole('ADMIN')")
    public Session updateSession(@PathVariable Long sessionId, @RequestBody Session session) {
        return sessionService.updateSession(sessionId, session);
    }

    @DeleteMapping("{sessionId}")
    @PreAuthorize("(#userId.toString() == authentication.name and hasRole('USER')) or hasRole('ADMIN')")
    public void removeSession(@PathVariable Long sessionId) {
        sessionService.removeSessionById(sessionId);
    }
}
