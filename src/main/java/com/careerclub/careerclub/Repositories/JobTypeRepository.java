package com.careerclub.careerclub.Repositories;

import com.careerclub.careerclub.Entities.EmploymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobTypeRepository extends JpaRepository<EmploymentType, Long> {
    EmploymentType getByname(String name);
}
