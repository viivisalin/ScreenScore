package com.example.ScreenScore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MediaType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mtypeid;
    private String mtypeName;
    
    public MediaType() {
    }

    public MediaType(String mtypeName) {
        this.mtypeid = mtypeid;
        this.mtypeName = mtypeName;
    }

    public Long getMtypeid() {
        return mtypeid;
    }

    public void setMtypeid(Long mtypeid) {
        this.mtypeid = mtypeid;
    }

    public String getMtypeName() {
        return mtypeName;
    }

    public void setMtypeName(String mtypeName) {
        this.mtypeName = mtypeName;
    }

    
}
