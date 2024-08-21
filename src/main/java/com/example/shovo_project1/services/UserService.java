package com.example.shovo_project1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.shovo_project1.exception.ResourceNotFoundException;
import com.example.shovo_project1.model.User;
import com.example.shovo_project1.repository.UserRepository;

@Service
public class UserService 
{
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }
    
    public User createUser(@RequestBody User user)
    {
        return userRepository.save(user);
    }

    public User getUserById(Long id) throws ResourceNotFoundException
    {
        return userRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("User not found with the id : "+id));
    }

    public User updateUser(Long id, User userDetails) throws ResourceNotFoundException
    {
        User user = userRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("User not found with the id : "+id));
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setPhoneNumber(userDetails.getPhoneNumber());
        user.setAddress((userDetails.getAddress()));

        return userRepository.save(user);
    }
    
    public void deleteUser(Long id) throws ResourceNotFoundException
    {
        User user = userRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("User not found with the id : "+id));
        userRepository.delete(user);
    }
}