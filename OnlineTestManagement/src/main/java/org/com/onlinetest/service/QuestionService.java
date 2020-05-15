package org.com.onlinetest.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.com.onlinetest.dao.QuestionDao;
import org.com.onlinetest.dao.TestDao;
import org.com.onlinetest.exception.RecordNotFoundException;
import org.com.onlinetest.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
	@Autowired
	private QuestionDao questiondao;
	@Autowired
	private TestDao testdao;

	Question q = new Question();

	// add Question
	public Question addQuestion(BigInteger testId, Question question) {

		question.setTest(testdao.findById(testId).get());

		return questiondao.save(question);
	}

	// deleteQuestion
	public String deleteQuestion(BigInteger qid) {
		Optional<Question> findById = questiondao.findById(qid);
		if (findById.isPresent()) {
			questiondao.deleteById(qid);
			return "deleted";
		} else {
			return "!!   Id Is Invalid   !!";
		}
	}

	// updateQuestion
	public String updateQuestion(BigInteger testId, Question question) {

		System.out.println("question id is " + question.getQuestionId() + "   question marks is  " + question.getMarksScored());
		System.out.println("question  " + question);

		question.setTest(testdao.findById(testId).get());
		questiondao.save(question);
		return "Question updated";

	}
	
	//getAllQuestions
	public List<Question> viewAll() {

		System.out.println(questiondao.findAll());
		return questiondao.findAll();
	}

	//get question By Id
	public ResponseEntity<Question[]> getQuestionById( BigInteger testId) throws RecordNotFoundException {
   Optional<?> findId=testdao.findById(testId);
   
		Question[] question=questiondao.findQuestionByTestId(testId);
    	return ResponseEntity.ok().body(question);
    }

	int marks = 0;

	// calculate marks
	public int calculateQuestionMarks(BigInteger id) {

		if (q.getChoice() == q.getChosenAnswer()) {
			marks = q.getQuestionMarks() + marks;
		}
		return marks;

	}

	

}
