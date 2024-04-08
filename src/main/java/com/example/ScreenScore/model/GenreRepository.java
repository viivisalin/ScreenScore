package com.example.ScreenScore.model;

import org.springframework.data.repository.CrudRepository;


public interface GenreRepository extends CrudRepository <Genre, Long>{
    //Genre findByName(String name);

}
