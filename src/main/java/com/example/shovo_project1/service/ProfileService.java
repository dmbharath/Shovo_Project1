package com.example.shovo_project1.service;

import com.example.shovo_project1.exception.ResourceNotFoundException;
import com.example.shovo_project1.model.Profile;
import com.example.shovo_project1.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService 
{

    @Autowired
    private ProfileRepository profileRepository;

    public List<Profile> getAllProfiles() 
    {
        return profileRepository.findAll();
    }

    public Profile getProfileById(Long id) throws ResourceNotFoundException 
    {
        return profileRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Profile not found with id: " + id));
    }

    public Profile createProfile(Profile profile) 
    {
        return profileRepository.save(profile);
    }

    public Profile updateProfile(Long id, Profile profileDetails) throws ResourceNotFoundException 
    {
        Profile profile = profileRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Profile not found with id: " + id));

        profile.setPhotoURL(profileDetails.getPhotoURL());        
        profile.setName(profileDetails.getName());
        profile.setEmail(profileDetails.getEmail());
        profile.setPhoneNumber(profileDetails.getPhoneNumber());
        profile.setAddress(profileDetails.getAddress());

        return profileRepository.save(profile);
    }

    public void deleteProfile(Long id) throws ResourceNotFoundException 
    {
        Profile profile = profileRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Profile not found with id: " + id));
        profileRepository.delete(profile);
    }
}
