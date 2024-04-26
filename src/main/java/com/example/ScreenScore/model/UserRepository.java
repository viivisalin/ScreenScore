package com.example.ScreenScore.model;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, Long>{
    User findByUsername(String username);
}
