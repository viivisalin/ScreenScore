package com.example.ScreenScore.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

// Interface for access to Media entities in the DB, utilizing CRUD
public interface MediaRepository extends CrudRepository <Media, Long>{
    // Method to find a Media entity by its title
    List<Media> findByTitle(String title);
}
