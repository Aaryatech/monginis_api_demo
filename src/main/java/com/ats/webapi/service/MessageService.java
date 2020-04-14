package com.ats.webapi.service;

import java.util.Date;
import java.util.List;

import com.ats.webapi.model.Message;



public interface MessageService {
	public String save(Message message);
	public List<Message> findAllMessage();
	public Message findMessage(int id);
	public List<Message> showAllMessage(Date cDate);

}
