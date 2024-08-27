package com.example.shovo_project1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Notifications 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    private String typeMessage;
    private boolean readMessage;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    public Notifications()
    {}

    public Notifications(String typeMessage, boolean readMessage)
    {
        this.typeMessage = typeMessage;
        this.readMessage = readMessage;
    }
    public void setTypeMessage(String typeMessage)
    {
        this.typeMessage = typeMessage;
    }
    public String getTypeMessage()
    {
        return typeMessage;
    }
    public void setReadMessage(boolean readMessage)
    {
        this.readMessage = readMessage;
    }
    public boolean getReadMessage()
    {
        return readMessage;
    }
}
