package com.example.elearning.services.impl;

import com.example.elearning.dtos.ReviewDTO;
import com.example.elearning.exceptions.ResourceNotFoundException;
import com.example.elearning.models.Course;
import com.example.elearning.models.Review;
import com.example.elearning.models.User;
import com.example.elearning.repositories.ReviewRepository;
import com.example.elearning.responses.ReviewResponse;
import com.example.elearning.services.CourseService;
import com.example.elearning.services.ReviewService;
import com.example.elearning.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserService userService;
    private final CourseService courseService;

    @Override
    @Transactional
    public ReviewResponse createReview(ReviewDTO reviewDTO) {
        User user = userService.findById(reviewDTO.getUserId());
        Course course = courseService.findById(reviewDTO.getCourseId());

        Review review = Review.builder()
                .rate(reviewDTO.getRate())
                .content(reviewDTO.getContent())
                .reviewDate(LocalDateTime.now())
                .user(user)
                .course(course)
                .build();
        reviewRepository.save(review);
        return ReviewResponse.fromReview(review);
    }

    @Override
    public ReviewResponse getReviewById(long id) {
        Review review = findById(id);
        return ReviewResponse.fromReview(review);
    }

    @Override
    public List<ReviewResponse> getAllReviewsByCourse(long cid) {
        Course course = courseService.findById(cid);
        return reviewRepository.findAllByCourse(course)
                .stream()
                .map(ReviewResponse::fromReview)
                .toList();
    }

    @Override
    public Review findById(long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found"));
    }
}
