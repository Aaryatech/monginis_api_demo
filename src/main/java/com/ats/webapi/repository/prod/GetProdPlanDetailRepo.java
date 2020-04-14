package com.ats.webapi.repository.prod;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.prod.GetProdPlanDetail;

public interface GetProdPlanDetailRepo  extends JpaRepository<GetProdPlanDetail, Integer>{

	
	
	@Query(value=" SELECT t_production_plan_detail.production_header_id,\n" + 
			"t_production_plan_detail.production_detail_id,\n" + 
			"t_production_plan_detail.item_id,\n" + 
			"t_production_plan_detail.opening_qty,\n" + 
			"t_production_plan_detail.order_qty,\n" + 
			"t_production_plan_detail.plan_qty,\n" + 
			"t_production_plan_detail.production_qty,\n" + 
			"t_production_plan_detail.rejected_qty,\n" + 
			"t_production_plan_detail.production_batch,\n" + 
			"t_production_plan_detail.production_date,"
			+ "m_item.item_name"
			+ " FROM t_production_plan_detail, m_item WHERE t_production_plan_detail.production_header_id=:planHeaderId "
			+ "AND m_item.id=t_production_plan_detail.item_id order by m_item.item_grp1 Asc,m_item.item_grp2 Asc,m_item.item_name Asc\n" + 
			"",nativeQuery=true)
		
	List<GetProdPlanDetail> getProdPlanDetailByHeaderId(@Param("planHeaderId") int planHeaderId);
	
}
