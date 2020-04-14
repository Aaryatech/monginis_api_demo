package com.ats.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.GetMCategory;
import com.ats.webapi.model.GetMCategoryList;
import com.ats.webapi.repository.MCatRepository;

@Service
public class GetMCategoryServiceImpl implements GetMCategoryService{
	
	@Autowired
	MCatRepository mCatRepository;

	@Override
	public GetMCategoryList getMainCategory(int delStatus) {
		GetMCategoryList mCategoryList=new GetMCategoryList();
		
		List<GetMCategory> mCategory=mCatRepository.findByDelStatus(0);
		mCategoryList.setGetMCategory(mCategory);
		
		return mCategoryList;
	}
	
	

}
