package com.example.elearning.services;

import com.example.elearning.dtos.CourseDTO;
import com.example.elearning.models.Category;
import com.example.elearning.models.Course;
import com.example.elearning.models.User;
import com.example.elearning.responses.CourseResponse;

import java.util.List;

public interface CourseService {
    CourseResponse createCourse(CourseDTO courseDTO);
    CourseResponse updateCourse(long id, CourseDTO courseDTO);
    CourseResponse getCourseById(long id);
    List<CourseResponse> getAllCoursesByUser(long uid);
    List<CourseResponse> getAllCoursesByCategory(long cid);
    List<CourseResponse> getAllCourses();
    Course findById(long id);
}
