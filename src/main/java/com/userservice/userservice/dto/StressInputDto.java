package com.userservice.userservice.dto;

public class StressInputDto {
    private int headache;
    private int sleepQuality;
    private int breathingProblems;
    private int noiseLevel;
    private int livingConditions;
    private int safety;
    private int basicNeeds;
    private int academicPerformance;
    private int studyLoad;
    private int teacherStudentRelationship;
    private int futureCareerConcerns;
    private int socialSupport;
    private int peerPressure;
    private int extracurricularActivities;
    private int bullying;

    public StressInputDto() {}

    public StressInputDto(int headache, int sleepQuality, int breathingProblems, int noiseLevel, int livingConditions,
            int safety, int basicNeeds, int academicPerformance, int studyLoad, int teacherStudentRelationship,
            int futureCareerConcerns, int socialSupport, int peerPressure, int extracurricularActivities,
            int bullying) {
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

    public int getHeadache() {
        return headache;
    }
    public void setHeadache(int headache) {
        this.headache = headache;
    }
    public int getSleepQuality() {
        return sleepQuality;
    }
    public void setSleepQuality(int sleepQuality) {
        this.sleepQuality = sleepQuality;
    }
    public int getBreathingProblems() {
        return breathingProblems;
    }
    public void setBreathingProblems(int breathingProblems) {
        this.breathingProblems = breathingProblems;
    }
    public int getNoiseLevel() {
        return noiseLevel;
    }
    public void setNoiseLevel(int noiseLevel) {
        this.noiseLevel = noiseLevel;
    }
    public int getLivingConditions() {
        return livingConditions;
    }
    public void setLivingConditions(int livingConditions) {
        this.livingConditions = livingConditions;
    }
    public int getSafety() {
        return safety;
    }
    public void setSafety(int safety) {
        this.safety = safety;
    }
    public int getBasicNeeds() {
        return basicNeeds;
    }
    public void setBasicNeeds(int basicNeeds) {
        this.basicNeeds = basicNeeds;
    }
    public int getAcademicPerformance() {
        return academicPerformance;
    }
    public void setAcademicPerformance(int academicPerformance) {
        this.academicPerformance = academicPerformance;
    }
    public int getStudyLoad() {
        return studyLoad;
    }
    public void setStudyLoad(int studyLoad) {
        this.studyLoad = studyLoad;
    }
    public int getTeacherStudentRelationship() {
        return teacherStudentRelationship;
    }
    public void setTeacherStudentRelationship(int teacherStudentRelationship) {
        this.teacherStudentRelationship = teacherStudentRelationship;
    }
    public int getFutureCareerConcerns() {
        return futureCareerConcerns;
    }
    public void setFutureCareerConcerns(int futureCareerConcerns) {
        this.futureCareerConcerns = futureCareerConcerns;
    }
    public int getSocialSupport() {
        return socialSupport;
    }
    public void setSocialSupport(int socialSupport) {
        this.socialSupport = socialSupport;
    }
    public int getPeerPressure() {
        return peerPressure;
    }
    public void setPeerPressure(int peerPressure) {
        this.peerPressure = peerPressure;
    }
    public int getExtracurricularActivities() {
        return extracurricularActivities;
    }
    public void setExtracurricularActivities(int extracurricularActivities) {
        this.extracurricularActivities = extracurricularActivities;
    }
    public int getBullying() {
        return bullying;
    }
    public void setBullying(int bullying) {
        this.bullying = bullying;
    }

    
}