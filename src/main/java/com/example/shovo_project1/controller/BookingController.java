package com.example.shovo_project1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shovo_project1.exception.ResourceNotFoundException;
import com.example.shovo_project1.model.Booking;
import com.example.shovo_project1.repository.BookingRepository;

@RestController
@RequestMapping("/api/booking")
public class BookingController 
{
    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping
    public List<Booking> getAllBookings()
    {
        return bookingRepository.findAll();
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking)
    {
        return bookingRepository.save(booking);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) throws ResourceNotFoundException
    {
        Booking booking = bookingRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Booking is not found with id : "+id));
        return ResponseEntity.ok(booking);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking bookingDetails) throws ResourceNotFoundException
    {
        Booking booking = bookingRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Booking is not found with id : "+id));
        Booking updateBooking = bookingRepository.save(booking);
        return ResponseEntity.ok(updateBooking);
    }
}
