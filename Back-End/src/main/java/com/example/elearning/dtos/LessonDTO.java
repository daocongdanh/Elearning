package com.example.elearning.dtos;

import com.example.elearning.enums.LessonType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LessonDTO {
    @NotBlank(message = "Title cannot be empty")
    private String title;

    @NotBlank(message = "Content cannot be empty")
    private String content;

    @NotNull(message = "Position cannot be empty")
    private Long position;

    @NotBlank(message = "Description cannot be empty")
    private String description;

    private boolean isPublic;

    @NotNull(message = "Lesson type cannot be empty")
    private String lessonType;

    @NotNull(message = "Module ID cannot be empty")
        private Long moduleId;

    private MultipartFile file;
}
