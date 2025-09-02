package com.userservice.userservice.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.userservice.userservice.repository.SessionRepository;
import com.userservice.userservice.dto.CreateSessionRequest;
import com.userservice.userservice.model.Session;
import com.userservice.userservice.model.User;

@Service
public class SessionService {
    private final UserService userService;
    private final SessionRepository sessionRepository;

    public SessionService(UserService userService, SessionRepository sessionRepository) {
        this.userService = userService;
        this.sessionRepository = sessionRepository;
    }

    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    public Session addSession(CreateSessionRequest request, Long userId) {
        User user = userService.findById(userId);

        Session session = new Session();
        session.setUser(user);
        session.setHeadache(request.getHeadache());
        session.setSleepQuality(request.getSleepQuality());
        session.setBreathingProblems(request.getBreathingProblems());
        session.setNoiseLevel(request.getNoiseLevel());
        session.setLivingConditions(request.getLivingConditions());
        session.setSafety(request.getSafety());
        session.setBasicNeeds(request.getBasicNeeds());
        session.setAcademicPerformance(request.getAcademicPerformance());
        session.setStudyLoad(request.getStudyLoad());
        session.setTeacherStudentRelationship(request.getTeacherStudentRelationship());
        session.setFutureCareerConcerns(request.getFutureCareerConcerns());
        session.setSocialSupport(request.getSocialSupport());
        session.setPeerPressure(request.getPeerPressure());
        session.setExtracurricularActivities(request.getExtracurricularActivities());
        session.setBullying(request.getBullying());

        return sessionRepository.save(session);
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
