package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.report.GetCustomerBill;
import com.ats.webapi.model.report.GetRepItemwiseSell;

public interface GetCustomerBillRepository extends JpaRepository<GetCustomerBill, Integer>{

	@Query(value="select h.sell_bill_no,h.bill_type, h.user_name,h.user_gst_no,h.user_phone,f.fr_mob, f.fr_gst_no ,d.remark as item_hsncd, h.discount_per, h.discount_amt, f.fr_address, d.sell_bill_detail_no, h.bill_date, h.fr_id, f.fr_name, h.invoice_no, d.item_id, t.item_name,d.mrp, d.qty, h.grand_total, h.taxable_amt, d.igst_per, d.igst_rs, d.cgst_per, d.cgst_rs, d.sgst_per,d.sgst_rs from t_sell_bill_detail d, t_sell_bill_header h, m_franchisee f, m_item t where h.sell_bill_no=:billNo AND h.sell_bill_no=d.sell_bill_no AND	d.item_id=t.id  AND f.fr_id=h.fr_id",nativeQuery=true)
	List<GetCustomerBill> getCustBill(@Param("billNo") int billNo);
}

