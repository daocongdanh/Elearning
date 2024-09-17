package com.example.elearning.responses;

import com.example.elearning.models.Review;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewResponse {

    private Long id;
    private Long rate;
    private String content;
    private LocalDateTime reviewDate;
    private Long userId;
    private Long courseId;

    public static ReviewResponse fromReview(Review review){
        return ReviewResponse.builder()
                .id(review.getId())
                .rate(review.getRate())
                .content(review.getContent())
                .reviewDate(review.getReviewDate())
                .userId(review.getUser().getId())
                .courseId(review.getCourse().getId())
                .build();
    }
}
