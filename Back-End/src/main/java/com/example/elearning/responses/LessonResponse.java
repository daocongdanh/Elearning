package com.example.elearning.responses;

import com.example.elearning.enums.LessonType;
import com.example.elearning.models.Lesson;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessonResponse {
    private Long id;
    private String title;
    private String content;
    private Long position;
    private Long videoDuration;
    private String description;
    private boolean isPublic;
    private LessonType lessonType;
    private Long moduleId;

    public static LessonResponse fromLesson(Lesson lesson){
        return LessonResponse.builder()
                .id(lesson.getId())
                .title(lesson.getTitle())
                .content(lesson.getContent())
                .position(lesson.getPosition())
                .videoDuration(lesson.getVideoDuration())
                .description(lesson.getDescription())
                .isPublic(lesson.isPublic())
                .lessonType(lesson.getLessonType())
                .moduleId(lesson.getModule().getId())
                .build();
    }
}
