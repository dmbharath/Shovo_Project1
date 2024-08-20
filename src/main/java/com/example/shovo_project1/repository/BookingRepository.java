package com.example.shovo_project1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shovo_project1.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>
{
    
}
