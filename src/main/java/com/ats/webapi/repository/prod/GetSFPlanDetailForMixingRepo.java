package com.ats.webapi.repository.prod;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.prod.mixing.GetSFPlanDetailForMixing;

//New Repo Sachin

public interface GetSFPlanDetailForMixingRepo extends JpaRepository<GetSFPlanDetailForMixing, Integer> {

	

	/*@Query(value=" SELECT m_item_detail.item_detail_id, m_item_detail.rm_id,m_item_detail.rm_qty,m_item_detail.no_pieces_per_item,"
			+ "m_item_detail.item_id,m_item_detail.rm_name,"
			+ "m_item_detail.rm_type,m_rm_uom.uom ,t_production_plan_detail.plan_qty,t_production_plan_detail.order_qty," + 
			"CASE WHEN t_production_plan_header.is_planned=1 THEN \n" + 
			"sum((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item) "
			+ "ELSE " + 
			"sum((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item) "
			+ "END " + 
			" AS total,m_item_sf_detail.sf_id, m_item_sf_header.mul_factor  from m_item_detail,t_production_plan_header,m_rm_uom,t_production_plan_detail,m_item_sf_header,m_item_sf_detail "
			+ " where  m_rm_uom.uom_id=m_item_detail.rm_uom_id AND m_item_sf_header.sf_id=m_item_sf_detail.sf_id AND  "
			+ "t_production_plan_detail.item_id=m_item_detail.item_id AND m_item_detail.rm_type=2 AND "
			+ "t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id AND "
			+ "t_production_plan_header.production_header_id=:headerId GROUP BY rm_id" + 
			"",nativeQuery=true)
	
	List<GetSFPlanDetailForMixing> getSFAndPlanDetailForMixing(@Param("headerId") int headerId);
	
	
	//  moved to other repo: ProdMixingReqP1Repo repository.prod
	*/
	// 2nd Query by Sumit Sir 30  JAn 2018 for Prod to mixing req
	/*@Query(value=" SELECT m_item_detail.item_detail_id, m_item_detail.item_id, m_item_detail.rm_name, "
			+ "m_item_detail.rm_type, t_production_plan_detail.plan_qty, t_production_plan_detail.order_qty,"
			+ "m_item_detail.rm_id, m_item_detail.no_pieces_per_item, m_item_detail.rm_qty,"
			+ "SUM((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)as total,m_rm_uom.uom, "
			+ "coalesce((Select m_item_sf_header.mul_factor From m_item_sf_header where m_item_sf_header.sf_id=m_item_detail.rm_id),0) "
			+ "FROM m_item_detail, t_production_plan_header, t_production_plan_detail,m_rm_uom "
			+ "WHERE t_production_plan_detail.item_id=m_item_detail.item_id AND "
			+ "t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id AND "
			+ "t_production_plan_header.production_header_id=:headerId AND m_rm_uom.uom_id=m_item_detail.rm_uom_id and m_item_detail.rm_type=2"
			+ " GROUP BY m_item_detail.rm_id " + 
			"",nativeQuery=true)
	
	List<GetSFPlanDetailForMixing> getSFAndPlanDetailForMixing(@Param("headerId") int headerId);
	*/
	
	

	//same Bean Used for Bom and Mixing
	
	
	
	
	/*@Query(value=" SELECT m_item_detail.item_detail_id, m_item_detail.rm_id,m_item_detail.rm_qty,m_item_detail.no_pieces_per_item,"
			+ "m_item_detail.item_id,m_item_detail.rm_name,"
			+ "m_item_detail.rm_type,m_rm_uom.uom ,t_production_plan_detail.plan_qty,t_production_plan_detail.order_qty," + 
			"CASE WHEN t_production_plan_header.is_planned=1 THEN \n" + 
			"sum((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item) "
			+ "ELSE " + 
			"sum((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item) "
			+ "END " + 
			" AS total,m_item_sf_detail.sf_id, m_item_sf_header.mul_factor  FROM m_item_detail,t_production_plan_header,m_rm_uom,t_production_plan_detail,m_item_sf_detail,m_item_sf_header "
			+ "WHERE  m_rm_uom.uom_id=m_item_detail.rm_uom_id AND m_item_sf_header.sf_id=m_item_sf_detail.sf_id AND "
			+ "t_production_plan_detail.item_id=m_item_detail.item_id AND "
			+ "t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id AND "
			+ "t_production_plan_header.production_header_id=:headerId GROUP BY rm_id" + 
			"",nativeQuery=true)
	
	List<GetSFPlanDetailForMixing> getSfPlanDetailForBom(@Param("headerId") int headerId);
	*/
	// NEW query FOR bom fROM pROD SUMIT sIR 30 jan 2018
	@Query(value=" SELECT m_item_detail.item_detail_id, m_item_detail.item_id, m_item_detail.rm_name, m_item_detail.rm_type,"
			+ " t_production_plan_detail.plan_qty, t_production_plan_detail.order_qty,"
			+ "m_item_detail.rm_id, m_item_detail.no_pieces_per_item, m_item_detail.rm_qty,"
			+ "CASE WHEN t_production_plan_header.is_planned=0 THEN SUM((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)"
			+ "ELSE  SUM((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item) END as total,"
			+ "m_rm_uom.uom FROM m_item_detail, t_production_plan_header, t_production_plan_detail,m_rm_uom "
			+ "WHERE t_production_plan_detail.item_id=m_item_detail.item_id AND "
			+ "t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id AND "
			+ "t_production_plan_header.production_header_id =:headerId AND m_rm_uom.uom_id=m_item_detail.rm_uom_id GROUP by m_item_detail.rm_id\n" + 
			"\n" + 
			"" + 
			"",nativeQuery=true)
	
	List<GetSFPlanDetailForMixing> getSfPlanDetailForBom(@Param("headerId") int headerId);
	
}
