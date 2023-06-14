package com.This.Samta.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.This.Samta.Entity.Question;
import com.This.Samta.Repository.QuestionRepository;
import com.This.Samta.Response_Request.NextQuestionRequest;
import com.This.Samta.Response_Request.NextQuestionResponse;
import com.This.Samta.Services.QuestionService;
import com.This.Samta.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api")
public class QuestionController {
	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private QuestionService questionService;

	// ... existing endpoints

	@PostMapping("/fetch-random-questions")
	public void fetchRandomQuestions(@RequestParam("count") int count) {
		questionService.fetchAndSaveRandomQuestions(count);
	}

	@GetMapping("/play")
	public Question play() {
		Question question = questionRepository.getRandomQuestion();
		return question;
	}

	@PostMapping("/next")
	public NextQuestionResponse nextQuestion(@RequestBody NextQuestionRequest request) {
		Long questionId = request.getQuestionId();
		String userAnswer = request.getAnswer();

		Question currentQuestion = questionRepository.findById(questionId).orElseThrow(
				() -> new ResourceNotFoundException("User with given id is not found on server !! : " + questionId));

		String correctAnswer = currentQuestion.getAnswer();

		Question nextQuestion = questionRepository.getRandomQuestion();

		return new NextQuestionResponse(correctAnswer, nextQuestion);
	}

}
