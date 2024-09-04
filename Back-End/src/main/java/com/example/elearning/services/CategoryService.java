package com.example.elearning.services;

import com.example.elearning.dtos.CategoryDTO;
import com.example.elearning.models.Category;
import com.example.elearning.responses.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse createCategory(CategoryDTO categoryDTO);
    CategoryResponse getCategoryById(long id);
    CategoryResponse updateCategory(long id, CategoryDTO categoryDTO);
    List<CategoryResponse> getAllCategoriesByLevel(Long level);
    List<CategoryResponse> getAllCategoriesByParent(long parentId);
    Category findById(long id);
}
