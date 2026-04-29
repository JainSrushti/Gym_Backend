package com.gymbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gymbackend.model.Program;

public interface ProgramRepository extends JpaRepository<Program, Long> {
}