package com.example.elearning.repositories;

import com.example.elearning.models.Course;
import com.example.elearning.models.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {
    List<Module> findAllByCourse(Course course);
}
