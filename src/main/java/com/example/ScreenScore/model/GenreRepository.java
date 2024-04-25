package com.example.ScreenScore.model;

import org.springframework.data.repository.CrudRepository;

// Interface for access to Genre entities in the DB, utilizing CRUD
public interface GenreRepository extends CrudRepository <Genre, Long>{
    // Method to find a Genre entity by its name
    Genre findByName(String name);

}
