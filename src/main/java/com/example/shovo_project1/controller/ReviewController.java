package com.example.shovo_project1.controller;

import java.util.List;

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

import com.example.shovo_project1.exception.ResourceNotFoundException;
import com.example.shovo_project1.model.Review;
import com.example.shovo_project1.service.ReviewService;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController 
{
    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public List<Review> getAllReviews()
    {
        return reviewService.getAllReviews();
    }

    @PostMapping
    public Review createReview(@RequestBody Review review)
    {
        return reviewService.createReview(review);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) throws ResourceNotFoundException
    {
        Review review = reviewService.getReviewById(id);
        return ResponseEntity.ok(review);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody Review reviewDetails) throws ResourceNotFoundException
    {
        Review updateReview = reviewService.updateReview(id, reviewDetails);
        return ResponseEntity.ok(updateReview);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) throws ResourceNotFoundException
    {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }
}
