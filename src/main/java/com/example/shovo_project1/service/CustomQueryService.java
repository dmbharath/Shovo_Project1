package com.example.shovo_project1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shovo_project1.exception.ResourceNotFoundException;
import com.example.shovo_project1.model.CustomQuery;
import com.example.shovo_project1.repository.CustomQueryRepository;

@Service
public class CustomQueryService 
{
    @Autowired
    private CustomQueryRepository customQueryRepository;

    public List<CustomQuery> getAllCustomQueries()
    {
        return customQueryRepository.findAll();
    }

    public CustomQuery getCustomQueryById(Long id) throws ResourceNotFoundException
    {
        return customQueryRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Custom Query not found with id : "+id));
    }

    public CustomQuery createCustomQuery(CustomQuery customQuery) throws ResourceNotFoundException
    {
        return customQueryRepository.save(customQuery);
    }

    public CustomQuery updateCustomQuery(Long id, CustomQuery customQueryDetails) throws ResourceNotFoundException
    {
        CustomQuery customQuery = customQueryRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("CustomQuery not found with the id :"+id));

        customQuery.setQueryText((customQueryDetails.getQueryText()));

        return customQueryRepository.save(customQuery);
    }

    public void deleteCustomQuery(Long id) throws ResourceNotFoundException
    {
        CustomQuery customQuery = customQueryRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Custom Query not found with the id : "+id));
        customQueryRepository.delete(customQuery);
    }
}
