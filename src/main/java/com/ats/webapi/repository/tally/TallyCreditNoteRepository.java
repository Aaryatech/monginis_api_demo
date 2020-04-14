package com.ats.webapi.repository.tally;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.tally.CreditNote;

@Repository
public interface TallyCreditNoteRepository extends JpaRepository<CreditNote, Integer>{

	@Query(value="  select\n" + 
			"        h.crn_id,\n" + 
			"        h.crn_date,\n" + 
			"        d.crnd_id,\n" + 
			"        h.crn_no,\n" + 
			"        f.fr_name,\n" + 
			"        f.fr_gst_no,\n" + 
			"        sup.fr_state,\n" + 
			"        CASE \n" + 
			"            WHEN d.cat_id = 5  THEN (select\n" + 
			"                s.sp_name \n" + 
			"            from\n" + 
			"                m_sp_cake s \n" + 
			"            where\n" + 
			"                s.sp_id=d.item_id) \n" + 
			"            ELSE (select\n" + 
			"                i.item_name  \n" + 
			"            from\n" + 
			"                m_item i \n" + 
			"            where\n" + 
			"                i.id=d.item_id) \n" + 
			"        END AS item_name,"
			+ "CASE                                        \n" + 
			"            WHEN d.cat_id = 5  THEN (select\n" + 
			"                s.sp_code                                        \n" + 
			"            from\n" + 
			"                m_sp_cake s                                        \n" + 
			"            where\n" + 
			"                s.sp_id=d.item_id)                                        \n" + 
			"            ELSE (select\n" + 
			"                i.item_id                                         \n" + 
			"            from\n" + 
			"                m_item i                                        \n" + 
			"            where\n" + 
			"                i.id=d.item_id)                            \n" + 
			"        END AS item_code,\n" + 
			"        d.hsn_code,\n" + 
			"        CASE \n" + 
			"            WHEN d.cat_id = 5 THEN (select\n" + 
			"                spsup.sp_uom \n" + 
			"            from\n" + 
			"                m_spcake_sup spsup \n" + 
			"            where\n" + 
			"                spsup.sp_id=d.item_id) \n" + 
			"            ELSE (select\n" + 
			"                itemsup.item_uom \n" + 
			"            from\n" + 
			"                m_item_sup itemsup \n" + 
			"            where\n" + 
			"                itemsup.item_id=d.item_id) \n" + 
			"        END AS uom,\n" + 
			"        d.grn_gvn_qty,\n" + 
			"        d.base_rate,\n" + 
			"        d.taxable_amt,\n" + 
			"        d.cgst_per,\n" + 
			"        d.sgst_per,\n" + 
			"        d.igst_per,\n" + 
			"        d.cess_per,\n" + 
			"        d.cgst_rs,\n" + 
			"        d.sgst_rs,\n" + 
			"        d.igst_rs,\n" + 
			"        d.cess_rs,\n" + 
			"        h.round_off,\n" + 
			"        h.crn_final_amt,\n" + 
			"        d.ref_invoice_no,\n" + 
			"        d.ref_invoice_date,\n" + 
			"        d.grn_gvn_id,\n" + 
			"        d.grngvn_srno,\n" + 
			"        d.grn_gvn_header_id,\n" + 
			"        h.is_deposited,\n" + 
			"        d.grn_gvn_date,\n" + 
			"        \n" + 
			"        h.fr_id,\n" + 
			"        f.fr_code,\n" + 
			"        d.item_id,\n" + 
			"        d.cat_id,\n" + 
			"        h.crn_taxable_amt,\n" + 
			"        h.crn_total_tax,\n" + 
			"        h.crn_grand_total, d.is_grn from\n" + 
			"        t_credit_note_header h,\n" + 
			"        t_credit_note_details d,\n" + 
			"        m_franchisee f,\n" + 
			"        m_franchise_sup sup WHERE\n" + 
			"        h.is_tally_sync=0 \n" + 
			"        AND h.crn_id=d.crn_id \n" + 
			"        AND h.fr_id=f.fr_id  \n" + 
			"        AND h.fr_id=sup.fr_id",nativeQuery=true)
	List<CreditNote> findByIsTallySync();

