package com.bansikah.quizapp.dao;

import com.bansikah.quizapp.model.Question;
import com.bansikah.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {

    @Query(value = "SELECT * FROM question q WHERE q.category =:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numQ);
}
