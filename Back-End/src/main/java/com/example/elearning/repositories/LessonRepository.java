package com.example.elearning.repositories;

import com.example.elearning.models.Lesson;
import com.example.elearning.models.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findAllByModule(Module module);
}
