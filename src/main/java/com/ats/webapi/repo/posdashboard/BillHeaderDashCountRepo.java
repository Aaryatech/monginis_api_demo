package com.ats.webapi.repo.posdashboard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.posdashboard.BillHeaderDashCount;
 
public interface BillHeaderDashCountRepo extends JpaRepository<BillHeaderDashCount, String>{

	
	@Query(value = "SELECT\n" + 
			"    UUID() AS uid, SUM(m_expense.ch_amt) AS ch_amt,\n" + 
			"    '0' AS purchae_amt\n" + 
			"FROM\n" + 
			"    m_expense\n" + 
			"WHERE\n" + 
			"    m_expense.del_status = 0 AND m_expense.fr_id =:frId AND m_expense.exp_date BETWEEN :fromDate AND :toDate ", nativeQuery = true)
	BillHeaderDashCount getD1ataFordash2Ch(@Param("fromDate") String fromDate, @Param("toDate") String toDate,@Param("frId") int  frId);
	
	
	@Query(value = "SELECT\n" + 
			"    UUID() AS uid, '0' AS ch_amt, SUM(t_bill_header.grand_total) AS purchae_amt\n" + 
			"FROM\n" + 
			"    t_bill_header " + 
			"WHERE\n" + 
			"    t_bill_header.del_status = 0 AND t_bill_header.fr_id =:frId AND t_bill_header.bill_date BETWEEN :fromDate AND :toDate ", nativeQuery = true)
	BillHeaderDashCount getD1ataFordash2pur(@Param("fromDate") String fromDate, @Param("toDate") String toDate,@Param("frId") int  frId);
}
