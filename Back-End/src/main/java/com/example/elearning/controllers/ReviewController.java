package com.example.elearning.controllers;

import com.example.elearning.dtos.ReviewDTO;
import com.example.elearning.responses.ResponseSuccess;
import com.example.elearning.services.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("")
    public ResponseEntity<ResponseSuccess> createReview(@Valid @RequestBody ReviewDTO reviewDTO){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message("Create review successfully")
                .status(HttpStatus.CREATED.value())
                .data(reviewService.createReview(reviewDTO))
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseSuccess> getReviewById(@PathVariable long id){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message("Get review information successfully")
                .status(HttpStatus.OK.value())
                .data(reviewService.getReviewById(id))
                .build());
    }

    @GetMapping("/course/{cid}")
    public ResponseEntity<ResponseSuccess> getAllReviewsByCourse(@PathVariable long cid){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message("Get all reviews by course information successfully")
                .status(HttpStatus.OK.value())
                .data(reviewService.getAllReviewsByCourse(cid))
                .build());
    }
}
