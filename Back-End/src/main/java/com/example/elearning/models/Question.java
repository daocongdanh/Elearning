package com.example.elearning.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "question_text", columnDefinition = "TEXT")
    private String questionText;

    @Column(name = "position")
    private Long position;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;
}
