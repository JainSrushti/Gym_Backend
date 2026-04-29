package com.gymbackend.controller;
import com.gymbackend.model.Enquiry;
import com.gymbackend.service.EnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/enquiries")
@CrossOrigin(origins = "*")
public class EnquiryController {
    @Autowired private EnquiryService service;

    @GetMapping
    public List<Enquiry> getAll() { return service.getAll(); }

    @PostMapping
    public Enquiry create(@RequestBody Enquiry e) { return service.save(e); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
