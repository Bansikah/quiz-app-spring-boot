package com.bansikah.quizapp.controller;

import com.bansikah.quizapp.model.Question;
import com.bansikah.quizapp.service.QuestionService;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Question> addQuestion(Question question) {
        return questionService.addQuestion(question);
    }


    @GetMapping("/get")
    public ResponseEntity<List<Question>> getAllQuestion() {
        return questionService.getAllQuestion();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category) {
        return questionService.getQuestionByCategory(category);
    }

    @PutMapping("/update")
    public ResponseEntity<Question> updateQuestion(Question question) {
        return questionService.updateQuestion(question);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteQuestion(@PathVariable int id) {
        questionService.deleteQuestion(id);
    }
}
