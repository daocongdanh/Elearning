package com.example.elearning.repositories;

import com.example.elearning.models.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {
}
