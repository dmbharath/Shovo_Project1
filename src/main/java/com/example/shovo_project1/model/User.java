package com.example.shovo_project1.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "\"user\"")
public class User 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    private String name;
    private String email;
    private Long phoneNumber;
    private String address;

    // Here one user has mapped with only one profile
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Profile profile;

    //Here one user can have multilple reviews and ratings
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> review;

    //Here one user can have multiple queries
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<CustomQuery> customQuery;

    //Here one user can have multiple communications 
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Communication> communications;

    //One user can have multiple bookings
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Booking> booking;

    //One user can have multiple notifications
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Notifications> notifications;

    //Constructors are used to refer the same reference variable 
    public User()
    {

    }
    public User(String name, String email, Long phoneNumber, String address)
    {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    //Getters and setters for the user 
    public void setId(Long user_id)
    {
        this.user_id = user_id;
    }
    public Long getUserId()
    {
        return user_id;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getEmail()
    {
        return email;
    }
    public void setPhoneNumber(Long phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    public Long getPhoneNumber()
    {
        return phoneNumber;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public String getAddress()
    {
        return address;
    }
}