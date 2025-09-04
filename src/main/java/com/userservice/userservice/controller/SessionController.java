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
import com.userservice.userservice.dto.StressInputDto;
import com.userservice.userservice.dto.UpdateSessionDto;
import com.userservice.userservice.errors.Session.SessionNotFoundException;
import com.userservice.userservice.model.Session;
import com.userservice.userservice.service.SessionService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {
    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping("/auth-test")
    public ResponseEntity<?> authTest(Authentication authentication) {
        System.out.println("Principal: " + authentication.getPrincipal());
        System.out.println("Authorities: " + authentication.getAuthorities());
        return ResponseEntity.ok(authentication.getAuthorities());
    }

    @GetMapping
    @PreAuthorize("@security.isAdmin(authentication)")
    public ResponseEntity<?> getSessions() {
        try {
            return ResponseEntity.ok(sessionService.getAllSessions());
        } catch(Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping("/user/{userId}")
    @PreAuthorize("@security.isOwner(authentication, #userId) or @security.isAdmin(authentication)")
    public ResponseEntity<?> addSession(@PathVariable Long userId,
                                        @Valid @RequestBody CreateSessionRequest request) {
        try {
            Session session = sessionService.addSession(request, userId);
            return ResponseEntity.ok(SessionDto.fromEntity(session));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
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
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping("updateData/{sessionId}")
    @PreAuthorize("@security.isSessionOwner(authentication, #sessionId) or @security.isAdmin(authentication)")
    public ResponseEntity<?> updateSessionData(@PathVariable Long sessionId, @RequestBody UpdateSessionDto session) {
        try {
            Session updated = sessionService.updateSessionData(sessionId, session);
            return ResponseEntity.ok(SessionDto.fromEntity(updated));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping("updateResult/{sessionId}")
    @PreAuthorize("@security.isSessionOwner(authentication, #sessionId) or @security.isAdmin(authentication)")
    public ResponseEntity<?> updateSessionREsult(@PathVariable Long sessionId,
                                                @RequestParam @Min(0) @Max(2) Integer stressLevel) {
        try {
            Session updated = sessionService.updateSessionResult(sessionId, stressLevel);
            return ResponseEntity.ok(SessionDto.fromEntity(updated));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping("/{sessionId}")
    @PreAuthorize("@security.isSessionOwner(authentication, #sessionId)")
    public ResponseEntity<?> removeSession(@PathVariable Long sessionId) {
        try {
            sessionService.removeSessionById(sessionId);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
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
            return ResponseEntity.status(403).body(Map.of(
                    "status", 403,
                    "message", "Unauthorized or session does not belong to user",
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