package com.example.elearning.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ModuleDTO {
    @NotBlank(message = "Title cannot be empty")
    private String title;

    @NotNull(message = "Position cannot be empty")
    private Long position;

    @NotNull(message = "Course ID cannot be empty")
    private Long courseId;
}
