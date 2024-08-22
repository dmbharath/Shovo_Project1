package com.example.shovo_project1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shovo_project1.exception.ResourceNotFoundException;
import com.example.shovo_project1.model.Booking;
import com.example.shovo_project1.repository.BookingRepository;

@Service
public class BookingService 
{
    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings()
    {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id) throws ResourceNotFoundException
    {
        return bookingRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Booking is not found with the id : "+id));
    }

    public Booking createBooking(Booking booking)
    {
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Long id, Booking bookingDetails) throws ResourceNotFoundException
    {
        Booking booking = bookingRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Booking is not found with id : "+id));

        booking.setBookingService(bookingDetails.getBookingService());
        booking.setBookingCategory((bookingDetails.getBookingCategory()));
        booking.setBookingPrice((bookingDetails.getBookingPrice()));
        booking.setCreationDateTime((booking.getCreationDateTime()));
        booking.setBookingDateTime((bookingDetails.getBookingDateTime()));
        booking.setBookingAddress((bookingDetails.getBookingAddress()));
        booking.setBookingDescription((bookingDetails.getBookingDescription()));
        booking.setConfirmBooking((bookingDetails.getConfirmBooking()));

        return bookingRepository.save(booking);
    }

    public void deleteBooking(Long id) throws ResourceNotFoundException
    {
        Booking booking = bookingRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Booking is not found with id : "+id));
       bookingRepository.delete(booking);
    }
}
