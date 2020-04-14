package com.ats.webapi.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.UpdateOrder;

public interface UpdateOrdersRepository extends JpaRepository<UpdateOrder, Integer>{
	
	

	@Transactional
	@Modifying
	@Query("UPDATE UpdateOrder t SET t.orderQty=:orderQty,t.editQty=:orderQty   WHERE t.orderId=:orderId")
	int updateOrderQty(@Param("orderId") int orderId,@Param("orderQty") int orderQty);

	
	@Transactional
	@Modifying
	@Query(" DELETE FROM UpdateOrder WHERE  orderId IN(:orderId)")
	int deleteOrder(@Param("orderId") List<Integer> orderId);
}
