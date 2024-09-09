package com.example.elearning.responses;

import com.example.elearning.models.Answer;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnswerResponse {
    private Long id;
    private String answerText;
    private boolean isCorrect;
    private Long questionId;

    public static AnswerResponse fromAnswer(Answer answer){
        return AnswerResponse.builder()
                .id(answer.getId())
                .answerText(answer.getAnswerText())
                .isCorrect(answer.isCorrect())
                .questionId(answer.getQuestion().getId())
                .build();
    }
}
