package com.ats.webapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GetTotalAmt;

public interface GetTotalAmtRepo extends JpaRepository<GetTotalAmt, Integer> {

	@Query(value = "SELECT UUID() as id, COALESCE((SUM(advance_amt)),0) as total_amt FROM t_adv_order_header WHERE fr_id=:frId AND order_date BETWEEN :fromDate AND :toDate", nativeQuery = true)
	public GetTotalAmt getTotalAmount(@Param("frId") int frId, @Param("fromDate") String fromDate,
			@Param("toDate") String toDate);
	
	
	@Query(value = "SELECT UUID() as id, COALESCE((SUM(d.grand_total-(d.mrp_base_rate*d.qty))),0) as total_amt FROM t_sell_bill_header h,t_sell_bill_detail d WHERE h.sell_bill_no=d.sell_bill_no AND h.fr_id=:frId AND h.bill_date BETWEEN :fromDate AND :toDate ", nativeQuery = true)
	public GetTotalAmt getTotalProfit(@Param("frId") int frId, @Param("fromDate") String fromDate,
			@Param("toDate") String toDate);
	
	
	@Query(value = "SELECT UUID() as id, COALESCE(SUM((t.cash_amt)),0) as total_amt FROM t_transaction_detail t WHERE t.sell_bill_no IN(SELECT b.sell_bill_no FROM t_sell_bill_header b WHERE b.del_status=0 AND b.paid_amt=0 AND b.fr_id=:frId AND b.bill_date BETWEEN :fromDate AND :toDate) ", nativeQuery = true)
	public GetTotalAmt getTotalCreditAdvAmt(@Param("frId") int frId, @Param("fromDate") String fromDate,
			@Param("toDate") String toDate);
	
	@Query(value = "SELECT UUID() as id, COALESCE((SUM(c.grand_total)),0) as total_amt FROM t_credit_note_pos c, t_sell_bill_header h WHERE c.bill_no=h.sell_bill_no AND c.crn_date=:date AND c.del_status=0 AND h.fr_id=:frId ", nativeQuery = true)
	public GetTotalAmt getTotalPOSCreditNoteAmt(@Param("frId") int frId, @Param("date") String date);
	

}
