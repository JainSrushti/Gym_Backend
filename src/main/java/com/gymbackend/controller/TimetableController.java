package com.gymbackend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.gymbackend.model.GymHour;
import com.gymbackend.model.Timetable;
import com.gymbackend.service.TimetableService;
import com.gymbackend.repository.GymHourRepository;
import com.gymbackend.repository.TimetableRepository;

@RestController
@RequestMapping("/api/timetable")
@CrossOrigin("*")
public class TimetableController {

    @Autowired private TimetableService service;
    @Autowired private TimetableRepository timetableRepository;
    @Autowired private GymHourRepository gymHourRepository;

    @PostMapping("/hours")
    public List<GymHour> saveGymHours(@RequestBody List<GymHour> hours) {
        return service.saveGymHours(hours);
    }

    @PostMapping("/weekly")
    public List<Timetable> saveTimetable(@RequestBody List<Timetable> timetable) {
        return service.saveTimetable(timetable);
    }

    @PutMapping("/weekly/{id}")
    public Timetable updateTimetableRow(@PathVariable Long id, @RequestBody Timetable timetable) {
        timetable.setId(id);
        return service.saveTimetable(List.of(timetable)).get(0);
    }

    @PutMapping("/hours/{id}")
    public GymHour updateGymHour(@PathVariable Long id, @RequestBody GymHour hour) {
        hour.setId(id);
        return service.saveGymHours(List.of(hour)).get(0);
    }

    @DeleteMapping("/weekly/{id}")
    public void deleteTimetableRow(@PathVariable Long id) {
        timetableRepository.deleteById(id);
    }

    @DeleteMapping("/hours/{id}")
    public void deleteGymHour(@PathVariable Long id) {
        gymHourRepository.deleteById(id);
    }

    @GetMapping("/hours")
    public List<GymHour> getGymHours() {
        return service.getGymHours();
    }

    @GetMapping("/weekly")
    public List<Timetable> getWeeklyTimetable() {
        return service.getTimetable();
    }

    @GetMapping
    public List<Timetable> getAllTimetable() {
        return service.getTimetable();
    }
}
