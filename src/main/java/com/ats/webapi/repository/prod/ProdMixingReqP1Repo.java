package com.ats.webapi.repository.prod;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.prod.ProdMixingReqP1;
//30 Jan 2018 //for web service URL : getSfPlanDetailForMixing
public interface ProdMixingReqP1Repo  extends JpaRepository<ProdMixingReqP1, Integer>{
	//ProdMixingReqP1 phase 1 prod to mixing Req

	/*@Query(value=" SELECT m_item_detail.item_detail_id, m_item_detail.item_id, m_item_detail.rm_name, "
			+ "m_item_detail.rm_type, t_production_plan_detail.plan_qty, t_production_plan_detail.order_qty,"
			+ "m_item_detail.rm_id, m_item_detail.no_pieces_per_item, m_item_detail.rm_qty,"
			+ "CASE WHEN t_production_plan_header.is_planned=1 THEN SUM((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)"
			+ "ELSE SUM((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item) END AS total,m_rm_uom.uom, "
			+ "coalesce((Select m_item_sf_header.mul_factor From m_item_sf_header where m_item_sf_header.sf_id=m_item_detail.rm_id),0)as mul_factor "
			+ "FROM m_item_detail, t_production_plan_header, t_production_plan_detail,m_rm_uom,m_item_sf_header "
			+ "WHERE t_production_plan_detail.item_id=m_item_detail.item_id AND "
			+ "t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id AND "
			+ "t_production_plan_header.production_header_id=:headerId AND m_rm_uom.uom_id=m_item_detail.rm_uom_id and m_item_detail.rm_type=2"
			+ " GROUP BY m_item_detail.rm_id " + 
			"",nativeQuery=true)
	
	List<ProdMixingReqP1> getSFAndPlanDetailForMixing(@Param("headerId") int headerId);
	*/
	
	//2 Feb 2018 query Sumit Sir 
	@Query(value="sELECT m_item_detail.item_detail_id, m_item_detail.item_id, m_item_detail.rm_name, m_item_detail.rm_type,"
			+ "sum(t_production_plan_detail.plan_qty) as plan_qty, sum(t_production_plan_detail.order_qty) AS order_qty,m_item_detail.rm_id, "
			+ "m_item_detail.no_pieces_per_item, m_item_detail.rm_qty,CASE WHEN t_production_plan_header.is_planned=1 "
			+ "THEN ((SUM(t_production_plan_detail.plan_qty)* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item) "
			+ "ELSE ((SUM(t_production_plan_detail.order_qty)* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item) END AS total "
			+ ",m_rm_uom.uom, coalesce((Select m_item_sf_header.mul_factor From m_item_sf_header "
			+ "where m_item_sf_header.sf_id=m_item_detail.rm_id),0) AS mul_factor FROM m_item_detail, "
			+ "t_production_plan_header, t_production_plan_detail,m_rm_uom WHERE t_production_plan_detail.item_id=m_item_detail.item_id "
			+ "AND t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id "
			+ "AND t_production_plan_header.production_header_id=:headerId AND m_rm_uom.uom_id=m_item_detail.rm_uom_id and m_item_detail.rm_type=2 "
			+ "GROUP BY m_item_detail.rm_id " + 
			"",nativeQuery=true)
	
	List<ProdMixingReqP1> getSFAndPlanDetailForMixing(@Param("headerId") int headerId);
}
