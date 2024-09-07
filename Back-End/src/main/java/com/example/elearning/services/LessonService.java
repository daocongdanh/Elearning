package com.example.elearning.services;

import com.example.elearning.dtos.LessonDTO;
import com.example.elearning.models.Lesson;
import com.example.elearning.responses.LessonResponse;

import java.util.List;

public interface LessonService {
    LessonResponse createLesson(LessonDTO lessonDTO);
    LessonResponse updateLesson(long id, LessonDTO lessonDTO);
    LessonResponse getLessonById(long id);
    List<LessonResponse> getAllLessonsByModule(long mid);
    Lesson findById(long id);
}
