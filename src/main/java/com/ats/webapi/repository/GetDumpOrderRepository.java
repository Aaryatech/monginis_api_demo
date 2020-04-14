package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GetDumpOrder;



public interface GetDumpOrderRepository extends JpaRepository<GetDumpOrder, Integer>{
	
	//if select franchisee list and Order_date
	
	//@Query(value="select t_order.* from t_order where t_order.fr_id IN (:frId) AND order_date= :date AND menu_id= :menuId ",nativeQuery=true)
@Query(value="SELECT t_order.order_id ,t_order.fr_id ,t_order.menu_id ,t_order.order_qty ,t_order.item_id"
		+ " from t_order WHERE t_order.order_date =:date AND t_order.fr_id IN(:frId) AND t_order.menu_id =:menuId",nativeQuery=true)
	List<GetDumpOrder> findAllNativeFrOrder(@Param("frId")List<String> frId,@Param("menuId")String menuId,@Param("date")String date);


}
