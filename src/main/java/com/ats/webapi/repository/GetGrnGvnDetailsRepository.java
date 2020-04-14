package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GetGrnGvnDetails;

public interface GetGrnGvnDetailsRepository extends JpaRepository<GetGrnGvnDetails, Integer> {
	
	
	@Query(value = "SELECT "
			+ "t_grn_gvn.apr_qty_gate,t_grn_gvn.apr_qty_store,t_grn_gvn.apr_qty_acc,t_grn_gvn.apr_taxable_amt,t_grn_gvn.apr_total_tax, t_grn_gvn.apr_sgst_rs,t_grn_gvn.apr_cgst_rs,t_grn_gvn.apr_igst_rs,t_grn_gvn.apr_cess_rs,t_grn_gvn.apr_grand_total,t_grn_gvn.apr_r_off,t_grn_gvn.is_same_state,"
			+ ""
			+ ""
			+ "t_grn_gvn.grn_gvn_id,t_grn_gvn.hsn_code as item_hsncd,t_grn_gvn.grn_gvn_header_id,t_grn_gvn.grn_gvn_entry_datetime,t_grn_gvn.grn_gvn_date,t_grn_gvn.bill_no,t_grn_gvn.fr_id,t_grn_gvn.item_id,t_grn_gvn.item_rate,\n" + 
			"t_grn_gvn.item_mrp,t_grn_gvn.grn_gvn_qty,t_grn_gvn.grn_gvn_amt,t_grn_gvn.grn_type,t_grn_gvn.is_grn,t_grn_gvn.is_grn_edit,\n" + 
			"t_grn_gvn.fr_grn_gvn_remark,t_grn_gvn.gvn_photo_upload1,t_grn_gvn.gvn_photo_upload2,t_grn_gvn.grn_gvn_status,\n" + 
			"t_grn_gvn.approved_login_gate,t_grn_gvn.approved_remark_gate,t_grn_gvn.approved_login_store,t_grn_gvn.approved_remark_store,\n" + 
			"t_grn_gvn.approved_login_acc,t_grn_gvn.approved_remark_acc,t_grn_gvn.del_status,t_grn_gvn.grn_gvn_qty_auto,\n" + 
			"t_grn_gvn.is_tally_sync,t_grn_gvn.base_rate,t_grn_gvn.sgst_per,t_grn_gvn.cgst_per,t_grn_gvn.cess_per,t_grn_gvn.igst_per,t_grn_gvn.taxable_amt,\n" + 
			"t_grn_gvn.total_tax,t_grn_gvn.round_up_amt,t_grn_gvn.final_amt,t_grn_gvn.is_credit_note,t_grn_gvn.menu_id,t_grn_gvn.cat_id,\n" + 
			"t_grn_gvn.invoice_no,t_grn_gvn.ref_invoice_date, CAST(t_grn_gvn.approved_datetime_gate AS CHAR) as approved_datetime_gate,\n" + 
			"CAST(t_grn_gvn.approved_datetime_store AS CHAR) as approved_datetime_store,CAST(t_grn_gvn.approved_datetime_acc AS CHAR) as approved_datetime_acc,\n" + 
			"m_item.item_name,m_franchisee.fr_name FROM m_franchisee,"
			+ "m_item,t_grn_gvn WHERE t_grn_gvn.fr_id=m_franchisee.fr_id AND "
			+ "t_grn_gvn.item_id=m_item.id AND t_grn_gvn.grn_gvn_date BETWEEN :fromDate AND  :toDate AND"
			+ " t_grn_gvn.is_grn=1 ORDER BY t_grn_gvn.grn_gvn_status"
			+ "" + "", nativeQuery = true)
	
	List<GetGrnGvnDetails> getAllGrnDetails(@Param("fromDate") String fromDate ,@Param("toDate") String toDate);

