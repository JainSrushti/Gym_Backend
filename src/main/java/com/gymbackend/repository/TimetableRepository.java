package com.gymbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gymbackend.model.Timetable;

public interface TimetableRepository extends JpaRepository<Timetable, Long> {
}