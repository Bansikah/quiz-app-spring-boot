package com.bansikah.quizapp.controller;

import com.bansikah.quizapp.model.QuestionWrapper;
import com.bansikah.quizapp.model.Response;
import com.bansikah.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz") // localhost:8080/quiz/...
public class QuizController {

    @Autowired
    QuizService quizService;

    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ,
                                                     @RequestParam String title) {
        return quizService.createQuiz(category, numQ, title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@RequestParam int id) {
        return new ResponseEntity<>(quizService.getQuizQuestions(id), HttpStatus.OK);
    }

    @GetMapping("submit/{id}")
    public ResponseEntity<String> submitQuiz(@RequestParam int id, @RequestBody List<Response> responses) {
        return quizService.submitQuiz(id, responses);
    }
}
