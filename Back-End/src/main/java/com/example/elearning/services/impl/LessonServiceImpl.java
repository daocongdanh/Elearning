package com.example.elearning.services.impl;

import com.example.elearning.dtos.LessonDTO;
import com.example.elearning.enums.LessonType;
import com.example.elearning.exceptions.ResourceNotFoundException;
import com.example.elearning.models.Lesson;
import com.example.elearning.models.Module;
import com.example.elearning.repositories.LessonRepository;
import com.example.elearning.responses.LessonResponse;
import com.example.elearning.services.LessonService;
import com.example.elearning.services.ModuleService;
import com.example.elearning.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;
    private final ModuleService moduleService;
    private final FileUtil fileUtil;
    @Override
    @Transactional
    public LessonResponse createLesson(LessonDTO lessonDTO) {
        Module module = moduleService.findById(lessonDTO.getModuleId());
        LessonType lessonType = LessonType.valueOf(lessonDTO.getLessonType().toUpperCase());
        Lesson lesson = Lesson.builder()
                .title(lessonDTO.getTitle())
                .position(lessonDTO.getPosition())
                .description(lessonDTO.getDescription())
                .isPublic(lessonDTO.isPublic())
                .lessonType(lessonType)
                .module(module)
                .build();
        if(lessonType.equals(LessonType.VIDEO)){
            String content = fileUtil.uploadVideo(lessonDTO.getFile());
            lesson.setContent(content);
        }
        else{
            lesson.setContent(lessonDTO.getContent());
            lesson.setVideoDuration(0L);
        }
        lessonRepository.save(lesson);
        return LessonResponse.fromLesson(lesson);
    }

    @Override
    @Transactional
    public LessonResponse updateLesson(long id, LessonDTO lessonDTO) {
        return null;
    }

    @Override
    public LessonResponse getLessonById(long id) {
        Lesson lesson = findById(id);
        return LessonResponse.fromLesson(lesson);
    }

    @Override
    public List<LessonResponse> getAllLessonsByModule(long mid) {
        Module module = moduleService.findById(mid);
        return lessonRepository.findAllByModule(module)
                .stream()
                .map(LessonResponse::fromLesson)
                .toList();
    }

    @Override
    public Lesson findById(long id) {
        return lessonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Leeson not found"));
    }
}
