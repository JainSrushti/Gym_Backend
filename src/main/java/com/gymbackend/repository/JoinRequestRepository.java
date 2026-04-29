package com.gymbackend.repository;

import com.gymbackend.model.JoinRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JoinRequestRepository extends JpaRepository<JoinRequest, Long> {
    List<JoinRequest> findAllByOrderByCreatedAtDesc();
    long countByStatus(String status);
}
