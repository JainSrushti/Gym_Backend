package com.gymbackend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gymbackend.model.GymHour;
import com.gymbackend.model.Timetable;
import com.gymbackend.repository.GymHourRepository;
import com.gymbackend.repository.TimetableRepository;

@Service
public class TimetableService {

    @Autowired
    private GymHourRepository gymHourRepository;

    @Autowired
    private TimetableRepository timetableRepository;

    // ✅ FIXED (no deleteAll)
    public List<GymHour> saveGymHours(List<GymHour> hours) {
        return gymHourRepository.saveAll(hours);
    }

    // ✅ FIXED (no deleteAll)
    public List<Timetable> saveTimetable(List<Timetable> timetable) {
        return timetableRepository.saveAll(timetable);
    }

    public List<GymHour> getGymHours() {
        return gymHourRepository.findAll();
    }

    public List<Timetable> getTimetable() {
        return timetableRepository.findAll();
    }
}