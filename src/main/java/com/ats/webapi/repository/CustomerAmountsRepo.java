package com.ats.webapi.repository;

 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.CustomerAmounts;
 
public interface CustomerAmountsRepo  extends JpaRepository<CustomerAmounts, Integer>{
	
	/*
	 * @Query(
	 * value="SELECT 0 as cust_id ,SUM(t_sell_bill_header.remaining_amt) as creadit_amt,'NA' as advance_amt  FROM t_sell_bill_header WHERE t_sell_bill_header.cust_id=:custId AND t_sell_bill_header.status=3 AND t_sell_bill_header.del_status=0 AND t_sell_bill_header.fr_id=:frId  \n"
	 * + "",nativeQuery=true) CustomerAmounts findPendingAmt(@Param("custId") int
	 * custId,@Param("frId") int frId);
	 */
	/*
	 * @Query(value="SELECT\n" + "    0 AS cust_id,\n" + "    SUM(\n" +
	 * "        t_sell_bill_header.remaining_amt\n" + "    ) AS creadit_amt,\n" +
	 * "    SUM(t_adv_order_header.total) AS advance_amt\n" + "FROM\n" +
	 * "    t_sell_bill_header,\n" + "    t_adv_order_header,m_customer\n" +
	 * "WHERE\n" +
	 * "    t_sell_bill_header.cust_id = m_customer.cust_id AND t_adv_order_header.cust_id = m_customer.cust_id AND t_sell_bill_header.status = 3 AND t_sell_bill_header.del_status = 0 AND t_sell_bill_header.fr_id =:frId AND t_adv_order_header.del_status = 0 AND t_adv_order_header.is_sell_bill_generated = 0 AND t_adv_order_header.fr_id =:frId AND m_customer.cust_id=:custId"
	 * + "",nativeQuery=true) CustomerAmounts findAadvAmt(@Param("custId") int
	 * custId,@Param("frId") int frId);
	 */
	
	
	
	@Query(value="SELECT 0 as cust_id ,SUM(t_sell_bill_header.remaining_amt) as creadit_amt,'NA' as advance_amt  FROM t_sell_bill_header WHERE t_sell_bill_header.cust_id=:custId AND t_sell_bill_header.status=3 AND t_sell_bill_header.del_status=0 AND t_sell_bill_header.fr_id=:frId  \n" +
			"",nativeQuery=true)
			CustomerAmounts findPendingAmt(@Param("custId") int custId,@Param("frId") int frId);

			@Query(value="SELECT 0 as cust_id,SUM(t_adv_order_header.total) as advance_amt,'NA' as creadit_amt FROM t_adv_order_header WHERE t_adv_order_header.cust_id=:custId AND t_adv_order_header.del_status=0 AND t_adv_order_header.is_sell_bill_generated=0 AND t_adv_order_header.fr_id=:frId" +
			"",nativeQuery=true)
			CustomerAmounts findAadvAmt(@Param("custId") int custId,@Param("frId") int frId);

}
