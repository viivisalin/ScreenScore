package com.example.ScreenScore.model;

import org.springframework.data.repository.CrudRepository;

public interface MediaRepository extends CrudRepository <Media, Long>{
    Media findByTitle(String title);
}
