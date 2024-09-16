package com.example.elearning.responses;

import com.example.elearning.models.Course;
import com.example.elearning.models.Tag;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseResponse {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String image;
    private boolean isFree;
    private boolean active;
    private Long userId;
    private Long categoryId;
    private Tag tag;

    public static CourseResponse fromCourse(Course course){
        return CourseResponse.builder()
                .id(course.getId())
                .title(course.getTitle())
                .description(course.getDescription())
                .price(course.getPrice())
                .image(course.getImage())
                .isFree(course.isFree())
                .active(course.isActive())
                .userId(course.getUser().getId())
                .categoryId(course.getCategory().getId())
                .tag(course.getTag() != null ? course.getTag() : null)
                .build();
    }
}
