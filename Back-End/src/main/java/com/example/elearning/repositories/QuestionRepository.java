package com.example.elearning.repositories;

import com.example.elearning.models.Lesson;
import com.example.elearning.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findAllByLesson(Lesson lesson);
}
