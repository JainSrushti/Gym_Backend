package com.gymbackend.controller;
import com.gymbackend.model.MembershipPlan;
import com.gymbackend.service.MembershipPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/membership-plans")
@CrossOrigin(origins = "*")
public class MembershipPlanController {
    @Autowired private MembershipPlanService service;

    @GetMapping
    public List<MembershipPlan> getAll() { return service.getAllPlans(); }

    @GetMapping("/{id}")
    public MembershipPlan getById(@PathVariable Long id) { return service.getPlanById(id); }

    @PostMapping
    public MembershipPlan create(@RequestBody MembershipPlan p) { return service.savePlan(p); }

    @PutMapping("/{id}")
    public MembershipPlan update(@PathVariable Long id, @RequestBody MembershipPlan p) {
        MembershipPlan existing = service.getPlanById(id);
        existing.setTitle(p.getTitle());
        existing.setDuration(p.getDuration());
        existing.setPrice(p.getPrice());
        existing.setOriginalPrice(p.getOriginalPrice());
        existing.setPerMonth(p.getPerMonth());
        existing.setBadge(p.getBadge());
        existing.setBestFor(p.getBestFor());
        existing.setHighlight(p.isHighlight());
        existing.setBenefits(p.getBenefits());
        return service.savePlan(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.deletePlan(id); }
}
