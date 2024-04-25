package com.example.ScreenScore.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class MediaType {

    @Id
    // Specifies the primary key with automatic generation
    @GeneratedValue(strategy = GenerationType.AUTO)
    // MediaType variables
    private Long mtypeid;
    private String typeName;

    // This entity has a one-to-many relationship with the Media entity
    @OneToMany(mappedBy = "mediaType", cascade = CascadeType.ALL)
    private List<Media> medias;

    // No-argument constructor
    public MediaType() {
    }

    // Constructor to initialize MediaType properties
    public MediaType(String typeName) {
        this.mtypeid = mtypeid;
        this.typeName = typeName;
    }

    // Getters and Setters

    public Long getMtypeid() {
        return mtypeid;
    }

    public void setMtypeid(Long mtypeid) {
        this.mtypeid = mtypeid;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    
}
