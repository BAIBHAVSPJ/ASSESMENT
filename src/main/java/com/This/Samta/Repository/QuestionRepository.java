package com.This.Samta.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.This.Samta.Entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

	@Query(value = "SELECT * FROM Question ORDER BY RAND() LIMIT 1", nativeQuery = true)
	Question getRandomQuestion();

}
