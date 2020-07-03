package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.MCategory;
import com.ats.webapi.model.SubCategory;


public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {
	public SubCategory save(SubCategory subCategory);

	@Query(value="Select * from m_cat_sub where del_status=:i order by cat_id,sub_cat_id",nativeQuery=true)
	public List<SubCategory> findByDelStatus(@Param("i")int i);

	@Query(value="Select * from m_cat_sub where cat_id in(:catId) and del_status=0 order by seq_no asc",nativeQuery=true)
	public List<SubCategory> findByCatIdInAndDelStatus(@Param("catId")List<String> catId);

	@Query(value="Select * from m_cat_sub where del_status=0 order by cat_id,sub_cat_id",nativeQuery=true)
	public List<SubCategory> findAllSubCategories();
/*
	@Query(value="Select * from m_cat_sub where del_status=:delStatus and cat_id=:catId order by cat_id,sub_cat_id",nativeQuery=true)
	public List<SubCategory> findByCatIdAndDelStatusOrderByCatIdAndSubCatId(@Param("catId")int catId,@Param("delStatus") int delStatus);
*/
	public List<SubCategory> findByCatIdAndDelStatus(int catId, int i);

	public List<SubCategory> findBySubCatIdInAndDelStatus(List<Integer> catId, int i);

}
