package com.ats.webapi.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.rawmaterial.GetRmItemSubCat;
import com.ats.webapi.model.rawmaterial.RmItemSubCategory;

@Repository
public interface RmItemSubCategoryRepository extends JpaRepository<RmItemSubCategory, Long>{

	
	RmItemSubCategory findRmItemSubCategoryBySubCatId(int subCatId);
	

	List<RmItemSubCategory> findRmItemSubCategoryByCatIdAndDelStatus(int catId, int i);

}
