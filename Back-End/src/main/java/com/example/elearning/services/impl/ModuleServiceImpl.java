package com.example.elearning.services.impl;

import com.example.elearning.dtos.ModuleDTO;
import com.example.elearning.exceptions.ResourceNotFoundException;
import com.example.elearning.models.Course;
import com.example.elearning.models.Module;
import com.example.elearning.repositories.ModuleRepository;
import com.example.elearning.responses.ModuleResponse;
import com.example.elearning.services.CourseService;
import com.example.elearning.services.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModuleServiceImpl implements ModuleService {
    private final ModuleRepository moduleRepository;
    private final CourseService courseService;
    @Override
    @Transactional
    public ModuleResponse createModule(ModuleDTO moduleDTO) {
        Course course = courseService.findById(moduleDTO.getCourseId());
        Module module = Module.builder()
                .title(moduleDTO.getTitle())
                .position(moduleDTO.getPosition())
                .course(course)
                .build();
        moduleRepository.save(module);
        return ModuleResponse.fromModule(module);
    }

    @Override
    @Transactional
    public ModuleResponse updateModule(long id, ModuleDTO moduleDTO) {
        Module module = findById(id);
        module.setTitle(moduleDTO.getTitle());
        module.setPosition(moduleDTO.getPosition());
        moduleRepository.save(module);
        return ModuleResponse.fromModule(module);
    }

    @Override
    public ModuleResponse getModuleById(long id) {
        Module module = findById(id);
        return ModuleResponse.fromModule(module);
    }

    @Override
    public List<ModuleResponse> getAllModulesByCourse(long cid) {
        Course course = courseService.findById(cid);
        return moduleRepository.findAllByCourse(course)
                .stream()
                .map(ModuleResponse::fromModule)
                .toList();
    }

    @Override
    public Module findById(long id) {
        return moduleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Module not found"));
    }
}
