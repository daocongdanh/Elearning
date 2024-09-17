package com.example.elearning.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {

    @NotNull(message = "Rate cannot be empty")
    private Long rate;

    @NotBlank(message = "Content cannot be empty")
    private String content;

    @NotNull(message = "User ID cannot be empty")
    private Long userId;

    @NotNull(message = "Course ID cannot be empty")
    private Long courseId;
}
