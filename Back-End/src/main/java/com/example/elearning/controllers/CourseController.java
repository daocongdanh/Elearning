package com.example.elearning.controllers;

import com.example.elearning.dtos.CourseDTO;
import com.example.elearning.responses.ResponseSuccess;
import com.example.elearning.services.CourseService;
import com.example.elearning.utils.Translator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ResponseSuccess> createCourse(@Valid @ModelAttribute CourseDTO courseDTO){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message(Translator.toLocale("course.create.success"))
                .status(HttpStatus.CREATED.value())
                .data(courseService.createCourse(courseDTO))
                .build());
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ResponseSuccess> createCourse(@PathVariable long id,
            @Valid @ModelAttribute CourseDTO courseDTO){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message(Translator.toLocale("course.update.success"))
                .status(HttpStatus.OK.value())
                .data(courseService.updateCourse(id, courseDTO))
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseSuccess> getCourseById(@PathVariable long id){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message(Translator.toLocale("course.get_by_id.success"))
                .status(HttpStatus.OK.value())
                .data(courseService.getCourseById(id))
                .build());
    }

    @GetMapping("/user/{uid}")
    public ResponseEntity<ResponseSuccess> getAllCoursesByUser(@PathVariable long uid){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message(Translator.toLocale("course.get_all_by_user.success"))
                .status(HttpStatus.OK.value())
                .data(courseService.getAllCoursesByUser(uid))
                .build());
    }

    @GetMapping("/category/{cid}")
    public ResponseEntity<ResponseSuccess> getAllCoursesByCategory(@PathVariable long cid){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message(Translator.toLocale("course.get_all_by_category.success"))
                .status(HttpStatus.OK.value())
                .data(courseService.getAllCoursesByCategory(cid))
                .build());
    }

    @GetMapping("")
    public ResponseEntity<ResponseSuccess> getAllCourses(){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message(Translator.toLocale("course.get_all.success"))
                .status(HttpStatus.OK.value())
                .data(courseService.getAllCourses())
                .build());
    }
}
