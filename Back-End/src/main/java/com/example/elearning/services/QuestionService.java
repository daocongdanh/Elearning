package com.example.elearning.services;

import com.example.elearning.dtos.QuestionDTO;
import com.example.elearning.models.Question;
import com.example.elearning.responses.QuestionResponse;

import java.util.List;

public interface QuestionService {
    QuestionResponse createQuestion(QuestionDTO questionDTO);
    QuestionResponse updateQuestion(long id, QuestionDTO questionDTO);
    QuestionResponse getQuestionById(long id);
    List<QuestionResponse> getAllQuestionsByLesson(long lid);
    Question findById(long id);
}
