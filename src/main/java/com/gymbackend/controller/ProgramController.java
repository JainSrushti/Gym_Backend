package com.gymbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gymbackend.model.Program;
import com.gymbackend.service.ProgramService;

@RestController
@RequestMapping("/api/programs")
@CrossOrigin(origins = "*")
public class ProgramController {

    @Autowired
    private ProgramService service;

    // GET all programs
    @GetMapping
    public List<Program> getAll() {
        return service.getAll();
    }

    // CREATE
    @PostMapping
    public Program create(@RequestBody Program p) {
        return service.create(p);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Program update(@PathVariable Long id, @RequestBody Program p) {
        return service.update(id, p);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}