package com.ats.webapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.CategoryList;
import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.MCategory;
import com.ats.webapi.model.SubCategory;
import com.ats.webapi.repository.CategoryRepository;
import com.ats.webapi.repository.SubCategoryRepository;
import com.ats.webapi.util.JsonUtil;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

	@Autowired
	private SubCategoryRepository subCategoryRepository;

	@Autowired
    private CategoryRepository categoryRepository;
    
	String jsonUser = "{}";

	public String saveSubCategory(SubCategory subCategory) {
		SubCategory subCategory1;
		
		if(subCategory.getSubCatId()!=0||!subCategory.getSubCatName().equalsIgnoreCase("")){
			 subCategory1=subCategoryRepository.findOne(subCategory.getSubCatId());

			if(subCategory.getSubCatName()==""||!subCategory.getSubCatName().equalsIgnoreCase(""))
			{
				subCategory1 = subCategoryRepository.save(subCategory);	

				ErrorMessage errorMessage=new ErrorMessage();
				errorMessage.setError(false);
				errorMessage.setMessage("SubCategory Inserted Successfully");
				jsonUser = JsonUtil.javaToJson(errorMessage);

			}
	else
	{
		ErrorMessage errorMessage=new ErrorMessage();
		errorMessage.setError(true);
		errorMessage.setMessage("SubCategory already exist");
		jsonUser = JsonUtil.javaToJson(errorMessage);
	
	}
	}
		else
		{
			ErrorMessage errorMessage=new ErrorMessage();
			errorMessage.setError(true);
			errorMessage.setMessage("SubCategory fields are empty");
			jsonUser = JsonUtil.javaToJson(errorMessage);
		
		}
		return jsonUser;
	}
	
	
	public SubCategory findSubCategory(int subCatId) {
		SubCategory subCategory=subCategoryRepository.findOne(subCatId);
		return subCategory;
	}
	
	public SubCatergoryList findAllSubCategories() {
		
		    List<SubCategory> subCategories=new ArrayList<SubCategory>();
			ErrorMessage errorMessage=new ErrorMessage();
			SubCatergoryList subCategoryList=new SubCatergoryList();
			
		subCategories=subCategoryRepository.findByDelStatus(0);
		if(subCategories!=null)
		{
			
			errorMessage.setError(false);
			errorMessage.setMessage("All SubCategories displayed successfully");
			subCategoryList.setErrorMessage(errorMessage);
			subCategoryList.setSubCategory(subCategories);
			
		}
		else
		{
			errorMessage.setError(true);
			errorMessage.setMessage("SubCategories Not Found");
			subCategoryList.setErrorMessage(errorMessage);
		}
		
		return subCategoryList;
	}


	@Override
	public CategoryList findSubCategoryByCatId(int catId) {
		  List<MCategory> subCategoryList=categoryRepository.findByCatId(catId);
		  
		  for(int i=0;i<subCategoryList.size();i++)
		  {
			  List<SubCategory> subCatList=subCategoryRepository.findByCatIdAndDelStatus(catId, 0);
			  subCategoryList.get(i).setSubCategoryList(subCatList);
		      
		  }
		  CategoryList subCategoryListByCateId=new CategoryList();
		  if(subCategoryList!=null)
		  {
			  ErrorMessage errorMessage=new ErrorMessage();
			  errorMessage.setError(false);
			  errorMessage.setMessage("SubCategories Found Successfully");
			  
			  subCategoryListByCateId.setmCategoryList(subCategoryList);
			  subCategoryListByCateId.setErrorMessage(errorMessage);
		  }
		  else
		  { 
			  ErrorMessage errorMessage=new ErrorMessage();
		      errorMessage.setError(true);
		      errorMessage.setMessage("SubCategories Not Found ");
		  
		      subCategoryListByCateId.setErrorMessage(errorMessage);
			  
		  }
		return subCategoryListByCateId;
	}


	@Override
	public List<SubCategory> getAllSubCategory() {
		List<SubCategory> allSubCategory=subCategoryRepository.findByDelStatus(0);

		return allSubCategory;
	}

//new patna
	@Override
	public List<SubCategory> findSubCatByCatId(int catId) {
		
		List<SubCategory> subList=subCategoryRepository.findByCatIdAndDelStatus(catId, 0);
		return subList;
	}


	@Override
	public List<SubCategory> getSubCatListByCatIdInForDisp(List<String> catId) {
		List<SubCategory> subList=subCategoryRepository.findByCatIdInAndDelStatus(catId);
		return subList;
	}

}
