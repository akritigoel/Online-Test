package org.com.onlinetest.controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.com.onlinetest.exception.RecordNotFoundException;
import org.com.onlinetest.model.Assessment;
import org.com.onlinetest.model.Question;
import org.com.onlinetest.service.QuestionService;
import org.com.onlinetest.service.StudentService;
import org.com.onlinetest.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4300")
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestService testservice;
	@Autowired
	private QuestionService questionservice;
	@Autowired
	private StudentService studentservice;
	
	
	// add new test
	@PostMapping("/addTest")
	public Assessment addTest(@RequestBody Assessment test) {

		return testservice.addTest(test);

	}

	// update test
		@PutMapping("/updateTest")
		public ResponseEntity<Assessment> updateTest( @RequestBody Assessment test)
				throws RecordNotFoundException {

			return testservice.updateTest(test);
		}

	// delete test
	@DeleteMapping("/deleteTest/{id}")
	public String deleteTest(@PathVariable(value = "id") BigInteger testId) throws RecordNotFoundException {

		return testservice.deleteTest(testId);
	}

	// get Test By Id
	@GetMapping("/findTestById/{id}")
	public ResponseEntity<Assessment> getTestById(@PathVariable(value = "id") BigInteger testId)
			throws RecordNotFoundException {

		return testservice.getTestById(testId);
	}

	// Get All Test
	@GetMapping("/AllTest")
	public List<Assessment> getAllTest(BigInteger testId) {

		return testservice.getAllTest(testId);

	}

	// add question
	@PostMapping("/addQuestion/{testId}")
	public Question addQuestion(@PathVariable(value = "testId") BigInteger testId, @RequestBody Question question) {
		return questionservice.addQuestion(testId, question);

	}

	// update question
	@PutMapping("/updateQuestion/{id}")
	public String updateQuestion(@PathVariable(value = "id") BigInteger testId,@RequestBody Question questionDetails)
			throws RecordNotFoundException {
		return questionservice.updateQuestion(testId,questionDetails);
	}

	// delete question
	@DeleteMapping("/deleteQuestion/{id}")
	public String deleteQuestion(@PathVariable(value = "id") BigInteger questionId) throws RecordNotFoundException {

		return questionservice.deleteQuestion(questionId);
	}

	// show question
	@GetMapping("/AllQuestions")
	public List<Question> getQuestions() {

		return questionservice.viewAll();

	}
	
	//show question by id
	@GetMapping("/findQuestionById/{id}")
	public ResponseEntity<Question[]> getQuestionsById(@PathVariable(value = "id") BigInteger testId)
			throws RecordNotFoundException {

		return questionservice.getQuestionById(testId);
	}


	// calculate marks
	@GetMapping("/getMarks")
	public BigDecimal calculateTotalMarks(/* @PathVariable(value="id") */BigInteger testId)
			throws RecordNotFoundException {
		return testservice.calculateTotalMarks(testId);
	}
	
	//assign test to student
	@PutMapping("/assignTest/{studentId}/{testId}")
	public String assignTest(@PathVariable(value="studentId")BigInteger studentId,
									@PathVariable(value="testId")BigInteger testId)
	{
		return studentservice.assignTest(studentId,testId);
	}
}
