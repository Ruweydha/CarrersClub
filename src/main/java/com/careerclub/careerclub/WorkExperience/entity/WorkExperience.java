package com.careerclub.careerclub.WorkExperience.entity;

import com.careerclub.careerclub.Entities.User;
import io.swagger.v3.oas.annotations.links.Link;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employer;

    private String industry;
    @URL
    private String urlOfEmployer;

    private String jobTitle;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date startOfJob;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date endOfJob;
    private String jobCategory;
    private String description;
    @ManyToOne
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getUrlOfEmployer() {
        return urlOfEmployer;
    }

    public void setUrlOfEmployer(String urlOfEmployer) {
        this.urlOfEmployer = urlOfEmployer;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(String jobCategory) {
        this.jobCategory = jobCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartOfJob() {
        return startOfJob;
    }

    public void setStartOfJob(Date startOfJob) {
        this.startOfJob = startOfJob;
    }

    public Date getEndOfJob() {
        return endOfJob;
    }

    public void setEndOfJob(Date endOfJob) {
        this.endOfJob = endOfJob;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
