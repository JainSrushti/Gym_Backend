package com.gymbackend.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymbackend.model.TrainerApplication;
import com.gymbackend.repository.TrainerApplicationRepository;

@Service
public class TrainerApplicationService {

    @Autowired
    private TrainerApplicationRepository repo;

    // SAVE (user submits form)
    public TrainerApplication save(TrainerApplication app) {
        app.setDate(LocalDate.now());
        app.setStatus("Pending");
        return repo.save(app);
    }

    // GET ALL (admin panel)
    public List<TrainerApplication> getAll() {
        return repo.findAll();
    }

    // APPROVE
    public TrainerApplication approve(Long id) {
        TrainerApplication app = repo.findById(id).orElseThrow();
        app.setStatus("Approved");
        return repo.save(app);
    }

    // REJECT
    public TrainerApplication reject(Long id) {
        TrainerApplication app = repo.findById(id).orElseThrow();
        app.setStatus("Rejected");
        return repo.save(app);
    }
}