package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.UpdateSellBillTimeStamp;

public interface UpdateSellBillTimeStampRepo extends JpaRepository<UpdateSellBillTimeStamp, Integer> {
	
	
	@Transactional
	@Modifying
	@Query("UPDATE UpdateSellBillTimeStamp  SET timeStamp=:timeStamp WHERE sellBillNo=:sellBillNo")
	int updateTimeForSellBill(@Param("sellBillNo") int sellBillNo,@Param("timeStamp") String timeStamp);


}
