package com.ats.webapi.repository.prod;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.prod.GetProdPlanHeader;

public interface GetProdHeaderRepo extends JpaRepository<GetProdPlanHeader, Integer> {
	
@Query(value=" SELECT t_production_plan_header.production_header_id,t_production_plan_header.is_planned,\n" + 
		"t_production_plan_header.production_date,\n" + 
		"t_production_plan_header.cat_id,\n" + 
		"t_production_plan_header.production_batch,\n" + 
		"t_production_plan_header.production_status,\n" + 
		"t_production_plan_header.time_slot,\n" + 
		"t_production_plan_header.is_mixing,\n" + 
		"t_production_plan_header.is_bom,\n" + 
		"t_production_plan_header.del_status,\n" + 
		"m_category.cat_name FROM t_production_plan_header, m_category WHERE m_category.cat_id=t_production_plan_header.cat_id \n" + 
		"AND t_production_plan_header.production_date BETWEEN :fromDate AND :toDate and t_production_plan_header.del_status=0",nativeQuery=true)
	
	List<GetProdPlanHeader> getProdPlanHeader(@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	
}
