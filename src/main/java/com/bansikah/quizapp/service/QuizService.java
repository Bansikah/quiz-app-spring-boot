package com.bansikah.quizapp.service;

import com.bansikah.quizapp.dao.QuestionDAO;
import com.bansikah.quizapp.dao.QuizRepository;
import com.bansikah.quizapp.model.Question;
import com.bansikah.quizapp.model.QuestionWrapper;
import com.bansikah.quizapp.model.Quiz;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("quizService") // quizService.createQuiz()
public class QuizService {
    @Autowired
    QuizRepository quizRepository;
    @Autowired
    QuestionDAO questionDAO;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Question> questions = quizRepository.findRandomQuestionsByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepository.save(quiz);
        return ResponseEntity.ok("Quiz created");
    }

    public List<QuestionWrapper> getQuizQuestions(int id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        List<Question> questionFromDAO = quiz.get().getQuestions();
        List<QuestionWrapper> questionForUser = new ArrayList<>();
        for (Question q : questionFromDAO) {
           QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(),q.getOption1(), q.getOption2(),
                   q.getOption3(), q.getOption4());
            questionForUser.add(qw);
        }
        return new ResponseEntity<>(questionForUser, HttpStatus.OK).getBody();
    }


    public ResponseEntity<String> submitQuiz(int id, List<com.bansikah.quizapp.model.Response> responses) {

        Optional<Quiz> quiz = quizRepository.findById(id);
        List<Question> questionFromDAO = quiz.get().getQuestions();
        for (int i = 0; i < questionFromDAO.size(); i++) {
            if (responses.get(i).isError()) {
                questionFromDAO.get(i).setCorrect(true);
            } else {
                questionFromDAO.get(i).setCorrect(false);
            }
        }
        quizRepository.save(quiz.get());
        System.out.println("Quiz submitted");
        return new ResponseEntity<>("Quiz submitted", HttpStatus.OK);
    }
}
