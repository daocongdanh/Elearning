package com.example.elearning.repositories;

import com.example.elearning.models.User;
import com.example.elearning.models.UserCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCourseRepository extends JpaRepository<UserCourse, Long> {
    List<UserCourse> findAllByUser(User user);
}
