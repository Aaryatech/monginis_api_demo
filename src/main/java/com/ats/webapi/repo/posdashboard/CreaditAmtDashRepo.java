package com.ats.webapi.repo.posdashboard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.posdashboard.CreaditAmtDash;
 
public interface CreaditAmtDashRepo extends JpaRepository<CreaditAmtDash, String> {
	
	
	@Query(value = "SELECT\n" + 
			"            UUID() AS uid,  SUM(tsh.remaining_amt) as credit_amt \n" + 
			"        FROM\n" + 
			"            t_sell_bill_header tsh\n" + 
			"        WHERE\n" + 
			"            tsh.bill_date BETWEEN :fromDate AND :toDate AND tsh.del_status = 0 AND tsh.status = 3 AND tsh.fr_id =:frId ", nativeQuery = true)
	CreaditAmtDash getDataFordash(@Param("fromDate") String fromDate, @Param("toDate") String toDate,@Param("frId") int  frId);

}
