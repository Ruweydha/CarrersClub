package com.careerclub.careerclub.WorkExperience.dto;

import org.hibernate.validator.constraints.URL;

import javax.validation.Valid;

public class WorkExperienceRequest {
    private String employer;

    private String industry;
    @URL
    @Valid
    private String urlOfEmployer;

    private String jobTitle;

    private String startOfJob;
    private String endOfJob;
    private String jobCategory;
    private String description;
    private Long userId;

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

    public String getStartOfJob() {
        return startOfJob;
    }

    public void setStartOfJob(String startOfJob) {
        this.startOfJob = startOfJob;
    }

    public String getEndOfJob() {
        return endOfJob;
    }

    public void setEndOfJob(String endOfJob) {
        this.endOfJob = endOfJob;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
