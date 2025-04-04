package com.example.elearning.models;

import com.example.elearning.enums.LessonType;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "lessons")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "position")
    private Long position;

    @Column(name = "video_duration")
    private Long videoDuration;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "is_public")
    private boolean isPublic;

    @Enumerated(EnumType.STRING)
    @Column(name = "lesson_type")
    private LessonType lessonType;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;
}
