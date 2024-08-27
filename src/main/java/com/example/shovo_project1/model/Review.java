package com.example.shovo_project1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Review 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    
    private int rating;
    private String description;
    private String photoURL;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    public Review()
    {}

    public Review(int rating, String description, String photoURL)
    {
        this.rating = rating;
        this.description = description;
        this.photoURL = photoURL;
    }
    public void setRating(int rating)
    {
        this.rating = rating;
    }
    public int getRating()
    {
        return rating;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
    public String getDescription()
    {
        return description;
    }
    public void setPhotoURL(String photoURL)
    {
        this.photoURL = photoURL;
    }
    public String getPhotoURL()
    {
        return photoURL;
    }
}
