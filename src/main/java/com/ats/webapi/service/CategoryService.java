package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.MCategory;


public interface CategoryService {

	public List<MCategory> findAllCategory();
	
	List<MCategory> findAllOnlyCategory(List<Integer> list);
	
}
