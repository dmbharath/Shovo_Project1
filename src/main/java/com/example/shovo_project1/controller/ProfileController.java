package com.example.shovo_project1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shovo_project1.exception.ResourceNotFoundException;
import com.example.shovo_project1.model.Profile;
import com.example.shovo_project1.repository.ProfileRepository;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController 
{
    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping
    public List<Profile> getAllProfiles()
    {
        return profileRepository.findAll();
    }

    @PostMapping
    public Profile createProfile(@RequestBody Profile profile)
    {
        return profileRepository.save(profile);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable Long id) throws ResourceNotFoundException
    {
        Profile profile = profileRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Profile not found with the id : "+id));
        return ResponseEntity.ok(profile);
    }
}
