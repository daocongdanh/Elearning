package com.example.elearning.services.impl;

import com.example.elearning.dtos.CategoryDTO;
import com.example.elearning.exceptions.ResourceNotFoundException;
import com.example.elearning.models.Category;
import com.example.elearning.repositories.CategoryRepository;
import com.example.elearning.responses.CategoryResponse;
import com.example.elearning.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    @Transactional
    public CategoryResponse createCategory(CategoryDTO categoryDTO) {
        Category category = Category.builder()
                .name(categoryDTO.getName())
                .level(categoryDTO.getLevel())
                .build();
        if(categoryDTO.getCategoryId() != null){
            Category categoryParent = findById(categoryDTO.getCategoryId());
            category.setCategory(categoryParent);
        }
        categoryRepository.save(category);
        return CategoryResponse.fromCategory(category);
    }

    @Override
    public CategoryResponse getCategoryById(long id) {
        Category category = findById(id);
        return CategoryResponse.fromCategory(category);
    }

    @Override
    @Transactional
    public CategoryResponse updateCategory(long id, CategoryDTO categoryDTO) {
        Category category = findById(id);
        category.setName(categoryDTO.getName());
        category.setLevel(categoryDTO.getLevel());
        if(categoryDTO.getCategoryId() != null){
            Category categoryParent = findById(categoryDTO.getCategoryId());
            category.setCategory(categoryParent);
        }
        else category.setCategory(null);
        categoryRepository.save(category);
        return CategoryResponse.fromCategory(category);
    }

    @Override
    public List<CategoryResponse> getAllCategoriesByLevel(Long level) {
        return categoryRepository.findAllByLevel(level)
                .stream()
                .map(CategoryResponse::fromCategory)
                .toList();
    }

    @Override
    public List<CategoryResponse> getAllCategoriesByParent(long parentId) {
        Category categoryParent = findById(parentId);
        return categoryRepository.findAllByCategory(categoryParent)
                .stream()
                .map(CategoryResponse::fromCategory)
                .toList();
    }

    @Override
    public Category findById(long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }
}
