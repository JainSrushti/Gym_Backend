package com.gymbackend.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gymbackend.model.AdminLogin;
import com.gymbackend.service.AdminLoginService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminLoginController {

    @Autowired
    private AdminLoginService service;

    // ✅ LOGIN API
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AdminLogin req) {

        AdminLogin admin = service.login(req.getEmail(), req.getPassword());

        if (admin != null) {
            return ResponseEntity.ok(admin);
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    // ✅ CHANGE PASSWORD API
    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestBody Map<String, String> req) {

        String result = service.changePassword(
                req.get("email"),
                req.get("current"),
                req.get("newPwd")
        );

        if (result.equals("success")) {
            return ResponseEntity.ok("Password updated");
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }
}