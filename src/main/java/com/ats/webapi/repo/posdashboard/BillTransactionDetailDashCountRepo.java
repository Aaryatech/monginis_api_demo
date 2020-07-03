package com.ats.webapi.repo.posdashboard;

 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.posdashboard.BillTransactionDetailDashCount;
 
public interface BillTransactionDetailDashCountRepo  extends JpaRepository<BillTransactionDetailDashCount,String>{
	
	@Query(value = "SELECT\n" + 
			"   UUID() AS uid, SUM(t_transaction_detail.cash_amt) AS cash_amt,\n" + 
			"    SUM(t_transaction_detail.card_amt) AS card_amt,\n" + 
			"    SUM(t_transaction_detail.e_pay_amt) AS e_pay_amt\n" + 
			"FROM\n" + 
			"    t_transaction_detail,\n" + 
			"    t_sell_bill_header\n" + 
			"WHERE\n" + 
			"    t_transaction_detail.transaction_date BETWEEN :fromDate AND :toDate AND t_transaction_detail.sell_bill_no = t_sell_bill_header.sell_bill_no AND t_sell_bill_header.fr_id =:frId AND t_transaction_detail.del_status = 0", nativeQuery = true)
	BillTransactionDetailDashCount getD1ataFordash(@Param("fromDate") String fromDate, @Param("toDate") String toDate,@Param("frId") int  frId);
	
	

}
