package com.example.shovo_project1.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    private String bookingService;
    private String bookingCategory;
    private double bookingPrice;
    private LocalDateTime creationDateTime;
    private LocalDateTime bookingDateTime;
    private String bookingAddress;
    private String bookingDescription;
    private boolean confirmBooking;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    public Booking()
    {}

    public void setBookingService(String bookingService)
    {
        this.bookingService = bookingService;
    }
    public String getBookingService()
    {
        return bookingService;
    }
    public void setBookingCategory(String bookingCategory)
    {
        this.bookingCategory = bookingCategory;
    }
    public String getBookingCategory()
    {
        return bookingCategory;
    }
    public void setBookingPrice(double bookingPrice)
    {
        this.bookingPrice = bookingPrice;
    }
    public double getBookingPrice()
    {
        return bookingPrice;
    }
    public void setCreationDateTime(LocalDateTime creationDateTime)
    {
        this.creationDateTime = creationDateTime;
    }
    public LocalDateTime getCreationDateTime()
    {
        return creationDateTime;
    }
    public void setBookingDateTime(LocalDateTime bookingDateTime)
    {
        this.bookingDateTime = bookingDateTime;
    }
    public LocalDateTime getBookingDateTime()
    {
        return bookingDateTime;
    }
    public void setBookingAddress(String bookingAddress)
    {
        this.bookingAddress = bookingAddress;
    }
    public String getBookingAddress()
    {
        return bookingAddress;
    }
    public void setBookingDescription(String bookingDescription)
    {
        this.bookingDescription = bookingDescription;
    }
    public String getBookingDescription()
    {
        return bookingDescription;
    }
    public void setConfirmBooking(boolean confirmBooking)
    {
        this.confirmBooking = confirmBooking;
    }
    public boolean getConfirmBooking()
    {
        return confirmBooking;
    }
}
