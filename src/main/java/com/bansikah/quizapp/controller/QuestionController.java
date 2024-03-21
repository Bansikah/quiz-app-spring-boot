package com.bansikah.quizapp.controller;

import com.bansikah.quizapp.model.Question;
import com.bansikah.quizapp.service.QuestionService;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/questions")  // /api/questions
public class QuestionController {

    @Autowired
    QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/add")
    public Question addQuestion(Question question) {
        return questionService.addQuestion(question);
    }


    @RequestMapping("/get")
    public List<Question> getAllQuestion() {
        return questionService.getAllQuestion();
    }

}
