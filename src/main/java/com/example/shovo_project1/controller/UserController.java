package com.example.shovo_project1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shovo_project1.exception.ResourceNotFoundException;
import com.example.shovo_project1.model.User;
import com.example.shovo_project1.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController 
{       
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }
    
    @PostMapping
    public User createUser(@RequestBody User user)
    {
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) throws ResourceNotFoundException
    {
        User user = userRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("User not found with the id : "+id));
        return ResponseEntity.ok(user);   
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) throws ResourceNotFoundException
    {
        User user = userRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("User not found with the id : "+id));
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setPhoneNumber(userDetails.getPhoneNumber());
        user.setAddress((userDetails.getAddress()));

        User updateUser = userRepository.save(user);
        return ResponseEntity.ok(updateUser);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) throws ResourceNotFoundException
    {
        User user = userRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("User not found with the id" +id));
        userRepository.delete(user);
        return ResponseEntity.noContent().build();
    }
}