	@Query(value = "SELECT "
			+ "t_grn_gvn.apr_qty_gate,t_grn_gvn.apr_qty_store,t_grn_gvn.apr_qty_acc,t_grn_gvn.apr_taxable_amt,t_grn_gvn.apr_total_tax, t_grn_gvn.apr_sgst_rs,t_grn_gvn.apr_cgst_rs,t_grn_gvn.apr_igst_rs,t_grn_gvn.apr_cess_rs,t_grn_gvn.apr_grand_total,t_grn_gvn.apr_r_off,t_grn_gvn.is_same_state,"
			+ ""
			+ " t_grn_gvn.grn_gvn_id,t_grn_gvn.hsn_code as item_hsncd,t_grn_gvn.grn_gvn_entry_datetime,t_grn_gvn.grn_gvn_date,t_grn_gvn.bill_no,t_grn_gvn.fr_id,t_grn_gvn.item_id,t_grn_gvn.item_rate,\n" + 
			"t_grn_gvn.item_mrp,t_grn_gvn.grn_gvn_qty,t_grn_gvn.grn_gvn_amt,t_grn_gvn.grn_type,t_grn_gvn.is_grn,t_grn_gvn.is_grn_edit,\n" + 
			"t_grn_gvn.fr_grn_gvn_remark,t_grn_gvn.gvn_photo_upload1,t_grn_gvn.gvn_photo_upload2,t_grn_gvn.grn_gvn_status,\n" + 
			"t_grn_gvn.approved_login_gate,t_grn_gvn.approved_remark_gate,t_grn_gvn.approved_login_store,t_grn_gvn.approved_remark_store,\n" + 
			"t_grn_gvn.approved_login_acc,t_grn_gvn.approved_remark_acc,t_grn_gvn.del_status,t_grn_gvn.grn_gvn_qty_auto,\n" + 
			"t_grn_gvn.is_tally_sync,t_grn_gvn.base_rate,t_grn_gvn.sgst_per,t_grn_gvn.cgst_per,t_grn_gvn.cess_per,t_grn_gvn.igst_per,t_grn_gvn.taxable_amt,\n" + 
			"t_grn_gvn.total_tax,t_grn_gvn.round_up_amt,t_grn_gvn.final_amt,t_grn_gvn.is_credit_note,t_grn_gvn.menu_id,t_grn_gvn.cat_id,\n" + 
			"t_grn_gvn.invoice_no,t_grn_gvn.ref_invoice_date, CAST(t_grn_gvn.approved_datetime_gate AS CHAR) as approved_datetime_gate,\n" + 
			"CAST(t_grn_gvn.approved_datetime_store AS CHAR) as approved_datetime_store,CAST(t_grn_gvn.approved_datetime_acc AS CHAR) as approved_datetime_acc\n" + 
			",m_item.item_name,m_franchisee.fr_name FROM m_franchisee,"
			+ "m_item,t_grn_gvn WHERE t_grn_gvn.fr_id=m_franchisee.fr_id AND "
			+ "t_grn_gvn.item_id=m_item.id AND t_grn_gvn.grn_gvn_date BETWEEN :fromDate AND  :toDate AND"
			+ " t_grn_gvn.is_grn=0  ORDER BY t_grn_gvn.grn_gvn_status"
			+ "" + "", nativeQuery = true)
	
	List<GetGrnGvnDetails> getAllGvnDetails(@Param("fromDate") String fromDate ,@Param("toDate") String toDate);
	
	@Query(value =  " SELECT t_grn_gvn.hsn_code AS item_hsncd,"
			
			+ "CASE WHEN t_grn_gvn.cat_id=5 THEN (SELECT m_sp_cake.sp_name FROM m_sp_cake WHERE m_sp_cake.sp_id=t_grn_gvn.item_id) " + 
			"			ELSE (SELECT m_item.item_name FROM m_item WHERE t_grn_gvn.item_id=m_item.id) END AS item_name,"
			
			+ " t_grn_gvn.apr_qty_gate,t_grn_gvn.apr_qty_store,t_grn_gvn.apr_qty_acc,t_grn_gvn.apr_taxable_amt,t_grn_gvn.apr_total_tax," + 
			 "t_grn_gvn.apr_sgst_rs,t_grn_gvn.apr_cgst_rs,t_grn_gvn.apr_igst_rs,t_grn_gvn.apr_cess_rs,t_grn_gvn.apr_grand_total,t_grn_gvn.apr_r_off,t_grn_gvn.is_same_state, " +
			 "t_grn_gvn.grn_gvn_id,t_grn_gvn.grn_gvn_header_id,t_grn_gvn.grn_gvn_entry_datetime,t_grn_gvn.grn_gvn_date,t_grn_gvn.bill_no,t_grn_gvn.fr_id,t_grn_gvn.item_id,t_grn_gvn.item_rate,\n" + 
			"t_grn_gvn.item_mrp,t_grn_gvn.grn_gvn_qty,t_grn_gvn.grn_gvn_amt,t_grn_gvn.grn_type,t_grn_gvn.is_grn,t_grn_gvn.is_grn_edit,\n" + 
			"t_grn_gvn.fr_grn_gvn_remark,t_grn_gvn.gvn_photo_upload1,t_grn_gvn.gvn_photo_upload2,t_grn_gvn.grn_gvn_status,\n" + 
			"t_grn_gvn.approved_login_gate,t_grn_gvn.approved_remark_gate,t_grn_gvn.approved_login_store,t_grn_gvn.approved_remark_store,\n" + 
			"t_grn_gvn.approved_login_acc,t_grn_gvn.approved_remark_acc,t_grn_gvn.del_status,t_grn_gvn.grn_gvn_qty_auto,\n" + 
			"t_grn_gvn.is_tally_sync,t_grn_gvn.base_rate,t_grn_gvn.sgst_per,t_grn_gvn.cgst_per,t_grn_gvn.cess_per,t_grn_gvn.igst_per,t_grn_gvn.taxable_amt,\n" + 
			"t_grn_gvn.total_tax,t_grn_gvn.round_up_amt,t_grn_gvn.final_amt,t_grn_gvn.is_credit_note,t_grn_gvn.menu_id,t_grn_gvn.cat_id,\n" + 
			"t_grn_gvn.invoice_no,t_grn_gvn.ref_invoice_date, CAST(t_grn_gvn.approved_datetime_gate AS CHAR) as approved_datetime_gate,\n" + 
			"CAST(t_grn_gvn.approved_datetime_store AS CHAR) as approved_datetime_store,CAST(t_grn_gvn.approved_datetime_acc AS CHAR) as approved_datetime_acc,\n" + 
			"m_franchisee.fr_name FROM m_franchisee," 
			+"t_grn_gvn WHERE  t_grn_gvn.is_grn=0 AND"
			+ "  t_grn_gvn.fr_id=m_franchisee.fr_id AND t_grn_gvn.grn_gvn_header_id=:grnGvnHeaderId "
			+ "" + "", nativeQuery = true)
	
