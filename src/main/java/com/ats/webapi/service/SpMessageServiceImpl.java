package com.ats.webapi.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.Rates;
import com.ats.webapi.model.SpMessage;
import com.ats.webapi.service.spMessageList;
import com.ats.webapi.repository.SpMessageRepository;
import com.ats.webapi.util.JsonUtil;
@Service("SpMessage")
public class SpMessageServiceImpl implements SpMessageService
{
	@Autowired
	private SpMessageRepository spMessageRepository;
	
	String jsonRate = "{}";
	SpMessage spmsg = null;
	ErrorMessage errorMessage = new ErrorMessage();
	@Override
	public String save(SpMessage spmsg)
	{
		
		try {
			spmsg = spMessageRepository.save(spmsg);
				errorMessage.setError(false);
				errorMessage.setMessage("Record Inserted Successfully");

				jsonRate = JsonUtil.javaToJson(errorMessage);
			
		} catch (Exception e) {
			errorMessage.setError(true);
			errorMessage.setMessage("Exception occured while inserting NewUser");
			jsonRate = JsonUtil.javaToJson(errorMessage);
			
		}
		return jsonRate;
		
	}
	public spMessageList findAllspMessage() {
		 List<SpMessage> spmsg=new ArrayList<SpMessage>();
		  spMessageList spmsglist=new spMessageList();
		ErrorMessage errorMessage=new ErrorMessage();
		spmsg=spMessageRepository.findByDelStatusOrderBySpMsgTextAsc(0);
		if(spmsg!=null)
		{
			
			errorMessage.setError(false);
			errorMessage.setMessage("All items displayed successfully");
			spmsglist.setErrorMessage(errorMessage);
			spmsglist.setSpMessage(spmsg);
		}
		else
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Items Not Found");
			spmsglist.setErrorMessage(errorMessage);
		}
		
		return spmsglist;
	}
	@Override
	public SpMessage findSpMessage(int spMsgId) {
		SpMessage spMessage=spMessageRepository.findOne(spMsgId);
		return spMessage;
	}
	

}
