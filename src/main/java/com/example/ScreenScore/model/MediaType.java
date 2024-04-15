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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mtypeid;
    private String typeName;

    @OneToMany(mappedBy = "mediaType", cascade = CascadeType.ALL)
    private List<Media> medias;

    public MediaType() {
    }

    public MediaType(String typeName) {
        this.mtypeid = mtypeid;
        this.typeName = typeName;
    }

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
