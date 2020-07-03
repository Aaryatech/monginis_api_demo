package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.SellBillHeader;

@Repository
public interface SellBillHeaderRepository extends JpaRepository<SellBillHeader, Long> {

	@SuppressWarnings("unchecked")
	public SellBillHeader save(SellBillHeader sellBillHeaderList);

	@Query(value = "select * from t_sell_bill_header where  t_sell_bill_header.cust_id=:custId AND t_sell_bill_header.status=3 AND t_sell_bill_header.del_status=0 AND t_sell_bill_header.fr_id=:frId ORDER BY  t_sell_bill_header.sell_bill_no DESC LIMIT 50", nativeQuery = true)
	List<SellBillHeader> getCustBillsPending50(@Param("custId") int custId, @Param("frId") int frId);

	@Query(value = "SELECT * FROM t_sell_bill_header WHERE t_sell_bill_header.del_status=0  and t_sell_bill_header.remaining_amt>1 and t_sell_bill_header.cust_id=:custId AND t_sell_bill_header.fr_id=:frId ORDER BY  t_sell_bill_header.sell_bill_no ASC", nativeQuery = true)
	List<SellBillHeader> getSellBillHeaderPending(@Param("custId") int custId, @Param("frId") int frId); // LIMIT 50

	@Query(value = "SELECT * FROM t_sell_bill_header WHERE t_sell_bill_header.del_status=0  and t_sell_bill_header.cust_id=:custId AND t_sell_bill_header.fr_id=:frId ORDER BY  t_sell_bill_header.invoice_no DESC LIMIT 50", nativeQuery = true)
	List<SellBillHeader> getSellBillHeader(@Param("custId") int custId, @Param("frId") int frId); // LIMIT 50

	@Query(value = "SELECT * FROM t_sell_bill_header WHERE t_sell_bill_header.del_status = 0 AND t_sell_bill_header.cust_id = :custId AND t_sell_bill_header.fr_id = :frId AND t_sell_bill_header.sell_bill_no NOT IN (SELECT t_credit_note_pos.bill_no from t_credit_note_pos WHERE t_credit_note_pos.del_status=0 ) ORDER BY t_sell_bill_header.invoice_no DESC LIMIT 50 ", nativeQuery = true)
	List<SellBillHeader> getSellBillHeaderNotInCreditNotePos(@Param("custId") int custId, @Param("frId") int frId); // LIMIT
																													// 50

	@Query(value = "select * from t_sell_bill_header where  t_sell_bill_header.cust_id=:custId AND t_sell_bill_header.status=3 AND t_sell_bill_header.del_status=0 AND t_sell_bill_header.fr_id=:frId ORDER BY  t_sell_bill_header.invoice_no ASC", nativeQuery = true)
	List<SellBillHeader> getCustBills(@Param("custId") int custId, @Param("frId") int frId);

	@Query(value = "select * from t_sell_bill_header where  t_sell_bill_header.fr_id=:frId AND t_sell_bill_header.bill_date=:todaysDate AND del_status=0 ORDER BY  t_sell_bill_header.invoice_no DESC", nativeQuery = true)
	List<SellBillHeader> getCustBillsTodays(@Param("todaysDate") String todaysDate, @Param("frId") int frId);

	@Query(value = "select * from t_sell_bill_header where  t_sell_bill_header.fr_id=:frId AND t_sell_bill_header.status=3 AND   t_sell_bill_header.remaining_amt>1 and t_sell_bill_header.bill_date=:todaysDate AND del_status=0 ORDER BY  t_sell_bill_header.invoice_no ASC", nativeQuery = true)
	List<SellBillHeader> getCustBillsTodaysPending(@Param("todaysDate") String todaysDate, @Param("frId") int frId);

	@Transactional
	@Modifying
	@Query(" UPDATE SellBillHeader SET remaining_amt=:pendingAmt,paid_amt=:paidAmt,status=:flag  WHERE sell_bill_no =:sellBillNo")
	int upDateBillAmt(@Param("pendingAmt") String pendingAmt, @Param("paidAmt") String paidAmt,
			@Param("sellBillNo") int sellBillNo, @Param("flag") int flag);

	@Transactional
	@Modifying
	@Query(" UPDATE SellBillHeader SET del_status=:status  WHERE sell_bill_no =:sellBillNo")
	int deleteBill(@Param("status") int status, @Param("sellBillNo") int sellBillNo);

	@Transactional
	@Modifying
	@Query(" UPDATE SellBillHeader SET del_status=:status,ext_var1=:remark  WHERE sell_bill_no =:sellBillNo")
	int deleteBillWithRemark(@Param("status") int status, @Param("sellBillNo") int sellBillNo,
			@Param("remark") String remark);

	@Query(value = "SELECT * FROM t_sell_bill_header WHERE t_sell_bill_header.del_status=1  and t_sell_bill_header.cust_id=:custId AND t_sell_bill_header.fr_id=:frId ORDER BY  t_sell_bill_header.sell_bill_no DESC ", nativeQuery = true)
	List<SellBillHeader> getDeletedSellBillHeader(@Param("custId") int custId, @Param("frId") int frId);

	@Query(value = "SELECT * FROM t_sell_bill_header WHERE t_sell_bill_header.del_status=1 AND t_sell_bill_header.bill_date=:date  AND t_sell_bill_header.fr_id=:frId ORDER BY  t_sell_bill_header.sell_bill_no DESC ", nativeQuery = true)
	List<SellBillHeader> getDeletedSellBillHeaderAllCust(@Param("frId") int frId, @Param("date") String date);

	@Query(value = "select * from t_sell_bill_header where  t_sell_bill_header.sell_bill_no=:sellBillNo", nativeQuery = true)
	SellBillHeader getBillHeaderById(@Param("sellBillNo") int sellBillNo);

	@Query(value = "SELECT * FROM t_sell_bill_header WHERE t_sell_bill_header.del_status=0  and t_sell_bill_header.cust_id=:custId AND t_sell_bill_header.fr_id=:frId ORDER BY  t_sell_bill_header.sell_bill_no DESC", nativeQuery = true)
	List<SellBillHeader> getCustSellBills(@Param("custId") int custId, @Param("frId") int frId);

	@Query(value = "SELECT * FROM t_sell_bill_header WHERE fr_id=:frId  ORDER BY sell_bill_no DESC LIMIT 1", nativeQuery = true)
	SellBillHeader getLastBillHeaderByFrId(@Param("frId") int frId);

	@Transactional
	@Modifying
	@Query(" UPDATE SellBillHeader SET ext_float1=(taxable_amt+total_tax-payable_amt)  WHERE sell_bill_no =:sellBillNo")
	int updateRoundOff(@Param("sellBillNo") int sellBillNo);

}
