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
import com.example.shovo_project1.repository.ReviewRepository;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController 
{
    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping
    public List<Review> getAllReviews()
    {
        return reviewRepository.findAll();
    }

    @PostMapping
    public Review createReview(@RequestBody Review review)
    {
        return reviewRepository.save(review);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) throws ResourceNotFoundException
    {
        Review review = reviewRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Review not found with the id : "+id));
        return ResponseEntity.ok(review);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody Review reviewDetails) throws ResourceNotFoundException
    {
        Review review = reviewRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Review not found with the id : "+id));
        review.setRating(reviewDetails.getRating());
        review.setDescription(reviewDetails.getDescription());
        review.setPhotoURL(reviewDetails.getPhotoURL());
        Review updateReview = reviewRepository.save(review);
        return ResponseEntity.ok(updateReview);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Review> deleteReview(@PathVariable Long id) throws ResourceNotFoundException
    {
        Review review = reviewRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Review not found with the id : "+id));
        reviewRepository.delete(review);
        return ResponseEntity.noContent().build();
    }
}
