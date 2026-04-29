package com.gymbackend.service;

import com.gymbackend.model.MembershipPlan;
import com.gymbackend.repository.MembershipPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MembershipPlanService {
    @Autowired private MembershipPlanRepository repository;

    public List<MembershipPlan> getAllPlans() { return repository.findAll(); }
    public MembershipPlan getPlanById(Long id) { return repository.findById(id).orElseThrow(); }
    public MembershipPlan savePlan(MembershipPlan plan) { return repository.save(plan); }
    public void deletePlan(Long id) { repository.deleteById(id); }
}
