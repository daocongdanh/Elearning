package com.example.backend.repositories;

import com.example.backend.models.UserQuestionAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserQuestionAnswerRepository extends JpaRepository<UserQuestionAnswer, Long> {
}
