package com.careerclub.careerclub.Repositories;

import com.careerclub.careerclub.Entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolesRepository extends JpaRepository<Roles,Long> {
    Roles findByName(String name);
}
