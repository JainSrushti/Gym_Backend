package com.gymbackend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymbackend.model.Trainer;
import com.gymbackend.repository.TrainerRepository;

@Service
public class TrainerService {

    @Autowired
    private TrainerRepository repo;

    public List<Trainer> getAll() {
        return repo.findAll();
    }

    public Trainer save(Trainer t) {
        return repo.save(t);
    }

    public Trainer update(Long id, Trainer t) {
        Trainer existing = repo.findById(id).orElseThrow();
        existing.setName(t.getName());
        existing.setSpecialization(t.getSpecialization());
        existing.setExperience(t.getExperience());
        existing.setAvailability(t.getAvailability());
        existing.setBio(t.getBio());
        existing.setPhoneNumber(t.getPhoneNumber());
        existing.setPhoto(t.getPhoto());
        existing.setBestFor(t.getBestFor());
        existing.setProgramsHandled(t.getProgramsHandled());
        return repo.save(existing);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}