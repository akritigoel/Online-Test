package org.com.onlinetest.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Time;
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
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="test")
public class Assessment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private BigInteger testId;
	private String testTitle;
	private Time testDuration;
	
	@OneToMany(targetEntity=Question.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy="test")
   
	@JsonManagedReference
	private Set<Question> testQuestions;
	private BigDecimal testTotalMarks;
	private BigDecimal testMarksScored;
	private Time startTime;
	private Time endTime;
	
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
	public Time getTestDuration() {
		return testDuration;
	}
	public void setTestDuration(Time testDuration) {
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
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	public Time getEndTime() {
		return endTime;
	}
	
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	
	public Assessment() {
		
	}
	public Assessment(BigInteger testId, String testTitle, Time testDuration, Set<Question> testQuestions,
			BigDecimal testTotalMarks, BigDecimal testMarksScored, Time startTime, Time endTime,
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

