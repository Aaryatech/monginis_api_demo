package com.ats.webapi.repository.tally;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.tally.MaterialReceiptNote;

@Repository
public interface MaterialReceiptNoteRepository extends JpaRepository<MaterialReceiptNote, Integer>{

	@Query(value="select\n" + 
			"        d.mrn_detail_id,\n" + 
			"        d.mrn_id,\n" + 
			"        d.mrn_no,\n" + 
			"        h.invoice_number,\n" + 
			"        h.inv_book_date,\n" + 
			"        h.inv_date,\n" + 
			"        h.mrn_type,\n" + 
			"        h.supplier_id,\n" + 
			"        s.supp_name,\n" + 
			"        s.supp_gstin,\n" + 
			"        s.supp_state,\n" + 
			"        d.rm_id,\n" + 
			"        d.rm_name,\n" + 
			"        r.rm_clo_qty as hsn_code,\n" + 
			"        d.rm_uom,\n" + 
			"        d.recd_qty,\n" + 
			"        d.varified_rate,\n" + 
			"        d.value,\n" + 
			"        d.disc_per,\n" + 
			"        d.disc_amt,\n" + 
			"        d.value-d.disc_amt as amount,\n" + 
			"        d.cgst_per,\n" + 
			"        d.sgst_per,\n" + 
			"        d.igst_per,\n" + 
			"        d.cgst_rs,\n" + 
			"        d.sgst_rs,\n" + 
			"        d.igst_rs,\n" + 
			"        d.cess_rs,\n" + 
			"        h.freight_amt,\n" + 
			"        h.insurance_amt, \n" + 
			"        h.disc_amt+h.other2 as disc_rs_onbill,\n" + 
			"        h.other3,\n" + 
			"        h.other4,\n" + 
			"        h.bill_amount\n" + 
			"    from\n" + 
			"        t_material_receipt_note_detail d ,\n" + 
			"        t_material_receipt_note h,\n" + 
			"        m_supplier s,\n" + 
			"        m_rm r\n" + 
			"    where\n" + 
			"        h.mrn_id=d.mrn_id \n" + 
			"        AND h.supplier_id=s.supp_id \n" + 
			"        and r.rm_id=d.rm_id\n" + 
			"        AND h.status=5 \n" + 
			"        AND h.is_tally_sync=0",nativeQuery=true)
	List<MaterialReceiptNote> getAllInwards();

}
