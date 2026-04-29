package com.gymbackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "timetable")
public class Timetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String slot;
    private String mon;
    private String tue;
    private String wed;
    private String thu;
    private String fri;
    private String sat;

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSlot() { return slot; }
    public void setSlot(String slot) { this.slot = slot; }

    public String getMon() { return mon; }
    public void setMon(String mon) { this.mon = mon; }

    public String getTue() { return tue; }
    public void setTue(String tue) { this.tue = tue; }

    public String getWed() { return wed; }
    public void setWed(String wed) { this.wed = wed; }

    public String getThu() { return thu; }
    public void setThu(String thu) { this.thu = thu; }

    public String getFri() { return fri; }
    public void setFri(String fri) { this.fri = fri; }

    public String getSat() { return sat; }
    public void setSat(String sat) { this.sat = sat; }
}