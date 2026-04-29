package com.gymbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymbackend.model.AdminLogin;
import com.gymbackend.repository.AdminLoginRepository;

@Service
public class AdminLoginService {

    @Autowired
    private AdminLoginRepository repo;

    // 🔐 LOGIN
    public AdminLogin login(String email, String password) {
        AdminLogin admin = repo.findByEmail(email);

        if (admin != null && admin.getPassword().equals(password)) {
            return admin;
        }
        return null;
    }

    // 🔐 CHANGE PASSWORD
    public String changePassword(String email, String current, String newPwd) {

        AdminLogin admin = repo.findByEmail(email);

        if (admin == null) return "Admin not found";

        if (!admin.getPassword().equals(current))
            return "Current password incorrect";

        admin.setPassword(newPwd);
        repo.save(admin);

        return "success";
    }
}