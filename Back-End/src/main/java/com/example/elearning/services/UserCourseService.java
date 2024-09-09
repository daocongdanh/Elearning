package com.example.elearning.services;

import com.example.elearning.dtos.UserCourseDTO;
import com.example.elearning.responses.UserCourseResponse;

import java.util.List;

public interface UserCourseService {
    UserCourseResponse createUserCourse(UserCourseDTO userCourseDTO);
    UserCourseResponse updateUserCourse(long id, UserCourseDTO userCourseDTO);
    UserCourseResponse getUserCourseById(long id);
    List<UserCourseResponse> getAllUserCoursesByUser(long uid);
}
