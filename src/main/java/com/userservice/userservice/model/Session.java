package com.userservice.userservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
@Table(name = "session")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Min(0)
    @Max(5)
    @NotNull
    @Column(name = "headache", nullable = false)
    private Integer headache;

    @Min(0)
    @Max(5)
    @NotNull
    @Column(name = "sleep_quality", nullable = false)
    private Integer sleepQuality;

    @Min(0)
    @Max(5)
    @NotNull
    @Column(name = "breathing_problems", nullable = false)
    private Integer breathingProblems;

    @Min(0)
    @Max(5)
    @NotNull
    @Column(name = "noise_level", nullable = false)
    private Integer noiseLevel;

    @Min(0)
    @Max(5)
    @NotNull
    @Column(name = "living_conditions", nullable = false)
    private Integer livingConditions;

    @Min(0)
    @Max(5)
    @NotNull
    @Column(name = "safety", nullable = false)
    private Integer safety;

    @Min(0)
    @Max(5)
    @NotNull
    @Column(name = "basic_needs", nullable = false)
    private Integer basicNeeds;

    @Min(0)
    @Max(5)
    @NotNull
    @Column(name = "academic_performance", nullable = false)
    private Integer academicPerformance;

    @Min(0)
    @Max(5)
    @NotNull
    @Column(name = "study_load", nullable = false)
    private Integer studyLoad;

    @Min(0)
    @Max(5)
    @NotNull
    @Column(name = "teacher_student_relationship", nullable = false)
    private Integer teacherStudentRelationship;

    @Min(0)
    @Max(5)
    @NotNull
    @Column(name = "future_career_concerns", nullable = false)
    private Integer futureCareerConcerns;

    @Min(0)
    @Max(5)
    @NotNull
    @Column(name = "social_support", nullable = false)
    private Integer socialSupport;

    @Min(0)
    @Max(5)
    @NotNull
    @Column(name = "peer_pressure", nullable = false)
    private Integer peerPressure;

    @Min(0)
    @Max(5)
    @NotNull
    @Column(name = "extracurricular_activities", nullable = false)
    private Integer extracurricularActivities;

    @Min(0)
    @Max(5)
    @NotNull
    @Column(name = "bullying", nullable = false)
    private Integer bullying;

    public Session() {}

    public Session(Long userId, @Min(0) @Max(5) @NotNull Integer headache,
            @Min(0) @Max(5) @NotNull Integer sleepQuality, @Min(0) @Max(5) @NotNull Integer breathingProblems,
            @Min(0) @Max(5) @NotNull Integer noiseLevel, @Min(0) @Max(5) @NotNull Integer livingConditions,
            @Min(0) @Max(5) @NotNull Integer safety, @Min(0) @Max(5) @NotNull Integer basicNeeds,
            @Min(0) @Max(5) @NotNull Integer academicPerformance, @Min(0) @Max(5) @NotNull Integer studyLoad,
            @Min(0) @Max(5) @NotNull Integer teacherStudentRelationship,
            @Min(0) @Max(5) @NotNull Integer futureCareerConcerns, @Min(0) @Max(5) @NotNull Integer socialSupport,
            @Min(0) @Max(5) @NotNull Integer peerPressure, @Min(0) @Max(5) @NotNull Integer extracurricularActivities,
            @Min(0) @Max(5) @NotNull Integer bullying) {
        this.userId = userId;
        this.headache = headache;
        this.sleepQuality = sleepQuality;
        this.breathingProblems = breathingProblems;
        this.noiseLevel = noiseLevel;
        this.livingConditions = livingConditions;
        this.safety = safety;
        this.basicNeeds = basicNeeds;
        this.academicPerformance = academicPerformance;
        this.studyLoad = studyLoad;
        this.teacherStudentRelationship = teacherStudentRelationship;
        this.futureCareerConcerns = futureCareerConcerns;
        this.socialSupport = socialSupport;
        this.peerPressure = peerPressure;
        this.extracurricularActivities = extracurricularActivities;
        this.bullying = bullying;
    }



    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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