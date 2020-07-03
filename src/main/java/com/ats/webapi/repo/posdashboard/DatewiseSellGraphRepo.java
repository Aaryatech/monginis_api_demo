package com.ats.webapi.repo.posdashboard;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

 import com.ats.webapi.model.posdashboard.DatewiseSellGraph;

public interface DatewiseSellGraphRepo  extends JpaRepository<DatewiseSellGraph, String>{

	
	@Query(value = "SELECT   UUID() AS uid,\n" + 
			"    t_sell_bill_header.bill_date as sell_date,\n" + 
			"    SUM(t_sell_bill_header.grand_total) AS sell_amount\n" + 
			"FROM\n" + 
			"    t_sell_bill_header\n" + 
			"WHERE\n" + 
			"    t_sell_bill_header.bill_date BETWEEN :fromDate AND :toDate AND t_sell_bill_header.fr_id =:frId AND t_sell_bill_header.del_status = 0\n" + 
			"GROUP BY\n" + 
			"    t_sell_bill_header.bill_date", nativeQuery = true)
	List<DatewiseSellGraph> getD1ataFordashBarChart(@Param("fromDate") String fromDate, @Param("toDate") String toDate,@Param("frId") int  frId);
}
