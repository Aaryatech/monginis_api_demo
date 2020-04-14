package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.rawmaterial.ItemSfHeader;

public interface ItemSfHeaderRepo extends JpaRepository<ItemSfHeader, Integer>{

	ItemSfHeader save(ItemSfHeader itemSfHeader);
	
	@Transactional
	@Modifying
	@Query(" UPDATE ItemSfHeader SET del_status=1 WHERE sf_id=:sfId") 
	int deleteSfItem(@Param("sfId")int sfId);
	
	/*@Query(value=" SELECT sfH.sf_id,sfH.sf_name,sfH.sf_type,sfH.sf_uom_id,sfH.sf_weight,sfH.stock_qty,"
			+ "sfH.min_level_qty,sfH.max_level_qty,sfH.reorder_level_qty,sfD.sf_did,sfD.sf_id,sfD.rm_id,sfD.rm_name,sfD.rm_qty,"
			+ "sfD.rm_unit,sfD.rm_weight FROM m_item_sf_header as sfH,m_item_sf_detail as sfD")
			
	
	List<ItemSfHeader> getSfHeader();
	*/
	
}
