package com.example.elearning.services;

import com.example.elearning.dtos.ReviewDTO;
import com.example.elearning.models.Review;
import com.example.elearning.responses.ReviewResponse;

import java.util.List;

public interface ReviewService {
    ReviewResponse createReview(ReviewDTO reviewDTO);
    ReviewResponse getReviewById(long id);
    List<ReviewResponse> getAllReviewsByCourse(long cid);
    Review findById(long id);
}
