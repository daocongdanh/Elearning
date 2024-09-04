package com.example.elearning.repositories;

import com.example.elearning.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByLevel(Long level);
    List<Category> findAllByCategory(Category category);
}
