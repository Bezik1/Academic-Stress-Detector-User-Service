package com.userservice.userservice.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.userservice.userservice.repository.SessionRepository;
import com.userservice.userservice.client.ModelServiceClient;
import com.userservice.userservice.dto.CreateSessionRequest;
import com.userservice.userservice.dto.StressInputDto;
import com.userservice.userservice.dto.UpdateSessionDto;
import com.userservice.userservice.model.Session;
import com.userservice.userservice.model.User;

import com.userservice.userservice.errors.Session.*;
import com.userservice.userservice.errors.User.*;

@Service
public class SessionService {
    private final UserService userService;
    private final SessionRepository sessionRepository;
    private final ModelServiceClient modelServiceClient;

    public SessionService(UserService userService,
                        SessionRepository sessionRepository,
                        ModelServiceClient modelServiceClient) {
        this.userService = userService;
        this.sessionRepository = sessionRepository;
        this.modelServiceClient = modelServiceClient;
    }

    public Session getSessionById(Long sessionId) {
        try {
            return sessionRepository.findById(sessionId)
                    .orElseThrow(() -> new SessionNotFoundException(sessionId, null));
        } catch (DataAccessException e) {
            throw new SessionFetchingException(sessionId, e);
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error while fetching session with id " + sessionId, e);
        }
    }

    public List<Session> getAllSessions() {
        try {
            return sessionRepository.findAll();
        } catch (DataAccessException e) {
            throw new AllSessionsFetchingException(e);
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error while fetching all sessions");
        }
    }

    public Session addSession(CreateSessionRequest request, Long userId) {
        try {
            User user = userService.findById(userId);
            if (user == null) {
                throw new UserNotFoundException(userId, null);
            }

            Session session = new Session();
            session.setUser(user);
            session.setStressLevel(null);
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
        } catch (DataAccessException e) {
            throw new SessionSavingExcepiton(e);
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error while adding session", e);
        }
    }

    public List<Session> getSessionsByUserId(Long userId) {
        try {
            if (userService.findById(userId) == null) {
                throw new UserNotFoundException(userId, null);
            }
            return sessionRepository.findByUserId(userId);
        } catch (DataAccessException e) {
            throw new SessionFetchingException(userId, e);
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error while fetching sessions for user " + userId, e);
        }
    }

    public Session updateSessionData(Long sessionId, UpdateSessionDto newSession) {
        try {
            Session existingSession = sessionRepository.findById(sessionId)
                    .orElseThrow(() -> new SessionNotFoundException(sessionId, null));

            BeanUtils.copyProperties(newSession, existingSession, "id", "user", "stressLevel");

            return sessionRepository.save(existingSession);
        } catch (DataAccessException e) {
            throw new SessionUpdateException(sessionId, null);
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error while updating session with id " + sessionId, e);
        }
    }

    public Session updateSessionResult(Long sessionId, Integer stressLevel) {
        try {
            Session existingSession = sessionRepository.findById(sessionId)
                    .orElseThrow(() -> new SessionNotFoundException(sessionId, null));

            existingSession.setStressLevel(stressLevel);

            return sessionRepository.save(existingSession);
        } catch (DataAccessException e) {
            throw new SessionUpdateException(sessionId, null);
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error while updating session with id " + sessionId, e);
        }
    }

    public void removeSessionById(Long sessionId) {
        try {
            if (!sessionRepository.existsById(sessionId)) {
                throw  new SessionNotFoundException(sessionId, null);
            }
            sessionRepository.deleteById(sessionId);
        } catch (DataAccessException e) {
            throw new SessionRemovalException(sessionId, null);
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error while deleting session with id " + sessionId, e);
        }
    }

    public void predictSessionStress(Long sessionId) {
        try {
            Session session = sessionRepository.findById(sessionId)
                    .orElseThrow(() -> new SessionNotFoundException(sessionId, null));


            if (session.getStressLevel() != null) {
                throw new RuntimeException("Stress level has already been predicted for this session");
            }

            StressInputDto inputDto = new StressInputDto();
            inputDto.setHeadache(session.getHeadache());
            inputDto.setSleepQuality(session.getSleepQuality());
            inputDto.setBreathingProblems(session.getBreathingProblems());
            inputDto.setNoiseLevel(session.getNoiseLevel());
            inputDto.setLivingConditions(session.getLivingConditions());
            inputDto.setSafety(session.getSafety());
            inputDto.setBasicNeeds(session.getBasicNeeds());
            inputDto.setAcademicPerformance(session.getAcademicPerformance());
            inputDto.setStudyLoad(session.getStudyLoad());
            inputDto.setTeacherStudentRelationship(session.getTeacherStudentRelationship());
            inputDto.setFutureCareerConcerns(session.getFutureCareerConcerns());
            inputDto.setSocialSupport(session.getSocialSupport());
            inputDto.setPeerPressure(session.getPeerPressure());
            inputDto.setExtracurricularActivities(session.getExtracurricularActivities());
            inputDto.setBullying(session.getBullying());

            Map<String, Object> modelResponse = modelServiceClient.predictStress(inputDto);

            Integer predictedStressLevel = ((Map<String, Integer>) modelResponse.get("data")).get("stress_level");
            
            session.setStressLevel(predictedStressLevel);
            sessionRepository.save(session);

        } catch (SessionNotFoundException e) {
            throw e;
        } catch (RuntimeException e) {
            throw new RuntimeException("Error predicting stress: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error while predicting stress for session " + sessionId, e);
        }
    }
}