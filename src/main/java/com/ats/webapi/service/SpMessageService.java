package com.ats.webapi.service;

import com.ats.webapi.model.SpMessage;

public interface SpMessageService 
{
	public String save(SpMessage spmsg);
	public spMessageList findAllspMessage();
	public SpMessage findSpMessage(int spMsgId);
}
