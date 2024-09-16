package com.example.elearning.controllers;

import com.example.elearning.dtos.TagDTO;
import com.example.elearning.responses.ResponseSuccess;
import com.example.elearning.services.TagService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}/tags")
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;

    @PostMapping("")
    public ResponseEntity<ResponseSuccess> createTag(@Valid @RequestBody TagDTO tagDTO){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message("Create tag successfully")
                .status(HttpStatus.CREATED.value())
                .data(tagService.createTag(tagDTO))
                .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseSuccess> updateTag(@PathVariable long id,
                                                     @Valid @RequestBody TagDTO tagDTO){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message("Update tag successfully")
                .status(HttpStatus.OK.value())
                .data(tagService.updateTag(id, tagDTO))
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseSuccess> getTagById(@PathVariable long id){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message("Get tag information successfully")
                .status(HttpStatus.OK.value())
                .data(tagService.getTagById(id))
                .build());
    }

    @GetMapping("")
    public ResponseEntity<ResponseSuccess> getAllTags(){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message("Get all tag information successfully")
                .status(HttpStatus.OK.value())
                .data(tagService.getAllTags())
                .build());
    }
}
