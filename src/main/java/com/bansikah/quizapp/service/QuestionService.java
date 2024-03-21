package com.bansikah.quizapp.service;

import com.bansikah.quizapp.dao.QuestionDAO;
import com.bansikah.quizapp.model.Question;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDAO questionDAO;
    public List<Question> getAllQuestion() {
        return questionDAO.findAll();
    }

    public Question addQuestion(Question question) {
        return questionDAO.save(question);
    }
}
