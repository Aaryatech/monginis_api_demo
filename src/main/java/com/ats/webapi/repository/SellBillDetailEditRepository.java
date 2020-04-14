package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.SellBillDetail;
import com.ats.webapi.model.SellBillDetailEdit;

@Repository
public interface SellBillDetailEditRepository extends JpaRepository<SellBillDetailEdit, Integer>{

	
    @Query(value="Select s.sell_bill_detail_no,s.sell_bill_no,s.cat_id,s.item_id,i.item_name,\n" + 
    		"	    		s.mrp,s.qty,s.mrp_base_rate,s.taxable_amt,s.sgst_per,s.sgst_rs,s.cgst_per,s.cgst_rs,\n" + 
    		"	    		s.igst_per,s.igst_rs,s.total_tax,s.grand_total,coalesce((select m_item_sup.item_hsncd from m_item_sup where m_item_sup.item_id=i.id),0) as  remark,s.del_status,s.bill_stock_type \n" + 
    		"	    		from t_sell_bill_detail s,m_item i \n" + 
    		"	    		WHERE s.sell_bill_no=:billNo AND s.item_id=i.id AND s.del_status=0",nativeQuery=true)
	List<SellBillDetailEdit> findBySellBillNo(@Param("billNo")int billNo);
	
	

}
