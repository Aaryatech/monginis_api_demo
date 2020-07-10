package com.ats.webapi.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.SellBillHeader;
import com.ats.webapi.model.TransactionDetail;

@Repository
public interface TransactionDetailRepository extends JpaRepository<TransactionDetail, Serializable> {

	@Query(value = "SELECT\n" + "    t_transaction_detail.tr_id,\n" + "    t_transaction_detail.sell_bill_no,\n"
			+ "    t_transaction_detail.transaction_date,\n" + "    t_transaction_detail.pay_mode,\n"
			+ "    t_transaction_detail.cash_amt,\n" + "    t_transaction_detail.card_amt,\n"
			+ "    t_transaction_detail.e_pay_amt,\n"
			+ "    t_transaction_detail.e_pay_type,t_transaction_detail.disc_type,t_transaction_detail.del_status,t_sell_bill_header.payment_mode as ex_int1,t_transaction_detail.ex_int2,t_sell_bill_header.invoice_no as ex_var2,\n"
			+ "    t_transaction_detail.ex_var1,t_sell_bill_header.grand_total as ex_float1,t_sell_bill_header.remaining_amt  as ex_float2, t_transaction_detail.remark \n"
			+ "FROM\n" + "    t_transaction_detail,\n" + "    t_sell_bill_header\n" + "WHERE\n"
			+ "    t_transaction_detail.del_status = 0 AND t_transaction_detail.sell_bill_no = t_sell_bill_header.sell_bill_no AND t_sell_bill_header.cust_id =:custId AND t_sell_bill_header.fr_id =:frId\n"
			+ "ORDER BY\n" + "    t_sell_bill_header.sell_bill_no DESC,t_transaction_detail.tr_id   " + "DESC\n"
			+ "LIMIT 50", nativeQuery = true)
	List<TransactionDetail> getCustBillsTransaction(@Param("custId") int custId, @Param("frId") int frId);

	@Query(value = "    SELECT\n" + "        t_transaction_detail.tr_id,\n"
			+ "        t_transaction_detail.sell_bill_no,\n"
			+ "        t_sell_bill_header.bill_date as transaction_date,\n" + "        t_transaction_detail.pay_mode,\n"
			+ "        t_transaction_detail.cash_amt,\n" + "        t_transaction_detail.card_amt,\n"
			+ "        t_transaction_detail.e_pay_amt,\n" + "        t_transaction_detail.e_pay_type,\n"
			+ "        t_transaction_detail.disc_type,\n" + "        t_transaction_detail.del_status,\n"
			+ "        t_sell_bill_header.payment_mode as ex_int1,\n" + "        t_transaction_detail.ex_int2,\n"
			+ "        concat(t_sell_bill_header.invoice_no,'--(',t_sell_bill_header.user_name,')') as ex_var2,\n"
			+ "        t_transaction_detail.ex_var1,\n" + "          t_sell_bill_header.grand_total as ex_float1,\n"
			+ "        t_sell_bill_header.remaining_amt  as ex_float2, t_transaction_detail.remark \n" + "    FROM\n"
			+ "        t_transaction_detail,\n" + "        t_sell_bill_header \n" + "    WHERE\n"
			+ "        t_transaction_detail.del_status = 0  \n"
			+ "        AND t_transaction_detail.transaction_date=:tdayDate "
			+ "        AND t_transaction_detail.sell_bill_no = t_sell_bill_header.sell_bill_no  \n"
			+ "        AND t_sell_bill_header.fr_id =:frId      \n" + "\n" + "    ORDER BY\n"
			+ "        t_sell_bill_header.sell_bill_no DESC,\n"
			+ "        t_transaction_detail.tr_id DESC  LIMIT 50", nativeQuery = true)
	List<TransactionDetail> getCustBillsTransactionToday(@Param("frId") int frId, @Param("tdayDate") String tdayDate);

	@Transactional
	@Modifying
	@Query(" DELETE FROM TransactionDetail WHERE  sellBillNo=:sellBillNo")
	int deleteTransactionDetails(@Param("sellBillNo") int sellBillNo);

