package com.example.dbexample.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dbexample.model.User;
import com.example.dbexample.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public User updateUser(Long id, String name, Long age) {

        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            User user = optional.get();
            user.setName(name);
            user.setAge(age);

            return userRepository.save(user);
        } else {
            throw new EntityNotFoundException("user with id" + id + "not found");
        }
    }
}
