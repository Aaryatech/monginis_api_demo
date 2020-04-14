package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.rawmaterial.GetRmItemCategory;
import com.ats.webapi.model.rawmaterial.GetRmItemSubCat;
import com.ats.webapi.model.rawmaterial.RmItemCategory;
import com.ats.webapi.model.rawmaterial.RmItemSubCategory;

@Repository
public interface RmItemCategoryRepository extends JpaRepository<RmItemCategory, Long>{

	RmItemCategory findRmItemCategoryByCatId(int catId);
	List<RmItemCategory> findRmItemCategoryByGrpIdAndDelStatus(int grpId, int i);
	

}
