package com.ats.webapi.repository.advorder;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.advorder.AdvanceOrderHeader;

public interface AdvanceOrderHeaderRepo extends JpaRepository<AdvanceOrderHeader, Integer> {

	List<AdvanceOrderHeader> findByDeliveryDateAndFrIdAndDelStatusOrderByOrderDateDesc(Date deliveryDate, int frId, int i);

	 
	List<AdvanceOrderHeader> findByFrIdAndDelStatusAndIsSellBillGeneratedOrderByOrderDateDesc(int frId, int i,int j);

	
	@Transactional
	@Modifying
	@Query(value="UPDATE t_adv_order_header SET is_sell_bill_generated=1  WHERE adv_header_id=:advHeadId",nativeQuery=true)
	int updateIsSellBillGen(@Param("advHeadId") int advHeadId);

	@Transactional
	@Modifying
	@Query(value="UPDATE t_adv_order_header SET is_bill_generated=2  WHERE adv_header_id=:advHeadId",nativeQuery=true)
	int updateIsBillGen(@Param("advHeadId") int advHeadId);//Sachin 06-01-2020


	List<AdvanceOrderHeader> findByCustIdAndIsSellBillGeneratedAndDelStatus(int custId, int i, int j);


	AdvanceOrderHeader findByAdvHeaderIdAndDelStatus(int headId, int i);

	@Transactional
	@Modifying
	@Query(value="UPDATE t_adv_order_header SET del_status=1  WHERE adv_header_id=:ordHeaderId",nativeQuery=true)
	int deleteAdvOrder(@Param("ordHeaderId") int ordHeaderId);
	
	
	@Query(value="SELECT\n" + 
			"    adv_header_id,\n" + 
			"    fr_id,\n" + 
			"    cust_id,\n" + 
			"    is_daily_mart,\n" + 
			"    order_date,\n" + 
			"    prod_date,\n" + 
			"    delivery_date,\n" + 
			"    disc_amt,\n" + 
			"    advance_amt,\n" + 
			"    remaining_amt,\n" + 
			"    total AS total,\n" + 
			"    is_bill_generated,\n" + 
			"    is_sell_bill_generated,\n" + 
			"    del_status,\n" + 
			"    ex_int1,\n" + 
			"    ex_int2,\n" + 
			"    ex_float1,\n" + 
			"    ex_float2,\n" + 
			"    ex_var1,\n" + 
			"    ex_var2\n" + 
			"FROM\n" + 
			"    t_adv_order_header\n" + 
			"WHERE\n" + 
			"    fr_id =:frId AND del_status =:delStatus AND is_sell_bill_generated =:isSellBillGen\n" + 
			"ORDER BY\n" + 
			"    order_date\n" + 
			"DESC\n" + 
			"    ",nativeQuery=true)
	List<AdvanceOrderHeader> getAdvOrderHeaderForDispFr(@Param("frId") int frId,@Param("delStatus") int delStatus,@Param("isSellBillGen") int isSellBillGen);
	
	
	@Query(value="SELECT\n" + 
			"    adv_header_id,\n" + 
			"    fr_id,\n" + 
			"    cust_id,\n" + 
			"    is_daily_mart,\n" + 
			"    order_date,\n" + 
			"    prod_date,\n" + 
			"    delivery_date,\n" + 
			"    disc_amt,\n" + 
			"    advance_amt,\n" + 
			"    remaining_amt,\n" + 
			"    total AS total,\n" + 
			"    is_bill_generated,\n" + 
			"    is_sell_bill_generated,\n" + 
			"    del_status,\n" + 
			"    ex_int1,\n" + 
			"    ex_int2,\n" + 
			"    ex_float1,\n" + 
			"    ex_float2,\n" + 
			"    ex_var1,\n" + 
			"    ex_var2\n" + 
			"FROM\n" + 
			"    t_adv_order_header\n" + 
			"WHERE\n" + 
			"    fr_id =:frId AND del_status =:delStatus AND delivery_date =:delDate\n" + 
			"ORDER BY\n" + 
			"    order_date\n" + 
			"DESC\n" + 
			"    ",nativeQuery=true)
	List<AdvanceOrderHeader> getAdvOrderHeaderByDelDateForDispFr(@Param("delDate") String delDate,@Param("frId") int frId, @Param("delStatus") int delStatus);
	
	
} 
