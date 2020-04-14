package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.rawmaterial.GetRmItemSubCat;

@Repository
public interface GetRmItemSubCatRepository extends JpaRepository<GetRmItemSubCat, Long>{
	
	@Query(value="select s.sub_cat_id,s.cat_id,c.cat_name,s.sub_cat_name,s.sub_cat_desc,s.del_status from m_rm_item_sub_cat s,m_rm_item_cat c where s.cat_id=c.cat_id AND s.del_status=0 group by s.sub_cat_id;",nativeQuery=true)
	List<GetRmItemSubCat> findRmItemSubCategoryByDelStatus();
}
