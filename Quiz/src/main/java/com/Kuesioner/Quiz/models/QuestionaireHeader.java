package com.Kuesioner.Quiz.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class QuestionaireHeader {
	@Id
	private String questionHeaderCode;
	private String  questionType;
	
	public String getQuestionHeaderCode() {
		return questionHeaderCode;
	}
	public void setQuestionHeaderCode(String questionHeaderCode) {
		this.questionHeaderCode = questionHeaderCode;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	
	
}
