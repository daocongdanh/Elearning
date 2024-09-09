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
public class AnswerDTO {

    @NotBlank(message = "Answer Text cannot be empty")
    private String answerText;

    private boolean isCorrect;

    @NotNull(message = "Question ID cannot be empty")
    private Long questionId;
}
