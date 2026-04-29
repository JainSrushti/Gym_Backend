package com.gymbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gymbackend.model.AdminLogin;

public interface AdminLoginRepository extends JpaRepository<AdminLogin, Long> {

    AdminLogin findByEmail(String email);
}