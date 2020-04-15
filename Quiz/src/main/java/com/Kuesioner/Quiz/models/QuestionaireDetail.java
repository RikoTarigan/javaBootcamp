package com.Kuesioner.Quiz.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class QuestionaireDetail {
	@Id
	private String questionDetailId;
    private String questionHeaderCode;
    private String questionDesc;
    private String answ1;
    private String answ2;
    private String answ3;
    private String answ4;
    private String keyAnsw;
    private String point;
	public String getQuestionDetailId() {
		return questionDetailId;
	}
	public void setQuestionDetailId(String questionDetailId) {
		this.questionDetailId = questionDetailId;
	}
	public String getQuestionHeaderCode() {
		return questionHeaderCode;
	}
	public void setQuestionHeaderCode(String questionHeaderCode) {
		this.questionHeaderCode = questionHeaderCode;
	}
	public String getQuestionDesc() {
		return questionDesc;
	}
	public void setQuestionDesc(String questionDesc) {
		this.questionDesc = questionDesc;
	}
	public String getAnsw1() {
		return answ1;
	}
	public void setAnsw1(String answ1) {
		this.answ1 = answ1;
	}
	public String getAnsw2() {
		return answ2;
	}
	public void setAnsw2(String answ2) {
		this.answ2 = answ2;
	}
	public String getAnsw3() {
		return answ3;
	}
	public void setAnsw3(String answ3) {
		this.answ3 = answ3;
	}
	public String getAnsw4() {
		return answ4;
	}
	public void setAnsw4(String answ4) {
		this.answ4 = answ4;
	}
	public String getKeyAnsw() {
		return keyAnsw;
	}
	public void setKeyAnsw(String keyAnsw) {
		this.keyAnsw = keyAnsw;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
    
    
	

}
