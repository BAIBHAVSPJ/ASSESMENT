package com.This.Samta.Response_Request;

import com.This.Samta.Entity.Question;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NextQuestionResponse {

	private String correctAnswer;
	private Question nextQuestion;

}
