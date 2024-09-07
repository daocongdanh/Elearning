package com.example.elearning.controllers;

import com.example.elearning.dtos.ModuleDTO;
import com.example.elearning.responses.ResponseSuccess;
import com.example.elearning.services.ModuleService;
import com.example.elearning.utils.Translator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}/modules")
@RequiredArgsConstructor
public class ModuleController {
    private final ModuleService moduleService;

    @PostMapping("")
    public ResponseEntity<ResponseSuccess> createModule(@Valid @RequestBody ModuleDTO moduleDTO){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message("Create module successfully")
                .status(HttpStatus.CREATED.value())
                .data(moduleService.createModule(moduleDTO))
                .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseSuccess> updateModule(@PathVariable long id,
                                                        @Valid @RequestBody ModuleDTO moduleDTO){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message("Update module successfully")
                .status(HttpStatus.OK.value())
                .data(moduleService.updateModule(id, moduleDTO))
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseSuccess> getModuleById(@PathVariable long id){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message("Get module information successfully")
                .status(HttpStatus.OK.value())
                .data(moduleService.getModuleById(id))
                .build());
    }

    @GetMapping("/course/{cid}")
    public ResponseEntity<ResponseSuccess> getAllModulesByCourse(@PathVariable long cid){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message("Get all modules by course information successfully")
                .status(HttpStatus.OK.value())
                .data(moduleService.getAllModulesByCourse(cid))
                .build());
    }
}
