package com.ats.webapi.model;

import java.util.List;

public class MessageList {
	List<Message> message;
	Info info;
	public List<Message> getMessage() {
		return message;
	}
	public void setMessage(List<Message> message) {
		this.message = message;
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	
	
	
}
