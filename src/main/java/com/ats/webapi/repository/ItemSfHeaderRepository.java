package com.ats.webapi.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.Orders;
import com.ats.webapi.model.rawmaterial.GetItemSfHeader;
import com.ats.webapi.model.rawmaterial.ItemSfHeader;

@Repository
public interface  ItemSfHeaderRepository extends JpaRepository<GetItemSfHeader, Integer>{

//manual query two tables
	
	@Query(value = " SELECT\n" + 
			"        m_sf_type.sf_type_name,\n" + 
			"        m_item_sf_header.sf_name,\n" + 
			"        m_item_sf_header.sf_id,\n" + 
			"        m_item_sf_header.sf_type,\n" + 
			"        m_item_sf_header.sf_uom_id,\n" + 
			"        m_item_sf_header.sf_weight,\n" + 
			"        m_item_sf_header.stock_qty,\n" + 
			"        m_item_sf_header.min_level_qty,\n" + 
			"        m_item_sf_header.max_level_qty,\n" + 
			"        m_item_sf_header.reorder_level_qty,\n" + 
			"        m_item_sf_header.mul_factor,\n" + 
			"        m_item_sf_header.del_status \n" + 
			"    from\n" + 
			"        m_item_sf_header,\n" + 
			"        m_sf_type \n" + 
			"    WHERE\n" + 
			"        m_item_sf_header.sf_type=m_sf_type.id \n" + 
			"        AND m_item_sf_header.del_status=:delStatus order by m_item_sf_header.sf_name Asc", nativeQuery = true)

	List<GetItemSfHeader> getSfItemHeader(@Param("delStatus")int delStatus);
	
	
	
}
