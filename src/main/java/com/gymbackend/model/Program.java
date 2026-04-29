package com.gymbackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "programs")
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String shortDesc;

    @Column(columnDefinition = "TEXT")
    private String fullDesc;

    private String level;
    private String duration;
    private String bestFor;
    private String scheduleHint;

    @Column(columnDefinition = "TEXT")
    private String benefits;

    @Column(columnDefinition = "TEXT")
    private String photo;

    // Getters & Setters

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getShortDesc() { return shortDesc; }

    public void setShortDesc(String shortDesc) { this.shortDesc = shortDesc; }

    public String getFullDesc() { return fullDesc; }

    public void setFullDesc(String fullDesc) { this.fullDesc = fullDesc; }

    public String getLevel() { return level; }

    public void setLevel(String level) { this.level = level; }

    public String getDuration() { return duration; }

    public void setDuration(String duration) { this.duration = duration; }

    public String getBestFor() { return bestFor; }

    public void setBestFor(String bestFor) { this.bestFor = bestFor; }

    public String getScheduleHint() { return scheduleHint; }

    public void setScheduleHint(String scheduleHint) { this.scheduleHint = scheduleHint; }

    public String getBenefits() { return benefits; }

    public void setBenefits(String benefits) { this.benefits = benefits; }

    public String getPhoto() { return photo; }

    public void setPhoto(String photo) { this.photo = photo; }
}