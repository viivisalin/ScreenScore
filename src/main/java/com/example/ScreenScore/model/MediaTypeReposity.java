package com.example.ScreenScore.model;

import org.springframework.data.repository.CrudRepository;


// Interface for access to MediaType entities in the DB, utilizing CRUD
public interface MediaTypeReposity extends CrudRepository <MediaType, Long>{
    // Method to find a MediaType entity by its name
    MediaType findByTypeName(String typeName);
    

}
