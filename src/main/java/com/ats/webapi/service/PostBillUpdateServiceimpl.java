package com.ats.webapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.PostBillDetail;
import com.ats.webapi.repository.PostBillDetailRepository;

@Service
public class PostBillUpdateServiceimpl implements PostBillUpdateService {
	
	@Autowired
	PostBillDetailRepository postBillDetailRepository;

	@Override
	public PostBillDetail save(PostBillDetail postBillDetail) {
		
		PostBillDetail postBillDetailUpdate=postBillDetailRepository.save(postBillDetail);
		
		
		return postBillDetailUpdate;
	}
	
	
	

}