	List<GetGrnGvnDetails> getFrGvnDetails(@Param("grnGvnHeaderId") int grnGvnHeaderId);
//changed on 16 feb for grnGvnHeaderId
	@Query(value = "SELECT t_grn_gvn.hsn_code  AS item_hsncd, "
		
			+ "CASE WHEN t_grn_gvn.cat_id=5 THEN (SELECT m_sp_cake.sp_name FROM m_sp_cake WHERE m_sp_cake.sp_id=t_grn_gvn.item_id) " + 
			"		ELSE (SELECT m_item.item_name FROM m_item WHERE t_grn_gvn.item_id=m_item.id) END AS item_name,"
		
			+ "t_grn_gvn.apr_qty_gate,t_grn_gvn.apr_qty_store,t_grn_gvn.apr_qty_acc,t_grn_gvn.apr_taxable_amt,t_grn_gvn.apr_total_tax,"
			+ "t_grn_gvn.apr_sgst_rs,t_grn_gvn.apr_cgst_rs,t_grn_gvn.apr_igst_rs,t_grn_gvn.apr_cess_rs,t_grn_gvn.apr_grand_total,t_grn_gvn.apr_r_off,t_grn_gvn.is_same_state,"
			+ "t_grn_gvn.grn_gvn_id,t_grn_gvn.grn_gvn_header_id,t_grn_gvn.grn_gvn_entry_datetime,t_grn_gvn.grn_gvn_date,t_grn_gvn.bill_no,t_grn_gvn.fr_id,t_grn_gvn.item_id,t_grn_gvn.item_rate,\n" + 
			"t_grn_gvn.item_mrp,t_grn_gvn.grn_gvn_qty,t_grn_gvn.grn_gvn_amt,t_grn_gvn.grn_type,t_grn_gvn.is_grn,t_grn_gvn.is_grn_edit,\n" + 
			"t_grn_gvn.fr_grn_gvn_remark,t_grn_gvn.gvn_photo_upload1,t_grn_gvn.gvn_photo_upload2,t_grn_gvn.grn_gvn_status,\n" + 
			"t_grn_gvn.approved_login_gate,t_grn_gvn.approved_remark_gate,t_grn_gvn.approved_login_store,t_grn_gvn.approved_remark_store,\n" + 
			"t_grn_gvn.approved_login_acc,t_grn_gvn.approved_remark_acc,t_grn_gvn.del_status,t_grn_gvn.grn_gvn_qty_auto,\n" + 
			"t_grn_gvn.is_tally_sync,t_grn_gvn.base_rate,t_grn_gvn.sgst_per,t_grn_gvn.cgst_per,t_grn_gvn.cess_per,t_grn_gvn.igst_per,t_grn_gvn.taxable_amt,\n" + 
			"t_grn_gvn.total_tax,t_grn_gvn.round_up_amt,t_grn_gvn.final_amt,t_grn_gvn.is_credit_note,t_grn_gvn.menu_id,t_grn_gvn.cat_id,\n" + 
			"t_grn_gvn.invoice_no,t_grn_gvn.ref_invoice_date, CAST(t_grn_gvn.approved_datetime_gate AS CHAR) as approved_datetime_gate,\n" + 
			"CAST(t_grn_gvn.approved_datetime_store AS CHAR) as approved_datetime_store,CAST(t_grn_gvn.approved_datetime_acc AS CHAR) as approved_datetime_acc,\n" + 
			"m_item.item_name,m_franchisee.fr_name FROM m_franchisee," 
			+"m_item,t_grn_gvn WHERE  t_grn_gvn.is_grn=1 AND"
			+ " t_grn_gvn.item_id=m_item.id AND t_grn_gvn.fr_id=m_franchisee.fr_id "
			+ " AND t_grn_gvn.grn_gvn_header_id=:grnGvnHeaderId "
			+ "", nativeQuery = true)
	
	List<GetGrnGvnDetails> getFrGrnDetails(@Param("grnGvnHeaderId") int grnGvnHeaderId);
	
	
}
