package com.example.dbexample.repository;


import org.springframework.data.repository.CrudRepository;
import com.example.dbexample.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    
}
