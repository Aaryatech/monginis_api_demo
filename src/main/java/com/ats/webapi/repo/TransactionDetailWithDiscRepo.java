package com.ats.webapi.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.TransactionDetailWithDisc;

@Repository
public interface TransactionDetailWithDiscRepo extends JpaRepository<TransactionDetailWithDisc, Serializable> {

	@Query(value = "SELECT\r\n" + 
			"    t_transaction_detail.tr_id,\r\n" + 
			"    t_transaction_detail.sell_bill_no,\r\n" + 
			"    t_transaction_detail.transaction_date,\r\n" + 
			"    t_transaction_detail.pay_mode,\r\n" + 
			"    t_transaction_detail.cash_amt,\r\n" + 
			"    t_transaction_detail.card_amt,\r\n" + 
			"    t_transaction_detail.e_pay_amt,\r\n" + 
			"    t_transaction_detail.e_pay_type,\r\n" + 
			"    t_transaction_detail.disc_type,\r\n" + 
			"    t_transaction_detail.del_status,\r\n" + 
			"    t_sell_bill_header.payment_mode AS ex_int1,\r\n" + 
			"    t_transaction_detail.ex_int2,\r\n" + 
			"    CONCAT(t_sell_bill_header.invoice_no,' (',(SELECT cust_name from m_customer WHERE cust_id=t_sell_bill_header.cust_id),')') AS ex_var2,\r\n" + 
			"    t_transaction_detail.ex_var1,\r\n" + 
			"    t_sell_bill_header.grand_total AS ex_float1,\r\n" + 
			"    t_sell_bill_header.remaining_amt AS ex_float2,\r\n" + 
			"    t_sell_bill_header.discount_per AS disc_per,\r\n" + 
			"    t_sell_bill_header.discount_amt AS disc_amt, \r\n" + 
			"    t_transaction_detail.remark \r\n" + 
			"FROM\r\n" + 
			"    t_transaction_detail,\r\n" + 
			"    t_sell_bill_header\r\n" + 
			"WHERE\r\n" + 
			"    t_transaction_detail.del_status = 0 AND t_transaction_detail.sell_bill_no = t_sell_bill_header.sell_bill_no AND t_sell_bill_header.cust_id =:custId AND t_sell_bill_header.fr_id =:frId\r\n" + 
			"ORDER BY\r\n" + 
			"     t_transaction_detail.transaction_date\r\n" + 
			"DESC\r\n" + 
			"    ,\r\n" + 
			"    t_transaction_detail.tr_id\r\n" + 
			"DESC\r\n" + 
			"LIMIT 50", nativeQuery = true)
	List<TransactionDetailWithDisc> getCustBillsTransaction(@Param("custId") int custId, @Param("frId") int frId);

	
			
			@Query(value = "SELECT\r\n" + 
					"    t_transaction_detail.tr_id,\r\n" + 
					"    t_transaction_detail.sell_bill_no,\r\n" + 
					"    t_transaction_detail.transaction_date,\r\n" + 
					"    t_transaction_detail.pay_mode,\r\n" + 
					"    t_transaction_detail.cash_amt,\r\n" + 
					"    t_transaction_detail.card_amt,\r\n" + 
					"    t_transaction_detail.e_pay_amt,\r\n" + 
					"    t_transaction_detail.e_pay_type,\r\n" + 
					"    t_transaction_detail.disc_type,\r\n" + 
					"    t_transaction_detail.del_status,\r\n" + 
					"    t_sell_bill_header.payment_mode AS ex_int1,\r\n" + 
					"    t_transaction_detail.ex_int2,\r\n" + 
					"    CONCAT(t_sell_bill_header.invoice_no,' (',(SELECT cust_name from m_customer WHERE cust_id=t_sell_bill_header.cust_id),')') AS ex_var2,\r\n" + 
					"    t_transaction_detail.ex_var1,\r\n" + 
					"    t_sell_bill_header.grand_total AS ex_float1,\r\n" + 
					"    t_sell_bill_header.remaining_amt AS ex_float2,\r\n" + 
					"    t_sell_bill_header.discount_per AS disc_per,\r\n" + 
					"    t_sell_bill_header.discount_amt AS disc_amt, \r\n" + 
					"    t_transaction_detail.remark \r\n" + 
					"FROM\r\n" + 
					"    t_transaction_detail,\r\n" + 
					"    t_sell_bill_header\r\n" + 
					"WHERE\r\n" + 
					"    t_transaction_detail.del_status = 0 AND t_transaction_detail.sell_bill_no = t_sell_bill_header.sell_bill_no AND t_transaction_detail.transaction_date=:tdayDate AND t_sell_bill_header.fr_id =:frId\r\n" + 
					"ORDER BY\r\n" + 
					"     t_transaction_detail.transaction_date\r\n" + 
					"DESC\r\n" + 
					"    ,\r\n" + 
					"    t_transaction_detail.tr_id\r\n" + 
					"DESC\r\n" + 
					"", nativeQuery = true)
			List<TransactionDetailWithDisc> getCustBillsTransactionToday(@Param("frId") int frId, @Param("tdayDate") String tdayDate);
			
			
			
}
