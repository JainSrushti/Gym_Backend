package com.gymbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gymbackend.model.Trainer;
import com.gymbackend.service.TrainerService;

@RestController
@RequestMapping("/api/gym-trainers")
@CrossOrigin(origins = "*")
public class TrainerController {

    @Autowired
    private TrainerService service;

    // GET ALL
    @GetMapping
    public List<Trainer> getAll() {
        return service.getAll();
    }

    // CREATE
    @PostMapping
    public Trainer create(@RequestBody Trainer t) {
        return service.save(t);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Trainer update(@PathVariable Long id, @RequestBody Trainer t) {
        return service.update(id, t);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}