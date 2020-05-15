package org.com;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.com.onlinetest.model.Question;
import org.com.onlinetest.model.Student;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Assessment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private BigInteger testId;
	private String testTitle;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm:ss")
	private LocalTime testDuration;
	
	@OneToMany(targetEntity=Question.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy="test")
    
	@JsonManagedReference
	private Set<Question> testQuestions;
	private BigDecimal testTotalMarks;
	private BigDecimal testMarksScored;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm:ss")
	private LocalTime startTime;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm:ss")
	private LocalTime endTime;
	
	@OneToOne
	private Student studentId;
	
	public Student getStudentId() {
		return studentId;
	}
	public void setStudentId(Student studentId) {
		this.studentId = studentId;
	}
	
	@Transient
	private int currentQuestion;
	
	public BigInteger getTestId() {
		return testId;
	}
	public void setTestId(BigInteger testId) {
		this.testId = testId;
	}
	public String getTestTitle() {
		return testTitle;
	}
	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}
	public LocalTime getTestDuration() {
		return testDuration;
	}
	public void setTestDuration(LocalTime testDuration) {
		this.testDuration = testDuration;
	}
	
	public Set<Question> getTestQuestions() {
		return testQuestions;
	}
	public void setTestQuestions(Set<Question> testQuestions) {
		this.testQuestions = testQuestions;
	}
	public BigDecimal getTestTotalMarks() {
		return testTotalMarks;
	}
	public void setTestTotalMarks(BigDecimal testTotalMarks) {
		this.testTotalMarks = testTotalMarks;
	}
	public BigDecimal getTestMarksScored() {
		return testMarksScored;
	}
	public void setTestMarksScored(BigDecimal testMarksScored) {
		this.testMarksScored = testMarksScored;
	}
	
	public int getCurrentQuestion() {
		return currentQuestion;
	}
	public void setCurrentQuestion(int currentQuestion) {
		this.currentQuestion = currentQuestion;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	
	public Assessment() {
		
	}
	public Assessment(BigInteger testId, String testTitle, LocalTime testDuration, Set<Question> testQuestions,
			BigDecimal testTotalMarks, BigDecimal testMarksScored, LocalTime startTime, LocalTime endTime,
			Student studentId, int currentQuestion) {
		super();
		this.testId = testId;
		this.testTitle = testTitle;
		this.testDuration = testDuration;
		this.testQuestions = testQuestions;
		this.testTotalMarks = testTotalMarks;
		this.testMarksScored = testMarksScored;
		this.startTime = startTime;
		this.endTime = endTime;
		this.studentId = studentId;
		this.currentQuestion = currentQuestion;
	}
	@Override
	public String toString() {
		return "Assessment [testId=" + testId + ", testTitle=" + testTitle + ", testDuration=" + testDuration
				+ ", testQuestions=" + testQuestions + ", testTotalMarks=" + testTotalMarks + ", testMarksScored="
				+ testMarksScored + ", startTime=" + startTime + ", endTime=" + endTime + ", studentId=" + studentId
				+ ", currentQuestion=" + currentQuestion + "]";
	}
	
	
	
	
}

