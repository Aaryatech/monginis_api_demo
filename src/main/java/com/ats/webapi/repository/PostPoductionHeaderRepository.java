package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.PostProdPlanHeader;
import com.ats.webapi.model.PostProductionHeader;

public interface PostPoductionHeaderRepository extends JpaRepository<PostProductionHeader, Integer> {

	PostProductionHeader save(PostProductionHeader postProductionHeader);

	
	
	/*@Query(value="SELECT t_production_plan_header.production_header_id,WHERE t_order.order_date =:date AND t_order.fr_id IN(:frId) AND t_order.menu_id =:menuId",nativeQuery=true)
		List<PostProductionHeader> getProductionOrderQty(@Param("menuId") List<String> menuId, @Param("productionDate") String productionDate, @Param("timeSlot") int timeSlot);
*/
}
