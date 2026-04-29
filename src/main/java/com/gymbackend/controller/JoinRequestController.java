package com.gymbackend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.gymbackend.model.JoinRequest;
import com.gymbackend.repository.JoinRequestRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class JoinRequestController {

    @Autowired
    private JoinRequestRepository repository;

    @PostMapping("/join")
    public JoinRequest create(@RequestBody JoinRequest req) {
        return repository.save(req);
    }

    @PutMapping("/approve/{id}")
    public JoinRequest approveRequest(@PathVariable Long id) {
        JoinRequest req = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Request not found"));
        req.setStatus("Approved");
        return repository.save(req);
    }

    @GetMapping("/join")
    public List<JoinRequest> getAll() {
        return repository.findAllByOrderByCreatedAtDesc();
    }

    @GetMapping("/join/count")
    public long total() {
        return repository.count();
    }

    @GetMapping("/join/pending/count")
    public long pending() {
        return repository.countByStatus("Pending");
    }

    @GetMapping("/join/approved/count")
    public long approved() {
        return repository.countByStatus("Approved");
    }
}
