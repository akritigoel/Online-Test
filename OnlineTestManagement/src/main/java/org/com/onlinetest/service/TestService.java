package org.com.onlinetest.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.com.onlinetest.dao.TestDao;
import org.com.onlinetest.exception.RecordNotFoundException;
import org.com.onlinetest.model.Assessment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class TestService {
	
	@Autowired
	private TestDao testdao;
	

//add Test	
	public Assessment addTest(Assessment test)
	   {
		  return testdao.save(test);
		   
	   }
		
	//update Test
	public ResponseEntity<Assessment> updateTest(@Valid @RequestBody Assessment test)
		{
			Optional<Assessment> findById=testdao.findById(test.getTestId());
			try {
			if(findById.isPresent())
			{
				 testdao.save(test);
				 return new ResponseEntity<Assessment>(test,HttpStatus.OK);		
			}
			else {
				throw new RecordNotFoundException("Record not present");
				}
			}
			catch(RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
			
			}
		}
		
	 
//Delete test	  
	 public String deleteTest(BigInteger testId) throws RecordNotFoundException
	    {
	    	 testdao.findById(testId).
	    	 orElseThrow(() -> new RecordNotFoundException("Test not found for the given id" +testId));
	    	testdao.deleteById(testId);
	    	return "Test Deleted Successfully...";
	    }
	 
//get All Test
	 public List<Assessment> getAllTest(BigInteger testId){
	    	
		    System.out.println("All Tests are:");
	    	return testdao.findAll();
	    	
	    }

// get Test By Id
	 public ResponseEntity<Assessment> getTestById( BigInteger testId) throws RecordNotFoundException {
		 Assessment test=testdao.findById(testId).
	   	 orElseThrow(() -> new RecordNotFoundException("Test not found for the given id" +testId));
	    	return ResponseEntity.ok().body(test);
	    }
	 
	 
	 //calculate Marks
	public BigDecimal calculateTotalMarks(BigInteger testId) throws RecordNotFoundException{
		 testdao.findById(testId).
    	 orElseThrow(() -> new RecordNotFoundException("Test not found for the given id" +testId));
    	QuestionService service=new QuestionService();
    	Assessment test= new Assessment();
    	
    	test.setTestMarksScored(BigDecimal.valueOf(service.calculateQuestionMarks(testId)));
   
           return test.getTestMarksScored();
	 }
}