package com.example.elearning.controllers;

import com.example.elearning.dtos.LessonDTO;
import com.example.elearning.responses.ResponseSuccess;
import com.example.elearning.services.LessonService;
import com.example.elearning.utils.Translator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}/lessons")
@RequiredArgsConstructor
public class LessonController {
    private final LessonService lessonService;

    @PostMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ResponseSuccess> createLesson(@Valid @ModelAttribute LessonDTO lessonDTO){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message("Create lesson successfully")
                .status(HttpStatus.CREATED.value())
                .data(lessonService.createLesson(lessonDTO))
                .build());
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ResponseSuccess> updateLesson(@PathVariable long id,
                                                        @Valid @ModelAttribute LessonDTO lessonDTO){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message("Update lesson successfully")
                .status(HttpStatus.OK.value())
                .data(lessonService.updateLesson(id, lessonDTO))
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseSuccess> getLessonById(@PathVariable long id){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message("Get lesson information successfully")
                .status(HttpStatus.OK.value())
                .data(lessonService.getLessonById(id))
                .build());
    }

    @GetMapping("/module/{mid}")
    public ResponseEntity<ResponseSuccess> getAllLessonsByModule(@PathVariable long mid){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message("Get all lessons by module information successfully")
                .status(HttpStatus.OK.value())
                .data(lessonService.getAllLessonsByModule(mid))
                .build());
    }
}
