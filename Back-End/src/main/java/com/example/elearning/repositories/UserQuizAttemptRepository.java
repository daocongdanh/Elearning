package com.example.elearning.repositories;

import com.example.elearning.models.UserQuizAttempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserQuizAttemptRepository extends JpaRepository<UserQuizAttempt, Long> {
}
