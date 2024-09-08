package com.example.elearning.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCourseDTO {

    @NotNull(message = "User ID cannot be empty")
    private Long userId;

    @NotNull(message = "Course ID cannot be empty")
    private Long courseId;
}
