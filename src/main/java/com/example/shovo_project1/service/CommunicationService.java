package com.example.shovo_project1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shovo_project1.model.Communication;
import com.example.shovo_project1.repository.CommunicationRepository;

@Service
public class CommunicationService 
{
    @Autowired
    private CommunicationRepository communicationRepository;  

    public List<Communication> getAllCommunications()
    {
        return communicationRepository.findAll();
    }

    public Communication createCommunication(Communication communication)
    {
        return communicationRepository.save(communication);
    }
}
