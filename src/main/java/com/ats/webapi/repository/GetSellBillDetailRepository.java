package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GetSellBillDetail;

public interface GetSellBillDetailRepository extends JpaRepository<GetSellBillDetail,Integer>{

	@Query(value =  "SELECT t_sell_bill_detail.sell_bill_detail_no, t_sell_bill_detail.cgst_per, t_sell_bill_detail.mrp_base_rate, t_sell_bill_detail.sgst_per,"
			+" t_sell_bill_detail.sell_bill_no,"
			+" t_sell_bill_detail.mrp, t_sell_bill_detail.taxable_amt, t_sell_bill_detail.total_tax,"
			+" t_sell_bill_detail.grand_total, t_sell_bill_detail.qty,"
			+" m_item.item_name FROM m_item,t_sell_bill_detail WHERE t_sell_bill_detail.item_id=m_item.id And"
			+" t_sell_bill_detail.sell_bill_no=:sellBillNo", nativeQuery = true)
	
	List<GetSellBillDetail> getFrSellBillDetail(@Param("sellBillNo") int sellBillNo);
	

}
