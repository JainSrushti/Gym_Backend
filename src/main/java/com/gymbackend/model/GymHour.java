package com.gymbackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "gym_hours")
public class GymHour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String time;
    private String title;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
}
