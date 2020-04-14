package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.MaterialRecNoteDetails;

@Repository
public interface MaterialRNoteDetailRepository extends JpaRepository<MaterialRecNoteDetails, Integer>{

	MaterialRecNoteDetails save(MaterialRecNoteDetails materialRecNoteDetails);

	@Query(value="  select d.mrn_detail_id,d.mrn_id,mrn_no,d.supplier_id,d.rm_id,rm_name,d.rm_uom,recd_qty,d.po_id,d.po_qty,d.stock_qty,d.po_rate,d.Value,d.disc_per,\n" + 
			"  d.disc_amt,d.gst_per,d.freight_per,d.freight_amt,d.insurance_per,d.insurance_amt,d.cgst_per,d.cgst_rs,d.sgst_per,d.sgst_rs,d.igst_per,d.igst_rs,d.cess_per,d.cess_rs,d.amount,d.director_approved,d.del_status,d.status,d.rejected_qty,d.other1,d.other2,d.other3,d.other4,coalesce(( CASE WHEN d.varified_rate=0 THEN (select r.rate_tax_extra from m_rm_rate_verif r where supp_id=d.supplier_id AND rm_id=d.rm_id and grp_id= d.grp_id) ELSE (d.varified_rate) END),0) as varified_rate,d.grp_id from t_material_receipt_note_detail d where mrn_id=:mrnId AND del_status=0",nativeQuery=true)
	List<MaterialRecNoteDetails> getByMrnId(@Param("mrnId")int mrnId);

	@Query(value="  select d.mrn_detail_id,d.mrn_id,mrn_no,d.supplier_id,d.rm_id,rm_name,d.rm_uom,recd_qty,d.po_id,d.po_qty,d.stock_qty,d.po_rate,d.Value,d.disc_per,\n" + 
			"  d.disc_amt,d.gst_per,d.freight_per,d.freight_amt,d.insurance_per,d.insurance_amt,d.cgst_per,d.cgst_rs,d.sgst_per,d.sgst_rs,d.igst_per,d.igst_rs,d.cess_per,d.cess_rs,d.amount,d.director_approved,d.del_status,d.status,d.rejected_qty,d.other1,d.other2,d.other3,d.other4,coalesce(( CASE WHEN d.varified_rate=0 THEN (select r.rate_tax_incl from m_rm_rate_verif r where supp_id=d.supplier_id AND rm_id=d.rm_id and grp_id= d.grp_id) ELSE (d.varified_rate) END),0) as varified_rate,d.grp_id from t_material_receipt_note_detail d where mrn_id=:mrnId AND del_status=0",nativeQuery=true)
	List<MaterialRecNoteDetails> getByMrnIdNew(@Param("mrnId")int mrnId);
	
}
