package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.bill.GetBillDetailPrint;

public interface BillDetailForPrintRepo extends JpaRepository<GetBillDetailPrint, Integer>{ 
	

	@Query(value="SELECT  t_bill_detail.bill_detail_no,t_bill_detail.bill_no,t_bill_detail.order_id,t_bill_detail.menu_id,t_bill_detail.cat_id,t_bill_detail.item_id,t_bill_detail.order_qty,t_bill_detail.bill_qty,t_bill_detail.mrp,t_bill_detail.rate_type,t_bill_detail.rate,t_bill_detail.base_rate,t_bill_detail.taxable_amt,t_bill_detail.sgst_per,\n" + 
			"  t_bill_detail.sgst_rs, t_bill_detail.cgst_per,t_bill_detail.cgst_rs,t_bill_detail.cess_per,t_bill_detail.cess_rs, t_bill_detail.igst_per, t_bill_detail.igst_rs,\n" + 
			"t_bill_detail.total_tax,  t_bill_detail.grand_total, t_bill_detail.del_status, t_bill_detail.grn_type,  t_bill_detail.expiry_date,  t_bill_detail.is_grngvn_applied,  t_bill_detail.disc_per, t_bill_detail.remark as disc_amt,  t_bill_detail.cess_per,  t_bill_detail.cess_rs, CASE  WHEN t_bill_detail.cat_id=5 THEN (SELECT CONCAT(m_sp_cake.sp_name, '-' ,coalesce((select spf_name from m_sp_flavour where spf_id=(select sp_flavour_id from t_sp_cake where sp_order_no=t_bill_detail.order_id)),'-'))  FROM  m_sp_cake WHERE m_sp_cake.sp_id= t_bill_detail.item_id) ELSE (SELECT  m_item.item_name FROM m_item WHERE t_bill_detail.item_id=m_item.id)END AS item_name, m_category.cat_name, \n" + 
			" t_bill_header.bill_date,t_bill_detail.hsn_code AS item_hsncd,\n" + 
			"						\n" + 
			"						CASE \n" + 
			"						            WHEN t_bill_detail.cat_id=5 THEN (SELECT m_spcake_sup.sp_uom  FROM m_spcake_sup  \n" + 
			"						WHERE  m_spcake_sup.sp_id=t_bill_detail.item_id)\n" + 
			"						            ELSE (SELECT m_item_sup.item_uom FROM m_item_sup \n" + 
			"						 WHERE  m_item_sup.item_id=t_bill_detail.item_id) \n" + 
			"						        END AS item_uom,\n" + 
			"			\n" + 
			"			CASE  WHEN t_bill_detail.cat_id=5 THEN (0)\n" + 
			"						            ELSE (SELECT m_item.item_grp2 FROM m_item \n" + 
			"						 WHERE  m_item.id=t_bill_detail.item_id) \n" + 
			"						        END AS sub_cat_id,\n" + 
			"CASE  WHEN t_bill_detail.cat_id=5 THEN coalesce((select t_sp_cake.sp_selected_weight from t_sp_cake where t_sp_cake.sp_order_no=t_bill_detail.order_id),0)" + 
			"						            ELSE (0) \n" + 
			"						        END AS remark\n" + 
			"\n" + 
			"						 FROM\n" + 
			"						        t_bill_detail,\n" + 
			"						        m_category,\n" + 
			"						        t_bill_header\n" + 
			"			\n" + 
			"						    WHERE\n" + 
			"						        t_bill_detail.bill_no IN (:billNoList)\n" + 
			"\n" + 
			"						        AND m_category.cat_id=t_bill_detail.cat_id \n" + 
			"						        AND t_bill_detail.bill_qty>0 and t_bill_detail.bill_no=t_bill_header.bill_no  order by m_category.cat_id,sub_cat_id,item_name",nativeQuery=true)
	
	List<GetBillDetailPrint> getBillDetailsForPrint(@Param("billNoList") List<String> billNoList);
	
}