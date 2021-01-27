package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.rawmaterial.RmItemGroup;

public interface RmItemGroupRepostitory extends JpaRepository<RmItemGroup, Integer>{
	
	List<RmItemGroup> findByDelStatus(int delStatus);

	@Query(value="select g.grp_id,g.grp_name,g.del_status from m_rm_item_group g,m_rm_rate_verif v where g.del_status=0 and g.grp_id IN(select  grp_id from m_rm_rate_verif where supp_id=:suppId) group by g.grp_id",nativeQuery=true)
	List<RmItemGroup> getGroupBySupp(@Param("suppId")int suppId);

	
}
