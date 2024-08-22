package com.example.shovo_project1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shovo_project1.exception.ResourceNotFoundException;
import com.example.shovo_project1.model.Review;
import com.example.shovo_project1.repository.ReviewRepository;
@Service
public class ReviewService 
{
    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getAllReviews()
    {
        return reviewRepository.findAll();
    }

    public Review createReview(Review review)
    {
        return reviewRepository.save(review);
    }

    public Review getReviewById(Long id) throws ResourceNotFoundException
    {
        return reviewRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Review not found with id : "+id));
    }

    public Review updateReview(Long id, Review reviewDetails) throws ResourceNotFoundException
    {
        Review review = reviewRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Review not found with the id : "+id));

        review.setRating(reviewDetails.getRating());
        review.setDescription(reviewDetails.getDescription());
        review.setPhotoURL(reviewDetails.getPhotoURL());
        return reviewRepository.save(review);
    }

    public void deleteReview(Long id) throws ResourceNotFoundException
    {
        Review review = reviewRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Review not found with the id : "+id));
        reviewRepository.delete(review);
    }
}
