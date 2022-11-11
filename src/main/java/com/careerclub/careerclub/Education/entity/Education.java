package com.careerclub.careerclub.Education.entity;

import com.careerclub.careerclub.Entities.User;

import javax.persistence.*;

@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String schoolName;

    private String degreeName;

    private String educationLevel;

    private String grade;

    private String startOfEducation;

    private String endOfEducation;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
