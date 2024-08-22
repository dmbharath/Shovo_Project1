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
import com.example.shovo_project1.model.Profile;
import com.example.shovo_project1.service.ProfileService;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController 
{
    @Autowired
    private ProfileService profileService;

    @GetMapping
    public List<Profile> getAllProfiles()
    {
        return profileService.getAllProfiles();
    }

    @PostMapping
    public Profile createProfile(@RequestBody Profile profile)
    {
        return profileService.createProfile(profile);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable Long id) throws ResourceNotFoundException
    {
        Profile profile = profileService.getProfileById(id);
        return ResponseEntity.ok(profile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable Long id, @RequestBody Profile profileDetails) throws ResourceNotFoundException
    {
        Profile updateProfile = profileService.updateProfile(id, profileDetails);
        return ResponseEntity.ok(updateProfile);   
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id) throws ResourceNotFoundException
    {
        profileService.deleteProfile(id);
        return ResponseEntity.noContent().build();
    }
}
