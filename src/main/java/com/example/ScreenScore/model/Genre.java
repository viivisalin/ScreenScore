package com.example.ScreenScore.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Genre {

    @Id
    // Specifies the primary key with automatic generation
    @GeneratedValue(strategy = GenerationType.AUTO)
    // Genre variables
    private Long genreid;
    private String name;

    // This entity has a one-to-many relationship with the Media entity
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genre")
    private List<Media> medias;

    // No-argument constructor
    public Genre() {
    }
    
    // Constructor to initialize Genre properties
    public Genre(String name) {
        this.genreid = genreid;
        this.name = name;
    }

    // Getters and Setters

    public Long getGenreid() {
        return genreid;
    }

    public void setGenreid(Long genreid) {
        this.genreid = genreid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
