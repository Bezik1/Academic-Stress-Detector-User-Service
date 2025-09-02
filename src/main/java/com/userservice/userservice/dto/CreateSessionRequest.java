package com.userservice.userservice.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class CreateSessionRequest {

    @NotNull @Min(0) @Max(5)
    private Integer headache;

    @NotNull @Min(0) @Max(5)
    private Integer sleepQuality;

    @NotNull @Min(0) @Max(5)
    private Integer breathingProblems;

    @NotNull @Min(0) @Max(5)
    private Integer noiseLevel;

    @NotNull @Min(0) @Max(5)
    private Integer livingConditions;

    @NotNull @Min(0) @Max(5)
    private Integer safety;

    @NotNull @Min(0) @Max(5)
    private Integer basicNeeds;

    @NotNull @Min(0) @Max(5)
    private Integer academicPerformance;

    @NotNull @Min(0) @Max(5)
    private Integer studyLoad;

    @NotNull @Min(0) @Max(5)
    private Integer teacherStudentRelationship;

    @NotNull @Min(0) @Max(5)
    private Integer futureCareerConcerns;

    @NotNull @Min(0) @Max(3)
    private Integer socialSupport;

    @NotNull @Min(0) @Max(5)
    private Integer peerPressure;

    @NotNull @Min(0) @Max(5)
    private Integer extracurricularActivities;

    @NotNull @Min(0) @Max(5)
    private Integer bullying;

    public CreateSessionRequest() {}

    public Integer getHeadache() {
        return headache;
    }

    public void setHeadache(Integer headache) {
        this.headache = headache;
    }

    public Integer getSleepQuality() {
        return sleepQuality;
    }

    public void setSleepQuality(Integer sleepQuality) {
        this.sleepQuality = sleepQuality;
    }

    public Integer getBreathingProblems() {
        return breathingProblems;
    }

    public void setBreathingProblems(Integer breathingProblems) {
        this.breathingProblems = breathingProblems;
    }

    public Integer getNoiseLevel() {
        return noiseLevel;
    }

    public void setNoiseLevel(Integer noiseLevel) {
        this.noiseLevel = noiseLevel;
    }

    public Integer getLivingConditions() {
        return livingConditions;
    }

    public void setLivingConditions(Integer livingConditions) {
        this.livingConditions = livingConditions;
    }

    public Integer getSafety() {
        return safety;
    }

    public void setSafety(Integer safety) {
        this.safety = safety;
    }

    public Integer getBasicNeeds() {
        return basicNeeds;
    }

    public void setBasicNeeds(Integer basicNeeds) {
        this.basicNeeds = basicNeeds;
    }

    public Integer getAcademicPerformance() {
        return academicPerformance;
    }

    public void setAcademicPerformance(Integer academicPerformance) {
        this.academicPerformance = academicPerformance;
    }

    public Integer getStudyLoad() {
        return studyLoad;
    }

    public void setStudyLoad(Integer studyLoad) {
        this.studyLoad = studyLoad;
    }

    public Integer getTeacherStudentRelationship() {
        return teacherStudentRelationship;
    }

    public void setTeacherStudentRelationship(Integer teacherStudentRelationship) {
        this.teacherStudentRelationship = teacherStudentRelationship;
    }

    public Integer getFutureCareerConcerns() {
        return futureCareerConcerns;
    }

    public void setFutureCareerConcerns(Integer futureCareerConcerns) {
        this.futureCareerConcerns = futureCareerConcerns;
    }

    public Integer getSocialSupport() {
        return socialSupport;
    }

    public void setSocialSupport(Integer socialSupport) {
        this.socialSupport = socialSupport;
    }

    public Integer getPeerPressure() {
        return peerPressure;
    }

    public void setPeerPressure(Integer peerPressure) {
        this.peerPressure = peerPressure;
    }

    public Integer getExtracurricularActivities() {
        return extracurricularActivities;
    }

    public void setExtracurricularActivities(Integer extracurricularActivities) {
        this.extracurricularActivities = extracurricularActivities;
    }

    public Integer getBullying() {
        return bullying;
    }

    public void setBullying(Integer bullying) {
        this.bullying = bullying;
    }

    
}