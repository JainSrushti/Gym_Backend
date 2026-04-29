package com.gymbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gymbackend.model.TrainerApplication;

public interface TrainerApplicationRepository extends JpaRepository<TrainerApplication, Long> {
}