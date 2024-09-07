package com.example.elearning.services;

import com.example.elearning.dtos.ModuleDTO;
import com.example.elearning.models.Module;
import com.example.elearning.responses.ModuleResponse;

import java.util.List;

public interface ModuleService {
    ModuleResponse createModule(ModuleDTO moduleDTO);
    ModuleResponse updateModule(long id, ModuleDTO moduleDTO);
    ModuleResponse getModuleById(long id);
    List<ModuleResponse> getAllModulesByCourse(long cid);
    Module findById(long id);
}
