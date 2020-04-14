package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.GetProductionItemQty;


@Repository
public interface GetProductionItemQtyRepository extends JpaRepository<GetProductionItemQty, Integer>{

	
	@Query(value = "SELECT t_production_plan_header.production_header_id, t_production_plan_detail.production_detail_id ,t_production_plan_header.production_date, SUM(t_production_plan_detail.production_qty) as qty, t_production_plan_detail.item_id, m_item.item_name FROM t_production_plan_header,t_production_plan_detail, m_item WHERE t_production_plan_header.production_date =:productionDate AND  t_production_plan_header.cat_id=:catId AND t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id AND m_item.id=t_production_plan_detail.item_id GROUP BY t_production_plan_detail.item_id", nativeQuery = true)
	List<GetProductionItemQty> findProdItemQty(@Param("productionDate") String productionDate, @Param("catId") int catId);

	@Query(value = " SELECT\n" + 
			"        t_order.order_id as production_detail_id ,\n" + 
			"        coalesce(0) as production_header_id,\n" + 
			"        t_order.order_date as production_date,\n" + 
			"        SUM(t_order.order_qty) as qty,\n" + 
			"        t_order.item_id,\n" + 
			"        m_item.item_name \n" + 
			"    FROM\n" + 
			"        t_order,\n" + 
			"        m_item \n" + 
			"    WHERE\n" + 
			"        t_order.order_date =:productionDate \n" + 
			"        AND  t_order.order_type=:catId \n" + 
			"        AND m_item.id=t_order.item_id \n" + 
			"    GROUP BY\n" + 
			"        t_order.item_id\n" + 
			" ", nativeQuery = true)
	List<GetProductionItemQty> getOrderuItemQty(@Param("productionDate") String productionDate, @Param("catId") int catId);

}
