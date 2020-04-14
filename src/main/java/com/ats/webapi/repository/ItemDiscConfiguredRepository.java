package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.ItemDiscConfigured;

public interface ItemDiscConfiguredRepository extends JpaRepository<ItemDiscConfigured, Integer>{

	@Query(value="select disc_per from m_fr_discount where is_active=1 and del_status=0  and FIND_IN_SET(:id,item_id) and FIND_IN_SET(:frId,franch_id) order by disc_id desc limit 1\n" + 
			"",nativeQuery=true)
	float findByIdAndFrId(@Param("id") int id,@Param("frId") int frId);

}
