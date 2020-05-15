package org.com.onlinetest.dao;

import java.math.BigInteger;

import org.com.onlinetest.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuestionDao extends JpaRepository<Question, BigInteger> {
	@Query(value="select * from questions where test_test_id=:id",nativeQuery = true)
	public Question[] findQuestionByTestId(@Param("id")BigInteger id);


}
