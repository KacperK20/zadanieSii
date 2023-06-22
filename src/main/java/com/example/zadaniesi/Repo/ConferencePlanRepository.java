package com.example.zadaniesi.Repo;

import com.example.zadaniesi.model.ConferencePlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConferencePlanRepository extends JpaRepository<ConferencePlan, Long> {

    Optional<ConferencePlan> findById(Long id);
}