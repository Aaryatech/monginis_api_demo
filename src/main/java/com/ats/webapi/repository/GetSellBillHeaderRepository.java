package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GetSellBillHeader;

public interface GetSellBillHeaderRepository extends JpaRepository<GetSellBillHeader,Integer>{

	@Query(value =  "SELECT UUID() as id,t_sell_bill_header.sell_bill_no,t_sell_bill_header.bill_type, t_sell_bill_header.invoice_no,"
			+" t_sell_bill_header.bill_date, t_sell_bill_header.taxable_amt, t_sell_bill_header.total_tax,"
			+" t_sell_bill_header.grand_total, t_sell_bill_header.paid_amt, t_sell_bill_header.remaining_amt,"
			+" t_sell_bill_header.payment_mode, t_sell_bill_header.discount_per, t_sell_bill_header.payable_amt, m_franchisee.fr_name"
			+" FROM t_sell_bill_header, m_franchisee WHERE m_franchisee.fr_id=t_sell_bill_header.fr_id AND t_sell_bill_header.fr_id IN(:frId)"
			+" AND t_sell_bill_header.bill_date BETWEEN :fromDate AND :toDate "
			+ ""
			+ ""
			+ "UNION ALL "
			+ ""
			+ " SELECT UUID() as id,t_sp_cake.sp_order_no  as sell_bill_no," + 
			"       'S' as bill_type," + 
			"        t_sp_cake.sp_book_for_mob_no  as invoice_no," + 
			"        " + 
			"        t_sp_cake.sp_delivery_date as bill_date," + 
			"        (t_sp_cake.sp_grand_total-(t_sp_cake.tax_1_amt+t_sp_cake.tax_2_amt)) AS taxable_amt," + 
			"        (t_sp_cake.tax_1_amt+t_sp_cake.tax_2_amt) as total_tax," + 
			"        t_sp_cake.sp_grand_total as grand_total," + 
			"        t_sp_cake.sp_grand_total as paid_amt," + 
			"        0 as remaining_amt," + 
			"        1 as payment_mode," + 
			"       t_sp_cake.disc as discount_per," + 
			"        t_sp_cake.sp_grand_total as payable_amt," + 
			"        " + 
			"        m_franchisee.fr_name" + 
			"        " + 
			"        from t_sp_cake,m_franchisee WHERE t_sp_cake.sp_delivery_date BETWEEN :fromDate AND :toDate " + 
			"         AND t_sp_cake.fr_id IN(:frId) AND t_sp_cake.fr_id=m_franchisee.fr_id and t_sp_cake.sp_book_for_mob_no != '0' ", nativeQuery = true)
	
	List<GetSellBillHeader> getFrSellBillHeader(@Param("fromDate") String fromDate ,@Param("toDate") String toDate ,@Param("frId") List<String> frId);
	
}
