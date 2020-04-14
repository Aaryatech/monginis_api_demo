package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.CategoryList;
import com.ats.webapi.model.SubCategory;

public interface SubCategoryService {
	
	public SubCategory findSubCategory(int subCatId);
	public String saveSubCategory(SubCategory subCategory);
	public SubCatergoryList findAllSubCategories();
	public List<SubCategory> getAllSubCategory();
	public CategoryList findSubCategoryByCatId(int catId);
	List<SubCategory>  findSubCatByCatId(int catId);
	public List<SubCategory> getSubCatListByCatIdInForDisp(List<String> catId);
}
