package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.ItemIdOnly;
import com.ats.webapi.model.MCategory;

public interface CategoryRepository extends JpaRepository<MCategory, Integer>{
	
	public List<MCategory> findByDelStatus(int i);

	public List<MCategory> findByCatId(int catId);
	
	@Query(value="SELECT m_category.cat_id, m_category.cat_name,m_category.is_same_day,m_category.del_status FROM m_category,m_fr_menu_show where m_category.cat_id=m_fr_menu_show.cat_id and m_fr_menu_show.menu_id=:menuId",nativeQuery=true)
	public  List<MCategory> findCatidByMenuIdIn(@Param("menuId") int menuId);
	
	@Query(value="SELECT m_category.cat_id, m_category.cat_name,m_category.is_same_day,m_category.del_status FROM m_category,m_fr_menu_show where m_category.cat_id=m_fr_menu_show.cat_id and m_fr_menu_show.menu_id IN(:menuId) order By m_category.seq_no asc",nativeQuery=true)
	public  List<MCategory> findCatIdByMenuIdList(@Param("menuId")List<Integer> menuId);

	
	public List<MCategory> findByDelStatusAndIsSameDayInOrderBySeqNoAsc(int i, List<Integer> list);
	
}
