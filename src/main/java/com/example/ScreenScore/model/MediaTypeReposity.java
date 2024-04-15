package com.example.ScreenScore.model;

import org.springframework.data.repository.CrudRepository;



public interface MediaTypeReposity extends CrudRepository <MediaType, Long>{
    MediaType findByTypeName(String typeName);
    

}
