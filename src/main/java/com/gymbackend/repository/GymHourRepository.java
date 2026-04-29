package com.gymbackend.repository;
import com.gymbackend.model.GymHour;
import org.springframework.data.jpa.repository.JpaRepository;
public interface GymHourRepository extends JpaRepository<GymHour, Long> {}
