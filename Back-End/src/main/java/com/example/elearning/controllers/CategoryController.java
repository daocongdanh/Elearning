package com.example.elearning.controllers;

import com.example.elearning.dtos.CategoryDTO;
import com.example.elearning.responses.CategoryResponse;
import com.example.elearning.responses.ResponseSuccess;
import com.example.elearning.services.CategoryService;
import com.example.elearning.utils.Translator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("")
    public ResponseEntity<ResponseSuccess> createCategory(@Valid @RequestBody CategoryDTO categoryDTO){
        CategoryResponse category = categoryService.createCategory(categoryDTO);
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message(Translator.toLocale("category.create.success"))
                .status(HttpStatus.CREATED.value())
                .data(category)
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseSuccess> getCategoryById(@PathVariable long id){
        CategoryResponse category = categoryService.getCategoryById(id);
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message(Translator.toLocale("category.get_by_id.success"))
                .status(HttpStatus.OK.value())
                .data(category)
                .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseSuccess> updateCategory(@PathVariable long id,
                                                          @Valid @RequestBody CategoryDTO categoryDTO){
        CategoryResponse category = categoryService.updateCategory(id, categoryDTO);
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message(Translator.toLocale("category.update.success"))
                .status(HttpStatus.OK.value())
                .data(category)
                .build());
    }

    @GetMapping("/level/{level}")
    public ResponseEntity<ResponseSuccess> getAllCategoriesByLevel(@PathVariable long level){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message(Translator.toLocale("category.get_all_by_level.success"))
                .status(HttpStatus.OK.value())
                .data(categoryService.getAllCategoriesByLevel(level))
                .build());
    }

    @GetMapping("/parent/{parentId}")
    public ResponseEntity<ResponseSuccess> getAllCategoriesByParent(@PathVariable long parentId){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message(Translator.toLocale("category.get_all_by_parent.success"))
                .status(HttpStatus.OK.value())
                .data(categoryService.getAllCategoriesByParent(parentId))
                .build());
    }
}
