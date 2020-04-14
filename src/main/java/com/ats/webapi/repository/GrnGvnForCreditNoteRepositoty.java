package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.grngvn.GetGrnGvnForCreditNote;

public interface GrnGvnForCreditNoteRepositoty extends JpaRepository<GetGrnGvnForCreditNote, Integer>{
	
	@Query(value = " " + 
			" SELECT" + 
			"        t_grn_gvn.grn_gvn_id," + 
			"        t_grn_gvn.grn_gvn_header_id," + 
			"        t_grn_gvn_header.grngvn_srno," + 
			"        t_grn_gvn.grn_gvn_entry_datetime," + 
			"        t_grn_gvn.grn_gvn_date," + 
			"        t_grn_gvn.bill_no," + 
			"        t_grn_gvn.fr_id," + 
			"        t_grn_gvn.item_id," + 
			"        t_grn_gvn.item_rate," + 
			"        t_grn_gvn.item_mrp," + 
			"     t_grn_gvn.apr_qty_acc," + 
			"      t_grn_gvn.apr_grand_total," + 
			"        t_grn_gvn.grn_type," + 
			"        t_grn_gvn.is_grn," + 
			"        t_grn_gvn.is_grn_edit," + 
			"        t_grn_gvn.fr_grn_gvn_remark," + 
			"        t_grn_gvn.grn_gvn_status," + 
			"        t_grn_gvn.del_status," + 
			"        t_grn_gvn.grn_gvn_qty_auto," + 
			"        t_grn_gvn.is_tally_sync," + 
			"        t_grn_gvn.base_rate," + 
			"        t_grn_gvn.sgst_per," + 
			"        t_grn_gvn.cgst_per," + 
			"        t_grn_gvn.igst_per,t_grn_gvn.cess_per," + 
			"       t_grn_gvn.apr_taxable_amt," + 
			"       t_grn_gvn.apr_total_tax," + 
			"       t_grn_gvn.apr_r_off," + 
			"        t_grn_gvn.is_credit_note," + 
			"        t_grn_gvn.menu_id," + 
			"        t_grn_gvn.cat_id," + 
			"        t_grn_gvn.invoice_no,t_grn_gvn.hsn_code," + 
			"        t_grn_gvn.ref_invoice_date," + 
			"      " + 
			"        CAST(t_grn_gvn.approved_datetime_acc AS CHAR) as approved_datetime_acc," + 
			"        CASE " + 
			"            WHEN t_grn_gvn.cat_id=5 THEN s.sp_name  " + 
			"            ELSE  m_item.item_name " + 
			"        END AS item_name," + 
			"        m_franchisee.fr_name " + 
			"    FROM" + 
			"        m_franchisee," + 
			"        m_item," + 
			"        t_grn_gvn," + 
			"        t_grn_gvn_header," + 
			"        m_sp_cake s " + 
			"    WHERE" + 
			"        t_grn_gvn.is_grn=:isGrn" + 
			"        AND t_grn_gvn.fr_id=m_franchisee.fr_id " + 
			"        AND t_grn_gvn.grn_gvn_header_id=t_grn_gvn_header.grn_gvn_header_id " + 
			"        AND  CASE " + 
			"            WHEN t_grn_gvn.cat_id=5 THEN t_grn_gvn.item_id=s.sp_id " + 
			"            ELSE t_grn_gvn.item_id=m_item.id " + 
			"        END " + 
			"        AND  t_grn_gvn.is_credit_note=0  " + 
			"        AND t_grn_gvn.grn_gvn_status=6  AND  t_grn_gvn.grn_gvn_date between :fromDate and :toDate AND  t_grn_gvn.fr_id IN(:frId)" + 
			"    group by" + 
			"        t_grn_gvn.grn_gvn_id "
			, nativeQuery = true)
	
	List<GetGrnGvnForCreditNote> getGrnGvnDetailForCreditNote(@Param("isGrn") int isGrn,@Param("fromDate") String fromDate,@Param("toDate") String toDate,@Param("frId") List<Integer> frId);
	
}
