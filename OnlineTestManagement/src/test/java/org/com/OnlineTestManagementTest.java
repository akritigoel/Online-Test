package org.com;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class OnlineTestManagementTest {

	static Logger logger=LoggerFactory.getLogger(OnlineTestManagementTest.class);
	
	RestTemplate template;
	
	@BeforeEach
	public void setUp()
	{
		template=new RestTemplate();		
	}
	
	@Test
	public void addTest()
	{
		Assessment Assessment=new Assessment();
		Assessment.setTestId(BigInteger.valueOf(1100));
		Assessment.setTestTitle("Assessment1");
		Assessment.setTestDuration(LocalTime.parse("1:00"));
		Assessment.setTestTotalMarks(BigDecimal.valueOf(100));
		Assessment.setTestMarksScored(BigDecimal.valueOf(56));
		Assessment.setStartTime(LocalTime.parse("10:00"));
		Assessment.setEndTime(LocalTime.parse("11:00"));
		
	
		Assessment test=template.postForObject("http://localhost:9090/test/addTest", 
					Assessment, Assessment.class);
		Assertions.assertNotNull(test);
		logger.info("Add Assessment Working..."+test);
		
	}
	
	@Test
	public void updateTest()
	{
		Assessment Assessment=new Assessment();
		Assessment.setTestId(BigInteger.valueOf(1100));
		Assessment.setTestTitle("Assessment1");
		Assessment.setTestDuration(LocalTime.parse("1:00"));
		Assessment.setTestTotalMarks(BigDecimal.valueOf(100));
		Assessment.setTestMarksScored(BigDecimal.valueOf(82));
		Assessment.setStartTime(LocalTime.parse("10:00"));
		Assessment.setEndTime(LocalTime.parse("11:00"));
		
	
		Assessment test=template.postForObject("http://localhost:9090/test/updateTest", Assessment, Assessment.class);
		Assertions.assertNotNull(test);
		logger.info("Update Test Working..."+test);
	
	}
	

	@Test
	public void deleteTest() {
		Assessment assessment = new Assessment();
		assessment.setTestId(BigInteger.valueOf(1002));
		
		template.delete("http://localhost:9090/test/deleteTest/1002", assessment);
		logger.info("search product works ");
	}

	@Test
	public void getTestById() {
		/*Assessment assessment=new Assessment();
		assessment.setTestId(BigInteger.valueOf(1002));
		
		
		Assessment test = template.getForObject("http://localhost:9090/test/findTestById/1002", Assessment.class);
		ResponseEntity<Assessment> test1 = template.getForEntity("http://localhost:9090/test/findTestById/1002", Assessment.class);
	
		Assertions.assertNotNull(test);
				
		logger.info("Find Test By Id works "+test1.getStatusCode());*/
		
		Assessment assessment=template.getForObject("http://localhost:9090/test/findTestById/41", Assessment.class);
		Assertions.assertNotNull(assessment);
		logger.info("!! Search Test By Id Works !!");
	}
	
	@Test
	public void getAllTest() {
		Assessment test = template.getForObject("http://localhost:9090/test/AllTest", Assessment.class);
		ResponseEntity<Assessment> test1 = template.getForEntity("http://localhost:9090/test/AllTest", Assessment.class);
	
		Assertions.assertNotNull(test1);
				
		logger.info("Get All Test works "+ test1.getStatusCode());
	}

@Test
	public void addQuestion()
	{
		Question question= new Question();
		question.setQuestionId(BigInteger.valueOf(102));
	
		Question question1=template.postForObject("http://localhost:9090/test/addQuestion", 
					question, Question.class);
		Assertions.assertNotNull(question1);
		logger.info("Add Question Working..."+question1);
		
	}
	
	@Test
	public void updateQuestion()
	{
		Question question= new Question();
		
		question.setQuestionId(BigInteger.valueOf(102));
		Question question1=template.postForObject("http://localhost:9090/test/updateQuestion/1001", 
					question, Question.class);
		Assertions.assertNotNull(question1);
		logger.info("Update Question Working..."+question1);
		
	
	}
	

	@Test
	public void deleteQuestion() {
		Question question =new Question();
		question.setQuestionId(BigInteger.valueOf(102));
		
		template.delete("http://localhost:9090/test/deleteQuestion/102", question);
		logger.info("search question  works ");
	}

	@Test
	public void getQuestionById() {
		Question question=template.getForObject("http://localhost:9090/test/findQuestionById/41", Question.class);
		Assertions.assertNotNull(question);
		logger.info("!! Search Question By Id Works !!");
	}
	
	@Test
	public void getAllQuestion() {
		Question question = template.getForObject("http://localhost:9090/test/AllQuestions", Question.class);
		ResponseEntity<Question> ques1 = template.getForEntity("http://localhost:9090/test/AllTQuestions", Question.class);
	
		Assertions.assertNotNull(ques1);
				
		logger.info("Get All Question works "+ ques1.getStatusCode());
	}


	}
