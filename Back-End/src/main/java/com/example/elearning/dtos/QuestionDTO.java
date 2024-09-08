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
public class QuestionDTO {

    @NotBlank(message = "Question text cannot be empty")
    private String questionText;

    @NotNull(message = "Position cannot be empty")
    private Long position;

    @NotNull(message = "Lesson ID cannot be empty")
    private Long lessonId;
}
