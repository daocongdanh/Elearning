package com.example.elearning.repositories;

import com.example.elearning.models.UserQuestionAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserQuestionAnswerRepository extends JpaRepository<UserQuestionAnswer, Long> {
}
