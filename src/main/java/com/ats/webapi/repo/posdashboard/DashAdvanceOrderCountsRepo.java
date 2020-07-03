package com.ats.webapi.repo.posdashboard;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.posdashboard.DashAdvanceOrderCounts;

public interface DashAdvanceOrderCountsRepo extends JpaRepository<DashAdvanceOrderCounts, Integer>{
	
	
	
	
	@Query(value = "SELECT  UUID() as uid,t_adv_order_header.delivery_date as order_date,\n" + 
			"   SUM( t_adv_order_header.total) as total\n" + 
			"    \n" + 
			"FROM\n" + 
			"    t_adv_order_header\n" + 
			"WHERE\n" + 
			"    t_adv_order_header.delivery_date >= :fromDate  AND t_adv_order_header.del_status = 0 AND t_adv_order_header.fr_id = :frId AND t_adv_order_header.is_daily_mart =:dailyFlag\n" + 
			"GROUP BY   t_adv_order_header.delivery_date ORDER BY  t_adv_order_header.delivery_date ASC LIMIT 3", nativeQuery = true)
	List<DashAdvanceOrderCounts> getAdvDetail(@Param("fromDate") String fromDate,@Param("frId") int  frId,@Param("dailyFlag") int  dailyFlag);

	 
	
}
