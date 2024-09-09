package com.example.elearning.services;

import com.example.elearning.dtos.AnswerDTO;
import com.example.elearning.models.Answer;
import com.example.elearning.responses.AnswerResponse;

import java.util.List;

public interface AnswerService {
    AnswerResponse createAnswer(AnswerDTO answerDTO);
    AnswerResponse updateAnswer(long id, AnswerDTO answerDTO);
    AnswerResponse getAnswerById(long id);
    List<AnswerResponse> getAllAnswersByQuestion(long qid);
    Answer findById(long id);
}
