package com.example.elearning.services.impl;

import com.example.elearning.dtos.CourseDTO;
import com.example.elearning.exceptions.ResourceNotFoundException;
import com.example.elearning.models.Category;
import com.example.elearning.models.Course;
import com.example.elearning.models.Tag;
import com.example.elearning.models.User;
import com.example.elearning.repositories.CourseRepository;
import com.example.elearning.responses.CourseResponse;
import com.example.elearning.services.CategoryService;
import com.example.elearning.services.CourseService;
import com.example.elearning.services.TagService;
import com.example.elearning.services.UserService;
import com.example.elearning.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final FileUtil fileUtil;
    private final UserService userService;
    private final CategoryService categoryService;
    private final TagService tagService;

    @Override
    @Transactional
    public CourseResponse createCourse(CourseDTO courseDTO) {
        Category category = categoryService.findById(courseDTO.getCategoryId());
        User user = userService.findById(courseDTO.getUserId());
        Course course = Course.builder()
                .title(courseDTO.getTitle())
                .description(courseDTO.getDescription())
                .price(courseDTO.getPrice())
                .isFree(courseDTO.isFree())
                .active(true)
                .user(user)
                .category(category)
                .build();
        if(courseDTO.getTagId() != null){
            Tag tag = tagService.getTagById(courseDTO.getTagId());
            course.setTag(tag);
        }
        else course.setTag(null);

        String image = fileUtil.uploadImage(courseDTO.getImage());
        if(StringUtils.hasLength(image)){
            course.setImage(image);
        }
        courseRepository.save(course);
        return CourseResponse.fromCourse(course);
    }

    @Override
    @Transactional
    public CourseResponse updateCourse(long id, CourseDTO courseDTO) {
        Course course = findById(id);
        Category category = categoryService.findById(courseDTO.getCategoryId());
        User user = userService.findById(courseDTO.getUserId());
        course.setTitle(courseDTO.getTitle());
        course.setDescription(courseDTO.getDescription());
        course.setPrice(courseDTO.getPrice());
        course.setFree(courseDTO.isFree());
        course.setUser(user);
        course.setCategory(category);

        if(courseDTO.getTagId() != null){
            Tag tag = tagService.getTagById(courseDTO.getTagId());
            course.setTag(tag);
        }
        else course.setTag(null);
        String image = fileUtil.uploadImage(courseDTO.getImage());
        if(StringUtils.hasLength(image)){
            course.setImage(image);
        }
        courseRepository.save(course);
        return CourseResponse.fromCourse(course);
    }

    @Override
    public CourseResponse getCourseById(long id) {
        Course course = findById(id);
        return CourseResponse.fromCourse(course);
    }

    @Override
    public List<CourseResponse> getAllCoursesByUser(long uid) {
        User user = userService.findById(uid);
        return courseRepository.findAllByUser(user)
                .stream()
                .map(CourseResponse::fromCourse)
                .toList();
    }

    @Override
    public List<CourseResponse> getAllCoursesByCategory(long cid) {
        Category category = categoryService.findById(cid);
        return courseRepository.findAllByCategory(category)
                .stream()
                .map(CourseResponse::fromCourse)
                .toList();
    }

    @Override
    public List<CourseResponse> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(CourseResponse::fromCourse)
                .toList();
    }

    @Override
    public Course findById(long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));
    }
}
