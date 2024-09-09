package com.example.elearning.services.impl;

import com.example.elearning.dtos.UserCourseDTO;
import com.example.elearning.exceptions.ResourceNotFoundException;
import com.example.elearning.models.Course;
import com.example.elearning.models.User;
import com.example.elearning.models.UserCourse;
import com.example.elearning.repositories.UserCourseRepository;
import com.example.elearning.responses.UserCourseResponse;
import com.example.elearning.services.CourseService;
import com.example.elearning.services.UserCourseService;
import com.example.elearning.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserCourseServiceImpl implements UserCourseService {
    private final UserCourseRepository userCourseRepository;
    private final UserService userService;
    private final CourseService courseService;

    @Override
    @Transactional
    public UserCourseResponse createUserCourse(UserCourseDTO userCourseDTO) {
        User user = userService.findById(userCourseDTO.getUserId());
        Course course = courseService.findById(userCourseDTO.getCourseId());
        UserCourse userCourse = UserCourse.builder()
                .user(user)
                .course(course)
                .enrolledAt(LocalDateTime.now())
                .build();
        userCourseRepository.save(userCourse);
        return UserCourseResponse.fromUserCourse(userCourse);
    }

    @Override
    @Transactional
    public UserCourseResponse updateUserCourse(long id, UserCourseDTO userCourseDTO) {
        UserCourse userCourse = userCourseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserCourse not found"));
        User user = userService.findById(userCourseDTO.getUserId());
        Course course = courseService.findById(userCourseDTO.getCourseId());
        userCourse.setUser(user);
        userCourse.setCourse(course);
        userCourseRepository.save(userCourse);
        return UserCourseResponse.fromUserCourse(userCourse);
    }

    @Override
    public UserCourseResponse getUserCourseById(long id) {
        UserCourse userCourse = userCourseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserCourse not found"));
        return UserCourseResponse.fromUserCourse(userCourse);
    }

    @Override
    public List<UserCourseResponse> getAllUserCoursesByUser(long uid) {
        User user = userService.findById(uid);
        return userCourseRepository.findAllByUser(user)
                .stream()
                .map(UserCourseResponse::fromUserCourse)
                .toList();
    }
}
