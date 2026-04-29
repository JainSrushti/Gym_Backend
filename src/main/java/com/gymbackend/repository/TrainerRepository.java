package com.gymbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gymbackend.model.Trainer;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}