package com.gymbackend.service;
import com.gymbackend.model.Enquiry;
import com.gymbackend.repository.EnquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EnquiryService {
    @Autowired private EnquiryRepository repository;
    public List<Enquiry> getAll() { return repository.findAll(); }
    public Enquiry save(Enquiry e) { return repository.save(e); }
    public void delete(Long id) { repository.deleteById(id); }
}
