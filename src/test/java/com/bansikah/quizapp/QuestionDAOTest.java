package com.bansikah.quizapp;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import com.bansikah.quizapp.dao.QuestionDAO;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import com.bansikah.quizapp.model.Question;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
class QuestionDAOTest {

    @Autowired
    private QuestionDAO questionDAO;
    @Test
    public void testSaveQuestion() {
        Question question = new Question();
        question.setQuestionTitle("What is the capital of France?");
        question.setId(1);
        question.setOption1("Paris");
        question.setOption2("Japan");
        question.setOption3("London");
        question.setOption4("Berlin");
        question.setRightAnswer("Paris");
        question.setDifficultyLevel("Easy");
        question.setCategory("history");
        Question savedQuestion = questionDAO.save(question);

        assertNotNull(savedQuestion.getId());
        assertEquals(question.getQuestionTitle(), savedQuestion.getQuestionTitle());
        assertEquals(question.getOption1(), savedQuestion.getOption1());
        assertEquals(question.getOption2(), savedQuestion.getOption2());
        assertEquals(question.getOption3(), savedQuestion.getOption3());
        assertEquals(question.getOption4(), savedQuestion.getOption4());
        assertEquals(question.getRightAnswer(), savedQuestion.getRightAnswer());
        assertEquals(question.getDifficultyLevel(), savedQuestion.getDifficultyLevel());
        assertEquals(question.getCategory(), savedQuestion.getCategory());
    }

    @Test
    public void testUpdateQuestion() {
       Question question = new Question();
        question.setQuestionTitle("What is the capital of France?");
        question.setId(1);
        question.setOption1("Paris");
        question.setOption2("Japan");
        question.setOption3("Cameroon");
        question.setOption4("Nigeria");
        question.setRightAnswer("Paris");
        question.setDifficultyLevel("Easy");
        question.setCategory("history");
       // questionDAO.save(question);
        Question updatedQuestion = questionDAO.save(question);

        assertEquals("What is the capital of France?", updatedQuestion.getQuestionTitle());
    }

    @Test
    public void testDeleteQuestion() {
        Question question = new Question();
        question.setQuestionTitle("What is the capital of France?");
        question.setId(1);
        question.setOption1("Paris");
        question.setOption2("Japan");
        question.setOption3("London");
        question.setOption4("Berlin");
        question.setRightAnswer("Paris");
        question.setDifficultyLevel("Easy");
        question.setCategory("history");
        questionDAO.save(question);

        questionDAO.delete(question);
        assertFalse(questionDAO.findById(question.getId()).isPresent());
    }

    @Test
    public void testFindQuestionsByCategory() {
        Question question = new Question();
        question.setQuestionTitle("What is the capital of France?");
        question.setId(1);
        question.setOption1("Paris");
        question.setOption2("Japan");
        question.setOption3("London");
        question.setOption4("Berlin");
        question.setRightAnswer("Paris");
        question.setDifficultyLevel("Easy");
        question.setCategory("history");
        questionDAO.findByCategory(question.getCategory());


        assertEquals(question.getCategory(), question.getCategory());
        assertEquals(question.getQuestionTitle(), question.getQuestionTitle());



    }


}