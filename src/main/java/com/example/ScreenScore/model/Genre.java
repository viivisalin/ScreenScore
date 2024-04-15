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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long genreid;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genre")
    private List<Media> medias;

    public Genre() {
    }
    
    public Genre(String name) {
        this.genreid = genreid;
        this.name = name;
    }

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
