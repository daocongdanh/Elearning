package com.example.elearning.repositories;

import com.example.elearning.models.Progress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {
}