	@Transactional
	@Modifying
	@Query(" DELETE FROM TransactionDetail WHERE  sellBillNo=:sellBillNo AND exInt2=:advAmtStatus")
	int deleteTransactionDetailsByIsAdvAmt(@Param("sellBillNo") int sellBillNo,
			@Param("advAmtStatus") int advAmtStatus);

	@Query(value = "    SELECT  \n" + "			        t_transaction_detail.tr_id,  \n"
			+ "			        t_transaction_detail.sell_bill_no,  \n"
			+ "			        t_sell_bill_header.bill_date as transaction_date,  \n"
			+ "			        t_transaction_detail.pay_mode,  \n"
			+ "			        t_transaction_detail.cash_amt,  \n"
			+ "			        t_transaction_detail.card_amt,  \n"
			+ "			        t_transaction_detail.e_pay_amt,  \n"
			+ "			        t_transaction_detail.e_pay_type,  \n"
			+ "			        t_transaction_detail.disc_type,  \n"
			+ "			        t_transaction_detail.del_status,  \n"
			+ "			        t_sell_bill_header.payment_mode as ex_int1,  \n"
			+ "			        t_transaction_detail.ex_int2,  \n"
			+ "			        concat(t_sell_bill_header.invoice_no,'--(',t_sell_bill_header.user_name,')') as ex_var2,  \n"
			+ "			        t_transaction_detail.ex_var1,  \n"
			+ "			          t_sell_bill_header.grand_total as ex_float1,  \n"
			+ "			        t_sell_bill_header.remaining_amt  as ex_float2, t_transaction_detail.remark   \n" + "			    FROM  \n"
			+ "			        t_transaction_detail,  \n" + "			        t_sell_bill_header   \n"
			+ "			    WHERE  \n" + "			        t_transaction_detail.del_status = 0    \n"
			+ "			        AND t_transaction_detail.sell_bill_no = t_sell_bill_header.sell_bill_no    \n"
			+ "			        AND t_sell_bill_header.sell_bill_no =:sellBillNo AND t_transaction_detail.ex_int2=1       \n"
			+ "			  \n" + "			", nativeQuery = true)
	TransactionDetail getAdvAmtTransaction(@Param("sellBillNo") int sellBillNo);
	
	@Query(value = "    SELECT  \n" + "			        t_transaction_detail.tr_id,  \n"
			+ "			        t_transaction_detail.sell_bill_no,  \n"
			+ "			        t_sell_bill_header.bill_date as transaction_date,  \n"
			+ "			        t_transaction_detail.pay_mode,  \n"
			+ "			        t_transaction_detail.cash_amt,  \n"
			+ "			        t_transaction_detail.card_amt,  \n"
			+ "			        t_transaction_detail.e_pay_amt,  \n"
			+ "			        t_transaction_detail.e_pay_type,  \n"
			+ "			        t_transaction_detail.disc_type,  \n"
			+ "			        t_transaction_detail.del_status,  \n"
			+ "			        t_sell_bill_header.payment_mode as ex_int1,  \n"
			+ "			        t_transaction_detail.ex_int2,  \n"
			+ "			        concat(t_sell_bill_header.invoice_no,'--(',t_sell_bill_header.user_name,')') as ex_var2,  \n"
			+ "			        t_transaction_detail.ex_var1,  \n"
			+ "			          t_sell_bill_header.grand_total as ex_float1,  \n"
			+ "			        t_sell_bill_header.remaining_amt  as ex_float2, t_transaction_detail.remark   \n" + "			    FROM  \n"
			+ "			        t_transaction_detail,  \n" + "			        t_sell_bill_header   \n"
			+ "			    WHERE  \n" + "			        t_transaction_detail.del_status = 0    \n"
			+ "			        AND t_transaction_detail.sell_bill_no = t_sell_bill_header.sell_bill_no    \n"
			+ "			        AND t_sell_bill_header.sell_bill_no =:sellBillNo       \n"
			+ "			  \n" + "			", nativeQuery = true)
	TransactionDetail getTransactionByBillId(@Param("sellBillNo") int sellBillNo);

}
