package org.com.onlinetest.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.com.onlinetest.dao.StudentDao;
import org.com.onlinetest.dao.TestDao;
import org.com.onlinetest.exception.RecordNotFoundException;
import org.com.onlinetest.model.Assessment;
import org.com.onlinetest.model.Question;
import org.com.onlinetest.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class StudentService {
	@Autowired
	private StudentDao stdDao;
	@Autowired
	private TestDao testdao;
	
//add student
	public Student addStudent(Student std)
	   {
		   return  stdDao.save(std);		   
	   }
	 
	 
//Update student	
	
		public ResponseEntity<Student> updateStudent(@Valid @RequestBody Student std)
			{
				Optional<Student> findById=stdDao.findById(std.getStudentId());
				try {
				if(findById.isPresent())
				{
					 stdDao.save(std);
					 return new ResponseEntity<Student>(std,HttpStatus.OK);		
				}
				else {
					throw new RecordNotFoundException("Record not present");
					}
				}
				catch(RecordNotFoundException e) {
				return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
				
			}
				}
			
//Delete student	  
	 public String deleteStudent(BigInteger stdId) throws RecordNotFoundException
	    {
		 Optional<Student> findById = stdDao.findById(stdId);
			if (findById.isPresent()) {
				stdDao.deleteById(stdId);
				return "deleted";
			} else {
				return "!!   Id Is Invalid   !!";
			}
	    }
	 
//get All student
	 public List<Student> getAllStudent(BigInteger stdId){
	    	
		    System.out.println("All Students are:");
	    	return stdDao.findAll();   	
	    }

// get student By Id
	 public ResponseEntity<Student> getStudentById( BigInteger stdId) throws RecordNotFoundException {
	    	Student stdStudent=stdDao.findById(stdId).
	   	 orElseThrow(() -> new RecordNotFoundException("Test not found for the given id" +stdId));
	    	return ResponseEntity.ok().body(stdStudent);
	    }
	 
	 
	//login
	 public BigInteger checkLogin(String loginName,String password) {
		 Optional<BigInteger> findById=stdDao.checkLogin(loginName,password);
		 if(findById.isPresent()) {
			 BigInteger id=findById.get();
			 return id;
		 }
		 else return null;
	 }
	 
	 //getTestByStudentId
		public BigInteger getTestByStudentId(BigInteger studentId)
				throws RecordNotFoundException {

			BigInteger id1= stdDao.getTestByStudentId(studentId);
			return id1;
		}

	 
    //AssignTest
	 public String assignTest(BigInteger studentId,BigInteger testId)
		{
			Optional<Student>findById=stdDao.findById(studentId);
			Optional<Assessment>test=testdao.findById(testId);
			if(findById.isPresent()&& test.isPresent())
			{
				Student student=findById.get();
				student.setTestId(testId);
				stdDao.save(student);
				return "Test Assigned";
				
			}
			return "User or Test does not exist";
			
		}
	
}
