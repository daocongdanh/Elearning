package com.example.elearning.controllers;

import com.example.elearning.dtos.UserDTO;
import com.example.elearning.responses.ResponseSuccess;
import com.example.elearning.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.prefix}/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping(value = "/register", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ResponseSuccess> createUser(@Valid @ModelAttribute UserDTO userDTO){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message("message")
                .status(HttpStatus.CREATED.value())
                .data(userService.createUser(userDTO))
                .build());
    }
}
