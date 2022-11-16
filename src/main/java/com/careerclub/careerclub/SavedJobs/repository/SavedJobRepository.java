package com.careerclub.careerclub.SavedJobs.repository;


import com.careerclub.careerclub.SavedJobs.entity.SavedJobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SavedJobRepository extends JpaRepository<SavedJobs,Long> {
    List<SavedJobs> findAllByUserId(Long userId);
    Optional<SavedJobs> findByUserIdAndJobId(Long userId, Long jobId);
}
