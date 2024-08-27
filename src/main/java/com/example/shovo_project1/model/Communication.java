package com.example.shovo_project1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Communication 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    private String chatComm;
    private String callComm;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    public Communication()
    {}

    public Communication(String chatComm, String callComm)
    {
        this.chatComm = chatComm;
        this.callComm = callComm;
    }
    public void setChatComm(String chatComm)
    {
        this.chatComm = chatComm;
    }
    public String getChatComm()
    {
        return chatComm;
    }
    public void setCallComm(String callComm)
    {
        this.callComm = callComm;
    }
    public String getCallComm()
    {
        return callComm;
    }
}
