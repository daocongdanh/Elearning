package com.example.elearning.controllers;

import com.example.elearning.dtos.UserCourseDTO;
import com.example.elearning.responses.ResponseSuccess;
import com.example.elearning.services.UserCourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}/user-courses")
@RequiredArgsConstructor
public class UserCourseController {
    private final UserCourseService userCourseService;

    @PostMapping("")
    public ResponseEntity<ResponseSuccess> createUserCourse(@Valid @RequestBody UserCourseDTO userCourseDTO){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message("Create user-course successfully")
                .status(HttpStatus.CREATED.value())
                .data(userCourseService.createUserCourse(userCourseDTO))
                .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseSuccess> updateUserCourse(@PathVariable long id,
                                                            @Valid @RequestBody UserCourseDTO userCourseDTO){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message("Update user-course successfully")
                .status(HttpStatus.OK.value())
                .data(userCourseService.updateUserCourse(id, userCourseDTO))
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseSuccess> getUserCourseById(@PathVariable long id){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message("Get user-course information successfully")
                .status(HttpStatus.OK.value())
                .data(userCourseService.getUserCourseById(id))
                .build());
    }

    @GetMapping("/user/{uid}")
    public ResponseEntity<ResponseSuccess> getAllUserCoursesByUser(@PathVariable long uid){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message("Get all user-courses by user information successfully")
                .status(HttpStatus.OK.value())
                .data(userCourseService.getAllUserCoursesByUser(uid))
                .build());
    }

}
