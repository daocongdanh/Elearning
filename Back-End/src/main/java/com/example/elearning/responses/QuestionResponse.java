package com.example.elearning.responses;

import com.example.elearning.models.Question;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionResponse {
    private Long id;
    private String questionText;
    private Long position;
    private Long lessonId;

    public static QuestionResponse fromQuestion(Question question){
        return QuestionResponse.builder()
                .id(question.getId())
                .questionText(question.getQuestionText())
                .position(question.getPosition())
                .lessonId(question.getLesson().getId())
                .build();
    }
}
