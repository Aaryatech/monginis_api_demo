package com.ats.webapi.repository.tally;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.tally.MaterialRecNoteDetail;
@Repository
public interface MaterialRecNoteDetailRepository extends JpaRepository<MaterialRecNoteDetail, Integer>{

	@Query(value="select d.mrn_detail_id,d.mrn_id,d.mrn_no,d.rm_id,d.rm_name,d.rm_uom,d.recd_qty,d.po_rate,d.Value,d.disc_per,\n" + 
			"d.disc_amt,\n" + 
			"d.gst_per,\n" + 
			"d.freight_per,\n" + 
			"d.freight_amt,\n" + 
			"d.insurance_per,\n" + 
			"d.insurance_amt,\n" + 
			"d.cgst_per,\n" + 
			"d.cgst_rs,\n" + 
			"d.sgst_per,\n" + 
			"d.sgst_rs,\n" + 
			"d.igst_per,\n" + 
			"d.igst_rs,\n" + 
			"d.cess_per,\n" + 
			"d.cess_rs,\n" + 
			"d.amount\n" + 
			"\n" + 
			" from t_material_receipt_note_detail d where d.mrn_id=1",nativeQuery=true)
	List<MaterialRecNoteDetail> getAllInwardDetails();

}
