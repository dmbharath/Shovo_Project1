package com.example.shovo_project1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shovo_project1.model.Communication;
import com.example.shovo_project1.repository.CommunicationRepository;

@RestController
@RequestMapping("/api/communications")
public class CommunicationController 
{
    @Autowired
    private CommunicationRepository communicationRepository;  
    
    @GetMapping
    public List<Communication> getAllCommunications()
    {
        return communicationRepository.findAll();
    }

    @PostMapping
    public Communication createCommunication(@RequestBody Communication communication)
    {
        return communicationRepository.save(communication);
    }
}
