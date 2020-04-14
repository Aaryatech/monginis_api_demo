package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.SpCakeCount;

public interface SpCakeCountRepo extends JpaRepository<SpCakeCount, Integer> {

	@Query(value = "SELECT COUNT(*) as COUNT FROM t_sp_cake  WHERE t_sp_cake.del_status=0 AND t_sp_cake.sp_delivery_date BETWEEN :fromDate AND :toDate", nativeQuery = true)
	int getSpCakeCount(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
