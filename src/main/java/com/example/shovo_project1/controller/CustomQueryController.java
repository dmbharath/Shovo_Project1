package com.example.shovo_project1.controller;

import com.example.shovo_project1.exception.ResourceNotFoundException;
import com.example.shovo_project1.model.CustomQuery;
import com.example.shovo_project1.repository.CustomQueryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController

public class CustomQueryController
{
    @Autowired
    private CustomQueryRepository customQueryRepository;

    @GetMapping
    public List<CustomQuery> getAllCustomQueries()
    {
        return customQueryRepository.findAll();
    }

    @PostMapping
    public CustomQuery createCustomQuery(@RequestBody CustomQuery customQuery)
    {
        return customQueryRepository.save(customQuery);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomQuery> getCustomQueryById(@PathVariable Long id) throws ResourceNotFoundException
    {
        CustomQuery customQuery = customQueryRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Custom Query not found with the id : "+id));
        return ResponseEntity.ok(customQuery);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomQuery> updateCustomQuery(@PathVariable Long id, @RequestBody CustomQuery customQueryDetails) throws ResourceNotFoundException
    {
        CustomQuery customQuery = customQueryRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("CustomQuery not found with the id : "+id));

        customQuery.setQueryText((customQueryDetails.getQueryText()));

        CustomQuery updatecustomQuery = customQueryRepository.save(customQuery);
        return ResponseEntity.ok(updatecustomQuery);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomQuery(@PathVariable Long id) throws ResourceNotFoundException
    {
        CustomQuery customQuery = customQueryRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Custom Query not found with the id : "+id));
        customQueryRepository.delete(customQuery);
        return ResponseEntity.noContent().build();
    }
}