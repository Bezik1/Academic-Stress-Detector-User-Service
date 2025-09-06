package com.userservice.userservice.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.userservice.userservice.dto.CreateSessionRequest;
import com.userservice.userservice.dto.SessionDto;
import com.userservice.userservice.errors.Session.SessionNotFoundException;
import com.userservice.userservice.errors.User.UserNotFoundException;
import com.userservice.userservice.model.Session;
import com.userservice.userservice.service.SessionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {
    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping("/auth-test")
    public ResponseEntity<?> authTest(Authentication authentication) {
        return ResponseEntity.ok(Map.of(
                "principal", authentication.getPrincipal(),
                "authorities", authentication.getAuthorities()
        ));
    }

    @GetMapping
    @PreAuthorize("@security.isAdmin(authentication)")
    public ResponseEntity<?> getSessions() {
        try {
            return ResponseEntity.ok(sessionService.getAllSessions());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of(
                    "status", 500,
                    "message", "Failed to fetch sessions",
                    "error", e.getMessage()
            ));
        }
    }

    @PostMapping("/user/{userId}")
    @PreAuthorize("@security.isOwner(authentication, #userId) or @security.isAdmin(authentication)")
    public ResponseEntity<?> addSession(@PathVariable Long userId,
                                        @Valid @RequestBody CreateSessionRequest request) {
        try {
            Session session = sessionService.addSession(request, userId);
            return ResponseEntity.ok(SessionDto.fromEntity(session));
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(404).body(Map.of(
                    "status", 404,
                    "message", "User not found",
                    "error", e.getMessage()
            ));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of(
                    "status", 500,
                    "message", "Failed to add session",
                    "error", e.getMessage()
            ));
        }
    }

    @GetMapping("/user/{userId}")
    @PreAuthorize("@security.isOwner(authentication, #userId) or @security.isAdmin(authentication)")
    public ResponseEntity<?> getSessionsByUser(@PathVariable Long userId) {
        try {
            List<Session> sessions = sessionService.getSessionsByUserId(userId);
            List<SessionDto> result = sessions.stream()
                    .map(SessionDto::fromEntity)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(result);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(404).body(Map.of(
                    "status", 404,
                    "message", "User not found",
                    "error", e.getMessage()
            ));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of(
                    "status", 500,
                    "message", "Failed to fetch sessions for user",
                    "error", e.getMessage()
            ));
        }
    }

    @DeleteMapping("/{sessionId}")
    @PreAuthorize("@security.isSessionOwner(authentication, #sessionId)")
    public ResponseEntity<?> removeSession(@PathVariable Long sessionId) {
        try {
            sessionService.removeSessionById(sessionId);
            return ResponseEntity.noContent().build();
        } catch (SessionNotFoundException e) {
            return ResponseEntity.status(404).body(Map.of(
                    "status", 404,
                    "message", "Session not found",
                    "error", e.getMessage()
            ));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of(
                    "status", 500,
                    "message", "Failed to delete session",
                    "error", e.getMessage()
            ));
        }
    }

    @PostMapping("/predict/{sessionId}")
    @PreAuthorize("@security.isSessionOwner(authentication, #sessionId) or @security.isAdmin(authentication)")
    public ResponseEntity<?> predictSessionStress(@PathVariable Long sessionId) {
        try {
            sessionService.predictSessionStress(sessionId);
            return ResponseEntity.ok(Map.of(
                    "status", 200,
                    "message", "Stress level predicted and saved successfully"
            ));
        } catch (SessionNotFoundException e) {
            return ResponseEntity.status(404).body(Map.of(
                    "status", 404,
                    "message", "Session not found",
                    "error", e.getMessage()
            ));
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(Map.of(
                    "status", 400,
                    "message", "Cannot predict stress",
                    "error", e.getMessage()
            ));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of(
                    "status", 500,
                    "message", "Internal server error",
                    "error", e.getMessage()
            ));
        }
    }
}