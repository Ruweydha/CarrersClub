package com.careerclub.careerclub.Repositories;


import com.careerclub.careerclub.Entities.MailList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MailListRepository extends JpaRepository<MailList,Long> {
    Optional<MailList> findByIdAndUserId(Long id,Long userId);
}