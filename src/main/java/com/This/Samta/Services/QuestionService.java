package com.This.Samta.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.This.Samta.Entity.Question;
import com.This.Samta.Repository.QuestionRepository;

import jakarta.transaction.Transactional;

public class QuestionService {

	private static final String RANDOM_QUESTIONS_API = "https://jservice.io/api/random";

	@Autowired
	private QuestionRepository questionRepository;

	@Transactional
	public void fetchAndSaveRandomQuestions(int count) {
		RestTemplate restTemplate = new RestTemplate();
		for (int i = 0; i < count; i++) {
			Question question = restTemplate.getForObject(RANDOM_QUESTIONS_API, Question.class);
			questionRepository.save(question);
		}
	}
}
