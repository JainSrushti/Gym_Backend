package com.gymbackend.service;
import com.gymbackend.model.Offer;
import com.gymbackend.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OfferService {
    @Autowired private OfferRepository repository;
    public List<Offer> getAll() { return repository.findAll(); }
    public Offer getById(Long id) { return repository.findById(id).orElseThrow(); }
    public Offer save(Offer o) { return repository.save(o); }
    public void delete(Long id) { repository.deleteById(id); }
}
