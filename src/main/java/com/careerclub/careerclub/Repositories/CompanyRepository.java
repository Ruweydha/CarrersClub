package com.careerclub.careerclub.Repositories;

import com.careerclub.careerclub.Entities.Company;
import  org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends  JpaRepository<Company, Long>{
}
