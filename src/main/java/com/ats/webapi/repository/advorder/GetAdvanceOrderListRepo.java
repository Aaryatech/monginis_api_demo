package com.ats.webapi.repository.advorder;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.ats.webapi.model.advorder.GetAdvanceOrderList;
 
public interface GetAdvanceOrderListRepo extends JpaRepository<GetAdvanceOrderList, Integer> {
	
	
	
	@Query(value=" SELECT\n" + 
			"    t_adv_order_header.adv_header_id,\n" + 
			"    t_adv_order_header.fr_id,\n" + 
			"    t_adv_order_header.cust_id,\n" + 
			"    t_adv_order_header.is_daily_mart,\n" + 
			"    t_adv_order_header.order_date,\n" + 
			"    t_adv_order_header.prod_date,\n" + 
			"    t_adv_order_header.delivery_date,\n" + 
			"    t_adv_order_header.advance_amt,\n" + 
			"    t_adv_order_header.remaining_amt,\n" + 
			"    t_adv_order_header.total,\n" + 
			"    t_adv_order_header.ex_var1,t_adv_order_header.ex_var2, t_adv_order_header.is_bill_generated,\n" + 
			"    m_customer.cust_name,\n" + 
			"    m_franchisee.fr_name,\n" + 
			"    m_customer.phone_number,\n" + 
			"    t_adv_order_header.disc_amt,t_adv_order_header.del_status\n" + 
			"FROM\n" + 
			"    t_adv_order_header,\n" + 
			"    m_customer,\n" + 
			"    m_franchisee\n" + 
			"WHERE\n" + 
			"    t_adv_order_header.prod_date = :prodDate AND t_adv_order_header.cust_id = m_customer.cust_id AND m_franchisee.fr_id = t_adv_order_header.fr_id AND t_adv_order_header.del_status = 0 ORDER BY  t_adv_order_header.adv_header_id DESC" + 
			"",nativeQuery=true)

	List<GetAdvanceOrderList> getAdvanceOrderList(@Param("prodDate") String prodDate);
	
	@Query(value=" SELECT\n" + 
			"    t_adv_order_header.adv_header_id,\n" + 
			"    t_adv_order_header.fr_id,\n" + 
			"    t_adv_order_header.cust_id,\n" + 
			"    t_adv_order_header.is_daily_mart,\n" + 
			"    t_adv_order_header.order_date,\n" + 
			"    t_adv_order_header.prod_date,\n" + 
			"    t_adv_order_header.delivery_date,\n" + 
			"    t_adv_order_header.advance_amt,\n" + 
			"    t_adv_order_header.remaining_amt,\n" + 
			"    t_adv_order_header.total,\n" + 
			"    t_adv_order_header.ex_var1,t_adv_order_header.ex_var2, t_adv_order_header.is_bill_generated,\n" + 
			"    m_customer.cust_name,\n" + 
			"    m_franchisee.fr_name,\n" + 
			"    m_customer.phone_number,\n" + 
			"    t_adv_order_header.disc_amt,t_adv_order_header.del_status\n" + 
			"FROM\n" + 
			"    t_adv_order_header,\n" + 
			"    m_customer,\n" + 
			"    m_franchisee\n" + 
			"WHERE\n" + 
			"    t_adv_order_header.is_bill_generated = :isBilled AND t_adv_order_header.cust_id = m_customer.cust_id AND m_franchisee.fr_id = t_adv_order_header.fr_id AND t_adv_order_header.del_status = 0 ORDER BY  t_adv_order_header.adv_header_id DESC" + 
			"",nativeQuery=true)

	List<GetAdvanceOrderList> getAdvanceOrderBillNotGen(@Param("isBilled") int isBilled);
	
