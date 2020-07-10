package com.ats.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.MCategory;
import com.ats.webapi.model.SubCategory;
import com.ats.webapi.repository.CategoryRepository;
import com.ats.webapi.repository.SubCategoryRepository;
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	SubCategoryRepository subCategoryRepository;
	
	@Override
	public List<MCategory> findAllCategory() {
		List<MCategory> mCategoryList=categoryRepository.findByDelStatus(0);
		
		for(int i=0;i<mCategoryList.size();i++)
		{
			List<SubCategory> subCatList=subCategoryRepository.findByCatIdAndDelStatus(mCategoryList.get(i).getCatId(),0);
			mCategoryList.get(i).setSubCategoryList(subCatList);
		}
		return mCategoryList;
	}
	
	@Override
	public List<MCategory> findAllOnlyCategory(List<Integer> list) {
		
		List<MCategory> mCategoryList=categoryRepository.findByDelStatusAndIsSameDayInOrderBySeqNoAsc(0,list);
		
		 
		return mCategoryList;
	}
		
}
