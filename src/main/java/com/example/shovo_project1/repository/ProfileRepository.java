package com.example.shovo_project1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shovo_project1.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long>
{
    
}