/*package com.ats.webapi.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GetOrderDataForPushOrder;
import com.ats.webapi.model.rawmaterial.GetItemSfHeader;

public interface GetItemSfHeaderRepo extends JpaRepository<GetItemSfHeader, Integer> {
	
	
	@Query(value=" SELECT m_item_sf_header.*"
			+ " FROM m_item_sf_header where del_status=0"  ,nativeQuery=true)
	
	List<GetItemSfHeader> getItemSfHeaderDetail();

}
*/