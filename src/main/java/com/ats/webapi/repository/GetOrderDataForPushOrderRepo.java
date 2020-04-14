package com.ats.webapi.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GetOrderDataForPushOrder;

public interface GetOrderDataForPushOrderRepo extends JpaRepository<GetOrderDataForPushOrder, Integer> {
	
	
	@Query(value=" SELECT t_order.item_id,t_order.order_id,t_order.order_qty,t_order.fr_id"
			+ " FROM t_order WHERE t_order.order_date=:cDate AND t_order.grn_type=:grnType AND t_order.fr_id IN (:frIdList)"  
			,nativeQuery=true)
	
	List<GetOrderDataForPushOrder> getOrderData(@Param("cDate") Date cDate, @Param("grnType") int grnType
			, @Param("frIdList") List<String> frIdList);
	

}
