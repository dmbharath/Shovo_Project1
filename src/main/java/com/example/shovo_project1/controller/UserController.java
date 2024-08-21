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
import com.example.shovo_project1.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController 
{       
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }
    
    @PostMapping
    public User createUser(@RequestBody User user)
    {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) throws ResourceNotFoundException
    {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);   
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) throws ResourceNotFoundException
    {
        User updateUser = userService.updateUser(id, userDetails);
       
        return ResponseEntity.ok(updateUser);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) throws ResourceNotFoundException
    {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
