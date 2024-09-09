package com.example.elearning.controllers;

import com.example.elearning.dtos.AnswerDTO;
import com.example.elearning.responses.ResponseSuccess;
import com.example.elearning.services.AnswerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}/answers")
@RequiredArgsConstructor
public class AnswerController {
    private final AnswerService answerService;

    @PostMapping("")
    public ResponseEntity<ResponseSuccess> createAnswer(@Valid @RequestBody AnswerDTO answerDTO){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message("Create answer successfully")
                .status(HttpStatus.CREATED.value())
                .data(answerService.createAnswer(answerDTO))
                .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseSuccess> updateAnswer(@PathVariable long id,
                                                        @Valid @RequestBody AnswerDTO answerDTO){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message("Update answer successfully")
                .status(HttpStatus.OK.value())
                .data(answerService.updateAnswer(id, answerDTO))
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseSuccess> getAnswerById(@PathVariable long id){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message("Get answer information successfully")
                .status(HttpStatus.OK.value())
                .data(answerService.getAnswerById(id))
                .build());
    }

    @GetMapping("/question/{qid}")
    public ResponseEntity<ResponseSuccess> getAllAnswersByQuestion(@PathVariable long qid){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message("Get all answers by question information successfully")
                .status(HttpStatus.OK.value())
                .data(answerService.getAllAnswersByQuestion(qid))
                .build());
    }
}
