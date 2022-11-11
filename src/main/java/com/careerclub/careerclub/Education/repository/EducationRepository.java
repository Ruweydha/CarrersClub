package com.careerclub.careerclub.Education.repository;

import com.careerclub.careerclub.Education.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
    List<Education> findAllByUserId(Long userId);
}