	@Query(value=" SELECT\n" + 
			"    t_adv_order_header.adv_header_id,\n" + 
			"    t_adv_order_header.fr_id,\n" + 
			"    t_adv_order_header.cust_id,\n" + 
			"    t_adv_order_header.is_daily_mart,\n" + 
			"    t_adv_order_header.order_date,\n" + 
			"    t_adv_order_header.prod_date,\n" + 
			"    t_adv_order_header.delivery_date,\n" + 
			"    t_adv_order_header.advance_amt,\n" + 
			"    t_adv_order_header.remaining_amt,\n" + 
			"    t_adv_order_header.total,\n" + 
			"    t_adv_order_header.ex_var1,t_adv_order_header.ex_var2, t_adv_order_header.is_bill_generated,\n" + 
			"    m_customer.cust_name,\n" + 
			"    m_franchisee.fr_name,\n" + 
			"    m_customer.phone_number,\n" + 
			"    t_adv_order_header.disc_amt,t_adv_order_header.del_status\n" + 
			"FROM\n" + 
			"    t_adv_order_header,\n" + 
			"    m_customer,\n" + 
			"    m_franchisee\n" + 
			"WHERE\n" + 
			"    t_adv_order_header.delivery_date BETWEEN  :fromDate AND :toDate AND t_adv_order_header.cust_id = m_customer.cust_id AND m_franchisee.fr_id = t_adv_order_header.fr_id AND t_adv_order_header.del_status = 0 ORDER BY  t_adv_order_header.adv_header_id DESC" + 
			"",nativeQuery=true)

	List<GetAdvanceOrderList> getAdvOrderListfdTdAllFr(@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	
	@Query(value=" SELECT\n" + 
			"    t_adv_order_header.adv_header_id,\n" + 
			"    t_adv_order_header.fr_id,\n" + 
			"    t_adv_order_header.cust_id,\n" + 
			"    t_adv_order_header.is_daily_mart,\n" + 
			"    t_adv_order_header.order_date,\n" + 
			"    t_adv_order_header.prod_date,\n" + 
			"    t_adv_order_header.delivery_date,\n" + 
			"    t_adv_order_header.advance_amt,\n" + 
			"    t_adv_order_header.remaining_amt,\n" + 
			"    t_adv_order_header.total,\n" + 
			"    t_adv_order_header.ex_var1,t_adv_order_header.ex_var2, t_adv_order_header.is_bill_generated,\n" + 
			"    m_customer.cust_name,\n" + 
			"    m_franchisee.fr_name,\n" + 
			"    m_customer.phone_number,\n" + 
			"    t_adv_order_header.disc_amt,t_adv_order_header.del_status\n" + 
			"FROM\n" + 
			"    t_adv_order_header,\n" + 
			"    m_customer,\n" + 
			"    m_franchisee\n" + 
			"WHERE\n" + 
			"  m_franchisee.fr_id=:frId AND  t_adv_order_header.delivery_date BETWEEN  :fromDate AND :toDate AND t_adv_order_header.cust_id = m_customer.cust_id AND m_franchisee.fr_id = t_adv_order_header.fr_id AND t_adv_order_header.del_status = 0 ORDER BY  t_adv_order_header.adv_header_id DESC" + 
			"",nativeQuery=true)

	List<GetAdvanceOrderList> getAdvOrderListfdTdSpecFr(@Param("fromDate") String fromDate,@Param("toDate") String toDate,@Param("frId") int frId);

	
	@Query(value=" SELECT\n" + 
			"    t_adv_order_header.adv_header_id,\n" + 
			"    t_adv_order_header.fr_id,\n" + 
			"    t_adv_order_header.cust_id,\n" + 
			"    t_adv_order_header.is_daily_mart,\n" + 
			"    t_adv_order_header.order_date,\n" + 
			"    t_adv_order_header.prod_date,\n" + 
			"    t_adv_order_header.delivery_date,\n" + 
			"    t_adv_order_header.advance_amt,\n" + 
			"    t_adv_order_header.remaining_amt,\n" + 
			"    t_adv_order_header.total,\n" + 
			"    t_adv_order_header.ex_var1,t_adv_order_header.ex_var2, t_adv_order_header.is_bill_generated,\n" + 
			"    m_customer.cust_name,\n" + 
			"    m_franchisee.fr_name,\n" + 
			"    m_customer.phone_number,\n" + 
			"    t_adv_order_header.disc_amt,t_adv_order_header.del_status\n" + 
			"FROM\n" + 
			"    t_adv_order_header,\n" + 
			"    m_customer,\n" + 
			"    m_franchisee\n" + 
			"WHERE\n" + 
			"  m_franchisee.fr_id=:frId AND t_adv_order_header.is_bill_generated=0 AND  t_adv_order_header.delivery_date=:delDate AND t_adv_order_header.cust_id = m_customer.cust_id AND m_franchisee.fr_id = t_adv_order_header.fr_id AND t_adv_order_header.del_status = 0 ORDER BY  t_adv_order_header.adv_header_id DESC" + 
			"",nativeQuery=true)
	List<GetAdvanceOrderList> getAdvOrderHeadList(@Param("delDate") String delDate, @Param("frId") int frId);
	
}
