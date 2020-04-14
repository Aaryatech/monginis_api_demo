package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.ItemWithSubCat;
import com.ats.webapi.model.Orders;

public interface PrevItemOrderRepository extends  CrudRepository<Orders, Long>{
	
	
 @Query(value = "SELECT * FROM t_order WHERE t_order.fr_id=:frId AND t_order.item_id IN(:items) AND t_order.production_date=:date AND t_order.menu_id=:menuId", nativeQuery = true)
    List<Orders> findAllOrders(@Param("items")List<Integer>items ,@Param("frId") String frId,@Param("date") String date,@Param("menuId") String menuId);
 
}