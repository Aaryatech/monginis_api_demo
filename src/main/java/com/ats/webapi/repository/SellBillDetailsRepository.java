package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.SellBillDetails;

@Repository
public interface SellBillDetailsRepository extends JpaRepository<SellBillDetails, Integer>{
	

    @Query(value="Select s.sell_bill_detail_no,s.sell_bill_no,s.cat_id,s.item_id,i.item_name,\n" + 
    		"	    		s.mrp,s.qty,s.mrp_base_rate,s.taxable_amt,s.sgst_per,s.sgst_rs,s.cgst_per,s.cgst_rs,\n" + 
    		"	    		s.igst_per,s.igst_rs,s.total_tax,s.grand_total,s.remark,s.del_status \n" + 
    		"	    		from t_sell_bill_detail s,m_item i \n" + 
    		"	    		WHERE s.sell_bill_no=:billNo AND s.item_id=i.id AND s.del_status=0 ORDER BY s.sell_bill_detail_no DESC ",nativeQuery=true)
	List<SellBillDetails> findByBillNo(@Param("billNo")int billNo);
}
