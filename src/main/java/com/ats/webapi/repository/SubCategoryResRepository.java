package com.ats.webapi.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.SubCategoryRes;
@Repository
public interface SubCategoryResRepository extends JpaRepository<SubCategoryRes, Integer>{

	@Modifying
	@Transactional
	@Query("Update SubCategoryRes  SET del_status=1 WHERE subCatId=:subCatId")
	int deleteSubCategory(@Param("subCatId")int subCatId);

	SubCategoryRes findBySubCatId(int subCatId);

}
