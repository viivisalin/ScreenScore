package com.example.ScreenScore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mediaid;
    private String title;
    private String director;
    private int duration;
    private int pubYear;
    private String desc;
    
    public Media() {
    }

    public Media(String title, String director, int duration, int pubYear, String desc) {
        this.mediaid = mediaid;
        this.title = title;
        this.director = director;
        this.duration = duration;
        this.pubYear = pubYear;
        this.desc = desc;
    }

    public Long getMediaid() {
        return mediaid;
    }

    public void setMediaid(Long mediaid) {
        this.mediaid = mediaid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getPubYear() {
        return pubYear;
    }

    public void setPubYear(int pubYear) {
        this.pubYear = pubYear;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Media [mediaid=" + mediaid + ", title=" + title + ", director=" + director + ", duration=" + duration
                + ", publication year=" + pubYear + ", description=" + desc + "]";
    }

    
}