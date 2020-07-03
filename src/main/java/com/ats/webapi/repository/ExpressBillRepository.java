package com.ats.webapi.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.SellBillDataCommon;
import com.ats.webapi.model.SellBillDetail;
import com.ats.webapi.model.SellBillHeader;

@Repository
public interface ExpressBillRepository extends JpaRepository<SellBillHeader, Integer>{

	
	List<SellBillHeader> findByBillTypeAndGrandTotalAndFrId(char billType,float grandTotal,int frId);

	
	//function to get sellBillHeader to close a day
	SellBillHeader getBysellBillNo(int sellBillNo);
	
	
	//function to delete Sell Bill Header if its Details are empty 
	int deleteBySellBillNo(int sellBillNo);


	SellBillHeader findBySellBillNo(int billNo);
	
	@Query(value="SELECT\n" + 
			"    sell_bill_no,\n" + 
			"    invoice_no,bill_date,\n" + 
			"    timestamp,\n" + 
			"    bill_type,\n" + 
			"    fr_id,\n" + 
			"    fr_code,\n" + 
			"    SUM(taxable_amt) AS taxable_amt,\n" + 
			"    SUM(grand_total) AS grand_total,\n" + 
			"    disc_type,\n" + 
			"    discount_per,\n" + 
			"    SUM(discount_amt) AS discount_amt,\n" + 
			"    SUM(payable_amt) AS payable_amt,\n" + 
			"    total_tax,\n "+
			"    payment_mode,\n "+
			"	 SUM(disc_amt_item) AS disc_amt_item,\n" + 
			"    SUM(paid_amt) AS paid_amt,\n" + 
			"    SUM(remaining_amt) AS remaining_amt,\n" + 
			"    SUM(advance_amt) AS advance_amt,\n" + 
			"    cust_id,\n" + 
			"    user_name,\n" + 
			"    user_gst_no,\n" + 
			"    user_phone,\n" + 
			"    is_dairy_mart_bill,\n" + 
			"    coupon_no,\n" + 
			"    cust_loyalty_pt_rate,\n" + 
			"    cust_loyalty_pt,\n" + 
			"    status,\n" + 
			"    del_status,\n" + 
			"    ext_int1,\n" + 
			"    ext_int2,\n" + 
			"    ext_int3,\n" + 
			"    ext_int4,\n" + 
			"    ext_float1,\n" + 
			"    ext_float2,\n" + 
			"    ext_float3,\n" + 
			"    ext_float4,\n" + 
			"    ext_var1,\n" + 
			"    ext_var2,\n" + 
			"    ext_var3,\n" + 
			"    ext_var4\n" + 
			"FROM\n" + 
			"    t_sell_bill_header\n" + 
			"WHERE\n" + 
			"    TIMESTAMP BETWEEN :fromTime AND :toTime AND \n" + 
			"    fr_id = :frId AND \n" + 
			"    del_status = 0\n" + 
			"    GROUP BY fr_id",nativeQuery=true)
	SellBillHeader getPettyCashSellingAmt(@Param("fromTime") String fromTime, @Param("toTime") String toTime, @Param("frId") int frId);


	//int deleteInBatch(int sellBillNo);

}
