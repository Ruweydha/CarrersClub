package com.careerclub.careerclub.WorkExperience.repository;

import com.careerclub.careerclub.WorkExperience.entity.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkExperienceRepository extends JpaRepository<WorkExperience, Long> {
}
