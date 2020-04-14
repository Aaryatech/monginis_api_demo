package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.rawmaterial.GetRmItemCategory;

@Repository
public interface GetRmItemCatRepository  extends JpaRepository<GetRmItemCategory, Long>{
	
	@Query(value="select c.cat_Id,c.grp_id,g.grp_name,c.cat_name,c.cat_desc,c.del_status from m_rm_item_cat c,m_rm_item_group g where c.grp_id=g.grp_id AND c.del_status=0 group by c.cat_id",nativeQuery=true)
	List<GetRmItemCategory> findRmItemCategoryByDelStatus();
	
}
