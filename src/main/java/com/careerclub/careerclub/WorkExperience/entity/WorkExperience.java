package com.careerclub.careerclub.WorkExperience.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employer;

    private String industry;

    private String urlOfEmployer;

    private String jobTitle;

    private String startOfJob;

    private String endOfJob;

    private String jobCategory;
    private String description;



}
