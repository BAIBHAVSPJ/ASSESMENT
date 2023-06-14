package com.This.Samta.Response_Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NextQuestionRequest {

	private Long questionId;
	private String answer;

}
