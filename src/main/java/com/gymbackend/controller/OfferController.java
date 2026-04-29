package com.gymbackend.controller;
import com.gymbackend.model.Offer;
import com.gymbackend.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/offers")
@CrossOrigin(origins = "*")
public class OfferController {
    @Autowired private OfferService service;

    @GetMapping
    public List<Offer> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Offer getById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping
    public Offer create(@RequestBody Offer o) { return service.save(o); }

    @PutMapping("/{id}")
    public Offer update(@PathVariable Long id, @RequestBody Offer o) {
        Offer existing = service.getById(id);
        existing.setIcon(o.getIcon());
        existing.setTag(o.getTag());
        existing.setTitle(o.getTitle());
        existing.setDesc(o.getDesc());
        existing.setPrice(o.getPrice());
        existing.setDetails(o.getDetails());
        return service.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
