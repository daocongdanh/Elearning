package com.example.elearning.repositories;

import com.example.elearning.models.Course;
import com.example.elearning.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByCourse(Course course);
}
