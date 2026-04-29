package com.gymbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymbackend.model.Program;
import com.gymbackend.repository.ProgramRepository;

@Service
public class ProgramService {

    @Autowired
    private ProgramRepository repo;

    public List<Program> getAll() {
        return repo.findAll();
    }

    public Program create(Program p) {
        return repo.save(p);
    }

    public Program update(Long id, Program p) {
        Program existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Program not found"));

        existing.setTitle(p.getTitle());
        existing.setShortDesc(p.getShortDesc());
        existing.setFullDesc(p.getFullDesc());
        existing.setLevel(p.getLevel());
        existing.setDuration(p.getDuration());
        existing.setBestFor(p.getBestFor());
        existing.setScheduleHint(p.getScheduleHint());
        existing.setBenefits(p.getBenefits());
        existing.setPhoto(p.getPhoto());

        return repo.save(existing);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}