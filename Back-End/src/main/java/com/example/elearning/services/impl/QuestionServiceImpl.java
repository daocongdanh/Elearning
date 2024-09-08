package com.example.elearning.services.impl;

import com.example.elearning.dtos.QuestionDTO;
import com.example.elearning.exceptions.ResourceNotFoundException;
import com.example.elearning.models.Lesson;
import com.example.elearning.models.Question;
import com.example.elearning.repositories.QuestionRepository;
import com.example.elearning.responses.QuestionResponse;
import com.example.elearning.services.LessonService;
import com.example.elearning.services.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    private final LessonService lessonService;
    @Override
    @Transactional
    public QuestionResponse createQuestion(QuestionDTO questionDTO) {
        Lesson lesson = lessonService.findById(questionDTO.getLessonId());
        Question question = Question.builder()
                .questionText(questionDTO.getQuestionText())
                .position(questionDTO.getPosition())
                .lesson(lesson)
                .build();
        questionRepository.save(question);
        return QuestionResponse.fromQuestion(question);
    }

    @Override
    @Transactional
    public QuestionResponse updateQuestion(long id, QuestionDTO questionDTO) {
        Question question = findById(id);
        question.setQuestionText(questionDTO.getQuestionText());
        question.setPosition(questionDTO.getPosition());
        questionRepository.save(question);
        return QuestionResponse.fromQuestion(question);
    }

    @Override
    public QuestionResponse getQuestionById(long id) {
        Question question = findById(id);
        return QuestionResponse.fromQuestion(question);
    }

    @Override
    public List<QuestionResponse> getAllQuestionsByLesson(long lid) {
        Lesson lesson = lessonService.findById(lid);
        return questionRepository.findAllByLesson(lesson)
                .stream()
                .map(QuestionResponse::fromQuestion)
                .toList();
    }

    @Override
    public Question findById(long id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Question not found"));
    }
}
