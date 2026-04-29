package com.gymbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gymbackend.model.TrainerApplication;
import com.gymbackend.service.TrainerApplicationService;

@RestController
@RequestMapping("/api/trainers") // 
@CrossOrigin(origins = "*")
public class TrainerApplicationController {

    @Autowired
    private TrainerApplicationService service;

    // USER → SUBMIT FORM
    @PostMapping
    public TrainerApplication apply(@RequestBody TrainerApplication app) {
        return service.save(app);
    }

    // ADMIN → GET ALL APPLICATIONS
    @GetMapping
    public List<TrainerApplication> getAll() {
        return service.getAll();
    }

    // ADMIN → APPROVE
    @PutMapping("/{id}/approve")
    public TrainerApplication approve(@PathVariable Long id) {
        return service.approve(id);
    }

    // ADMIN → REJECT
    @PutMapping("/{id}/reject")
    public TrainerApplication reject(@PathVariable Long id) {
        return service.reject(id);
    }
}