	@Query(value=" select\n" + 
			"        h.crn_id,\n" + 
			"        h.crn_date,\n" + 
			"        d.crnd_id,\n" + 
			"        h.crn_no,\n" + 
			"        f.fr_name,\n" + 
			"        f.fr_gst_no,\n" + 
			"        sup.fr_state,\n" + 
			"        CASE                           \n" + 
			"            WHEN d.cat_id = 5  THEN (select\n" + 
			"                s.sp_name                           \n" + 
			"            from\n" + 
			"                m_sp_cake s                           \n" + 
			"            where\n" + 
			"                s.sp_id=d.item_id)                           \n" + 
			"            ELSE (select\n" + 
			"                i.item_name                            \n" + 
			"            from\n" + 
			"                m_item i                           \n" + 
			"            where\n" + 
			"                i.id=d.item_id)                   \n" + 
			"        END AS item_name,\n" + 
			"        d.hsn_code,\n "
			+ "CASE WHEN d.cat_id = 5  THEN (select\n" + 
			"                s.sp_code                                        \n" + 
			"            from\n" + 
			"                m_sp_cake s                                        \n" + 
			"            where\n" + 
			"                s.sp_id=d.item_id)                                        \n" + 
			"            ELSE (select\n" + 
			"                i.item_id                                         \n" + 
			"            from\n" + 
			"                m_item i                                        \n" + 
			"            where\n" + 
			"                i.id=d.item_id)                            \n" + 
			"        END AS item_code," + 
			"        CASE                           \n" + 
			"            WHEN d.cat_id = 5 THEN (select\n" + 
			"                spsup.sp_uom                           \n" + 
			"            from\n" + 
			"                m_spcake_sup spsup                           \n" + 
			"            where\n" + 
			"                spsup.sp_id=d.item_id)                           \n" + 
			"            ELSE (select\n" + 
			"                itemsup.item_uom                           \n" + 
			"            from\n" + 
			"                m_item_sup itemsup                           \n" + 
			"            where\n" + 
			"                itemsup.item_id=d.item_id)                   \n" + 
			"        END AS uom,\n" + 
			"        d.grn_gvn_qty,\n" + 
			"        d.base_rate,\n" + 
			"        d.taxable_amt,\n" + 
			"        d.cgst_per,\n" + 
			"        d.sgst_per,\n" + 
			"        d.igst_per,\n" + 
			"        d.cess_per,\n" + 
			"        d.cgst_rs,\n" + 
			"        d.sgst_rs,\n" + 
			"        d.igst_rs,\n" + 
			"        d.cess_rs,\n" + 
			"        h.round_off,\n" + 
			"        h.crn_final_amt,\n" + 
			"        d.ref_invoice_no,\n" + 
			"        d.ref_invoice_date,\n" + 
			"        d.grn_gvn_id,\n" + 
			"        d.grngvn_srno,\n" + 
			"        d.grn_gvn_header_id,\n" + 
			"        h.is_deposited,\n" + 
			"        d.grn_gvn_date,\n" + 
			"        h.fr_id,\n" + 
			"        f.fr_code,\n" + 
			"        d.item_id,\n" + 
			"        d.cat_id,\n" + 
			"        h.crn_taxable_amt,\n" + 
			"        h.crn_total_tax,\n" + 
			"        h.crn_grand_total, "
			+ "d.is_grn,"
			+ "CASE                                        \n" + 
			"            WHEN d.cat_id = 5  THEN (select\n" + 
			"                s.erp_link_code                                        \n" + 
			"            from\n" + 
			"                m_sp_cake s                                        \n" + 
			"            where\n" + 
			"                s.sp_id=d.item_id)                                        \n" + 
			"            ELSE (0)                            \n" + 
			"        END AS erp_link\n" + 
			"    from\n" + 
			"        t_credit_note_header h,\n" + 
			"        t_credit_note_details d,\n" + 
			"        m_franchisee f,\n" + 
			"        m_franchise_sup sup "
			+ "WHERE\n" + 
			"        h.crn_id=d.crn_id                   \n" + 
			"        AND h.fr_id=f.fr_id                   \n" + 
			"        AND h.fr_id=sup.fr_id "
			+ "and h.crn_id in (:crnId )",nativeQuery=true)
	List<CreditNote> getCreditNotesByCrnId(@Param("crnId")List<Integer> crnId);


}
