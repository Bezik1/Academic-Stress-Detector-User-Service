package com.userservice.userservice.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.userservice.userservice.repository.SessionRepository;
import com.userservice.userservice.model.Session;

@Service
public class SessionService {
    private final SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    public Session addSession(Session post) {
        return sessionRepository.save(post);
    }

    public List<Session> getSessionsByUserId(Long userId) {
        return sessionRepository.findByUserId(userId);
    }

    public Session updateSession(Long sessionId, Session newSession) {
        Session existingSession = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found with id " + sessionId));

        BeanUtils.copyProperties(newSession, existingSession, "id");

        return sessionRepository.save(existingSession);
    }

    public void removeSessionById(Long sessionId) {
        sessionRepository.deleteById(sessionId);
    }
}
