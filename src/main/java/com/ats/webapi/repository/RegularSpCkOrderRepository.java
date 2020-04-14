package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.RegularSpCake;

@Repository
public interface RegularSpCkOrderRepository extends JpaRepository<RegularSpCake, Integer>{


	RegularSpCake save(RegularSpCake regularSpCake);

	
	
	@Transactional
	@Modifying
	@Query("UPDATE RegularSpCake t SET t.isBillGenerated =:status  WHERE t.rspId=:orderId")
	int updateRegSpCakeBillStatus(@Param("orderId") int orderId,@Param("status") int status);


	@Transactional
	@Modifying
	@Query("UPDATE RegularSpCake t SET t.isBillGenerated =1  WHERE item_id IN(:regOrderItemId) AND rsp_produ_date=:prodDate AND t.isBillGenerated=0")
	int updateRegSpCakeBillStatus(@Param("regOrderItemId")List<Integer> regOrderItemId,@Param("prodDate") String prodDate);

}
