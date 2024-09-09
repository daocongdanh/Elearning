package com.example.elearning.services.impl;

import com.example.elearning.dtos.AnswerDTO;
import com.example.elearning.exceptions.ResourceNotFoundException;
import com.example.elearning.models.Answer;
import com.example.elearning.models.Question;
import com.example.elearning.repositories.AnswerRepository;
import com.example.elearning.responses.AnswerResponse;
import com.example.elearning.services.AnswerService;
import com.example.elearning.services.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionService questionService;

    @Override
    @Transactional
    public AnswerResponse createAnswer(AnswerDTO answerDTO) {
        Question question = questionService.findById(answerDTO.getQuestionId());
        Answer answer = Answer.builder()
                .answerText(answerDTO.getAnswerText())
                .isCorrect(answerDTO.isCorrect())
                .question(question)
                .build();
        answerRepository.save(answer);
        return AnswerResponse.fromAnswer(answer);
    }

    @Override
    @Transactional
    public AnswerResponse updateAnswer(long id, AnswerDTO answerDTO) {
        Answer answer = findById(id);
        answer.setAnswerText(answerDTO.getAnswerText());
        answer.setCorrect(answerDTO.isCorrect());
        answerRepository.save(answer);
        return AnswerResponse.fromAnswer(answer);
    }

    @Override
    public AnswerResponse getAnswerById(long id) {
        Answer answer = findById(id);
        return AnswerResponse.fromAnswer(answer);
    }

    @Override
    public List<AnswerResponse> getAllAnswersByQuestion(long qid) {
        Question question = questionService.findById(qid);
        return answerRepository.findAllByQuestion(question)
                .stream()
                .map(AnswerResponse::fromAnswer)
                .toList();
    }

    @Override
    public Answer findById(long id) {
        return answerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Answer not found"));
    }
}
