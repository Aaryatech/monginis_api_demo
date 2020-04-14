package com.ats.webapi.model.afe;

import java.util.List;

import com.ats.webapi.model.Info;

public class AfeQuestionList {
	
	List<AfeQuestion> afeQuestion;
	
	Info info;

	public List<AfeQuestion> getAfeQuestion() {
		return afeQuestion;
	}

	public void setAfeQuestion(List<AfeQuestion> afeQuestion) {
		this.afeQuestion = afeQuestion;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "AfeQuestionList [afeQuestion=" + afeQuestion + ", info=" + info + "]";
	}

}
