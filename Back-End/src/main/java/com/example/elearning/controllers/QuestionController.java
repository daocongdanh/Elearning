package com.example.elearning.controllers;

import com.example.elearning.dtos.QuestionDTO;
import com.example.elearning.responses.ResponseSuccess;
import com.example.elearning.services.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}/questions")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping("")
    public ResponseEntity<ResponseSuccess> createQuestion(@Valid @RequestBody QuestionDTO questionDTO){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message("Create question successfully")
                .status(HttpStatus.CREATED.value())
                .data(questionService.createQuestion(questionDTO))
                .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseSuccess> updateQuestion(@PathVariable long id,
                                                          @Valid @RequestBody QuestionDTO questionDTO){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message("Update question successfully")
                .status(HttpStatus.OK.value())
                .data(questionService.updateQuestion(id, questionDTO))
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseSuccess> getQuestionById(@PathVariable long id){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message("Get question information successfully")
                .status(HttpStatus.OK.value())
                .data(questionService.getQuestionById(id))
                .build());
    }

    @GetMapping("/lesson/{lid}")
    public ResponseEntity<ResponseSuccess> getAllQuestionsByLesson(@PathVariable long lid){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message("Get all questions by lesson information successfully")
                .status(HttpStatus.OK.value())
                .data(questionService.getAllQuestionsByLesson(lid))
                .build());
    }
}
