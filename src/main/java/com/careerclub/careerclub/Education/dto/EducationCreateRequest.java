package com.careerclub.careerclub.Education.dto;

public class EducationCreateRequest {

    private Long userId;

    private String schoolName;

    private String degreeName;

    private String educationLevel;

    private String grade;

    private String startOfEducation;

    private String endOfEducation;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getStartOfEducation() {
        return startOfEducation;
    }

    public void setStartOfEducation(String startOfEducation) {
        this.startOfEducation = startOfEducation;
    }

    public String getEndOfEducation() {
        return endOfEducation;
    }

    public void setEndOfEducation(String endOfEducation) {
        this.endOfEducation = endOfEducation;
    }
}
