package com.userservice.userservice.dto;

import com.userservice.userservice.model.Session;

public class SessionDto {
    private Long id;
    private Integer headache;
    private Integer sleepQuality;
    private Integer breathingProblems;
    private Integer noiseLevel;
    private Integer livingConditions;
    private Integer safety;
    private Integer basicNeeds;
    private Integer academicPerformance;
    private Integer studyLoad;
    private Integer teacherStudentRelationship;
    private Integer futureCareerConcerns;
    private Integer socialSupport;
    private Integer peerPressure;
    private Integer extracurricularActivities;
    private Integer bullying;

    public static SessionDto fromEntity(Session session) {
        SessionDto dto = new SessionDto();
        dto.setId(session.getId());
        dto.setHeadache(session.getHeadache());
        dto.setSleepQuality(session.getSleepQuality());
        dto.setBreathingProblems(session.getBreathingProblems());
        dto.setNoiseLevel(session.getNoiseLevel());
        dto.setLivingConditions(session.getLivingConditions());
        dto.setSafety(session.getSafety());
        dto.setBasicNeeds(session.getBasicNeeds());
        dto.setAcademicPerformance(session.getAcademicPerformance());
        dto.setStudyLoad(session.getStudyLoad());
        dto.setTeacherStudentRelationship(session.getTeacherStudentRelationship());
        dto.setFutureCareerConcerns(session.getFutureCareerConcerns());
        dto.setSocialSupport(session.getSocialSupport());
        dto.setPeerPressure(session.getPeerPressure());
        dto.setExtracurricularActivities(session.getExtracurricularActivities());
        dto.setBullying(session.getBullying());
        return dto;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Integer getHeadache() { return headache; }
    public void setHeadache(Integer headache) { this.headache = headache; }
    public Integer getSleepQuality() { return sleepQuality; }
    public void setSleepQuality(Integer sleepQuality) { this.sleepQuality = sleepQuality; }
    public Integer getBreathingProblems() { return breathingProblems; }
    public void setBreathingProblems(Integer breathingProblems) { this.breathingProblems = breathingProblems; }
    public Integer getNoiseLevel() { return noiseLevel; }
    public void setNoiseLevel(Integer noiseLevel) { this.noiseLevel = noiseLevel; }
    public Integer getLivingConditions() { return livingConditions; }
    public void setLivingConditions(Integer livingConditions) { this.livingConditions = livingConditions; }
    public Integer getSafety() { return safety; }
    public void setSafety(Integer safety) { this.safety = safety; }
    public Integer getBasicNeeds() { return basicNeeds; }
    public void setBasicNeeds(Integer basicNeeds) { this.basicNeeds = basicNeeds; }
    public Integer getAcademicPerformance() { return academicPerformance; }
    public void setAcademicPerformance(Integer academicPerformance) { this.academicPerformance = academicPerformance; }
    public Integer getStudyLoad() { return studyLoad; }
    public void setStudyLoad(Integer studyLoad) { this.studyLoad = studyLoad; }
    public Integer getTeacherStudentRelationship() { return teacherStudentRelationship; }
    public void setTeacherStudentRelationship(Integer teacherStudentRelationship) { this.teacherStudentRelationship = teacherStudentRelationship; }
    public Integer getFutureCareerConcerns() { return futureCareerConcerns; }
    public void setFutureCareerConcerns(Integer futureCareerConcerns) { this.futureCareerConcerns = futureCareerConcerns; }
    public Integer getSocialSupport() { return socialSupport; }
    public void setSocialSupport(Integer socialSupport) { this.socialSupport = socialSupport; }
    public Integer getPeerPressure() { return peerPressure; }
    public void setPeerPressure(Integer peerPressure) { this.peerPressure = peerPressure; }
    public Integer getExtracurricularActivities() { return extracurricularActivities; }
    public void setExtracurricularActivities(Integer extracurricularActivities) { this.extracurricularActivities = extracurricularActivities; }
    public Integer getBullying() { return bullying; }
    public void setBullying(Integer bullying) { this.bullying = bullying; }
}