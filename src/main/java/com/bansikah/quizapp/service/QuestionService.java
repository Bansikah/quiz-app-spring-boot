package com.bansikah.quizapp.service;

import com.bansikah.quizapp.dao.QuestionDAO;
import com.bansikah.quizapp.model.Question;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@Service
public class QuestionService {
    @Autowired
    QuestionDAO questionDAO;
    public ResponseEntity<List<Question>> getAllQuestion() {
      try {
          return  new ResponseEntity<>(questionDAO.findAll(), HttpStatus.OK);
      }catch ( Exception e) {
          e.printStackTrace();
          }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Question> addQuestion(Question question) {
        try {
            return new ResponseEntity<>(questionDAO.save(question), HttpStatus.CREATED);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new Question(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
        return new ResponseEntity<>(questionDAO.findByCategory(category), HttpStatus.OK);
    }

    public ResponseEntity<Question> updateQuestion(Question question) {
        try {
            return new ResponseEntity<>(questionDAO.save(question), HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>( HttpStatus.OK);
    }

    public void deleteQuestion(int id) {
        questionDAO.deleteById(id);
        System.out.println("Question deleted");
    }
}
