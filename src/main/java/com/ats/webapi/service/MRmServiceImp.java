package com.ats.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.MRm;
import com.ats.webapi.model.MRmList;
import com.ats.webapi.repository.MRmRepository;

@Service
public class MRmServiceImp implements MRmService{
	
	@Autowired
	MRmRepository mRmRepository;

	@Override
	public MRmList getlist(int rmId) {
		
		MRmList mRmList = new MRmList();
		Info info = new Info();
		
		try
		{
			List<MRm> list = mRmRepository.getList(rmId);
			mRmList.setList(list);
			info.setError(false);
			info.setMessage("success");
			mRmList.setInfo(info);
			
		}catch(Exception e)
		{
			
			info.setError(true);
			info.setMessage("failed");
			mRmList.setInfo(info);
		}
		return mRmList;
		
		
	}

}
