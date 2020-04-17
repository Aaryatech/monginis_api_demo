package com.ats.webapi.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.saledashboard.TotalAmount;

public interface TotalAmountRepo extends JpaRepository<TotalAmount, Integer> {

	@Query(value="SELECT\r\n" + 
			"    t1.id,\r\n" + 
			"    t1.total_sale,\r\n" + 
			"    t2.total_crn,\r\n" + 
			"    (t1.total_sale - t2.total_crn) AS net_total\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        1 AS id,\r\n" + 
			"        COALESCE(SUM(h.grand_total),0) AS total_sale\r\n" + 
			"    FROM\r\n" + 
			"        t_bill_header h\r\n" + 
			"    WHERE\r\n" + 
			"        h.bill_date BETWEEN :fromDate AND :toDate AND h.del_status = 0\r\n" + 
			") t1\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT 1 AS id,\r\n" + 
			"        COALESCE(SUM(h.crn_final_amt),\r\n" + 
			"        0) AS total_crn\r\n" + 
			"    FROM\r\n" + 
			"        t_credit_note_header h\r\n" + 
			"    WHERE\r\n" + 
			"        h.crn_date BETWEEN :fromDate AND :toDate\r\n" + 
			") t2\r\n" + 
			"ON\r\n" + 
			"    t1.id = t2.id",nativeQuery=true)
	public TotalAmount getSaleForDash( @Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
