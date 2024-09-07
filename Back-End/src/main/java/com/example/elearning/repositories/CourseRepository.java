package com.example.elearning.repositories;

import com.example.elearning.models.Category;
import com.example.elearning.models.Course;
import com.example.elearning.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findAllByCategory(Category category);
    List<Course> findAllByUser(User user);
}
