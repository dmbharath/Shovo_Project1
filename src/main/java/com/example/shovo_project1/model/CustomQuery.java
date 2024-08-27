package com.example.shovo_project1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CustomQuery 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;    

    private String queryText;
    
    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    public CustomQuery()
    {}

    public CustomQuery(String queryText)
    {
        this.queryText = queryText;
    }
    public void setQueryText(String queryText)
    {
        this.queryText = queryText;
    }
    public String getQueryText()
    {
        return queryText;
    }
}
