package com.ats.webapi.repository.prod;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.prod.mixing.GetSFMixingForBom;
import com.ats.webapi.model.prod.mixing.GetSFPlanDetailForMixing;

public interface GetSFMixingForBomRepo extends JpaRepository<GetSFMixingForBom, Integer>{
	
	
	/* //old query
	@Query(value=" SELECT m_item_sf_detail.sf_id,m_item_sf_detail.sf_did,m_item_sf_detail.rm_id,m_item_sf_detail.rm_name,"
			+ " m_item_sf_detail.rm_type,m_rm_uom.uom,sum(t_mixing_detail.received_qty* m_item_sf_detail.rm_qty *m_item_sf_detail.rm_weight) "
			+ " AS total from m_item_sf_detail,t_mixing_detail,m_rm_uom,t_mixing_header "
			+ " WHERE t_mixing_detail.mixing_id =:mixingId AND m_rm_uom.uom_id=m_item_sf_detail.rm_unit "
			+ " AND t_mixing_detail.sf_id=m_item_sf_detail.sf_id AND t_mixing_header.mix_id=t_mixing_detail.mixing_detail_id "
			+ " AND m_item_sf_detail.rm_type=1 GROUP BY rm_id" + 
			"",nativeQuery=true)
	
	List<GetSFMixingForBom> getSFMixingForBom(@Param("mixingId") int mixingId);
	
	*/
	@Query(value=" SELECT m_item_sf_detail.sf_id, m_item_sf_detail.sf_did, m_item_sf_detail.rm_id ," + 
			"			m_item_sf_detail.rm_name, m_item_sf_detail.rm_type,t_mixing_detail.mixing_id ," + 
			"			m_rm_uom.uom, SUM((t_mixing_detail.received_qty*m_item_sf_detail.rm_weight)/ m_item_sf_header.sf_weight)" + 
			"			 AS total from m_item_sf_detail, t_mixing_detail,m_rm_uom,m_item_sf_header " + 
			"			WHERE t_mixing_detail.sf_id=m_item_sf_detail.sf_id AND m_item_sf_header.sf_id=m_item_sf_detail.sf_id "
			+ "and m_item_sf_detail.rm_type=1 " + 
			"			and t_mixing_detail.mixing_id=:mixingId AND m_rm_uom.uom_id=m_item_sf_detail.rm_unit" + 
			"		 GROUP BY m_item_sf_detail.rm_id" + 
			"",nativeQuery=true)
	
	List<GetSFMixingForBom> getSFMixingForBom(@Param("mixingId") int mixingId);
	
	

}
