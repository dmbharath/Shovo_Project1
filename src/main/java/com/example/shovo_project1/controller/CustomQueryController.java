package com.example.shovo_project1.controller;

import com.example.shovo_project1.exception.ResourceNotFoundException;
import com.example.shovo_project1.model.CustomQuery;
import com.example.shovo_project1.service.CustomQueryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/customQueries")
public class CustomQueryController
{
    @Autowired
    private CustomQueryService customQueryService;

    @GetMapping
    public List<CustomQuery> getAllCustomQueries()
    {
        return customQueryService.getAllCustomQueries();
    }

    @PostMapping
    public CustomQuery createCustomQuery(@RequestBody CustomQuery customQuery) throws ResourceNotFoundException
    {
        return customQueryService.createCustomQuery(customQuery);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomQuery> getCustomQueryById(@PathVariable Long id) throws ResourceNotFoundException
    {
        CustomQuery customQuery = customQueryService.getCustomQueryById(id);
        return ResponseEntity.ok(customQuery);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomQuery> updateCustomQuery(@PathVariable Long id, @RequestBody CustomQuery customQueryDetails) throws ResourceNotFoundException
    {
        CustomQuery updateCustomQuery = customQueryService.updateCustomQuery(id, customQueryDetails);
        return ResponseEntity.ok(updateCustomQuery);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomQuery(@PathVariable Long id) throws ResourceNotFoundException
    {
        customQueryService.deleteCustomQuery(id);
        return ResponseEntity.noContent().build();
    }
}