package com.example.ScreenScore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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
    private int rating;    

    @ManyToOne
    @JoinColumn
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "mtypeid")
    private MediaType mediaType;


    public Media() {
    }

    public Media(MediaType mediaType, String title, String director, int duration, int pubYear, Genre genre, String desc, int rating) {
        this.mediaid = mediaid;
        this.mediaType = mediaType;
        this.title = title;
        this.director = director;
        this.duration = duration;
        this.pubYear = pubYear;
        this.genre = genre;
        this.desc = desc;
        this.rating = rating;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    @Override
    public String toString() {
        return "Media [mediaid=" + mediaid + ", media type=" + this.getMediaType() + ", title=" + title + ", director=" + director + ", duration=" + duration
                + ", publication year=" + pubYear + ", genre=" + this.getGenre() + ", description=" + desc + ", rating=" + rating + "]";
    }


    
}