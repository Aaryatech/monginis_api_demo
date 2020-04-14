package com.ats.webapi.repository.materialrecreport;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.materialrecreport.GetMaterialRecieptReportHsnCodeWise; 
public interface MaterialRecieptReportRepositoryHsnCodeWise extends JpaRepository<GetMaterialRecieptReportHsnCodeWise,Integer>{

	
	@Query(value="select \r\n" + 
			"t_material_receipt_note_detail.mrn_detail_id,t_material_receipt_note.mrn_no,\r\n" + 
			"t_material_receipt_note.inv_book_date,\r\n" + 
			"t_material_receipt_note.invoice_number,\r\n" + 
			"m_supplier.supp_name,\r\n" + 
			"m_rm.rm_clo_qty as hsncd_no,\r\n" + 
			"sum(t_material_receipt_note_detail.Value) as value,sum(t_material_receipt_note_detail.cgst_rs) as cgst,\r\n" + 
			"sum(t_material_receipt_note_detail.sgst_rs) as sgst,\r\n" + 
			"sum(t_material_receipt_note_detail.igst_rs) as igst,\r\n" + 
			"sum(t_material_receipt_note_detail.amount) as taxable_amt\r\n" + 
			"from \r\n" + 
			"t_material_receipt_note_detail , m_rm, t_material_receipt_note,\r\n" + 
			"m_supplier \r\n" + 
			"where \r\n" + 
			"t_material_receipt_note.inv_book_date between :fromDate and :toDate\r\n" + 
			"and t_material_receipt_note.supplier_id in (:suppId)\r\n" + 
			"and m_supplier.supp_id=t_material_receipt_note.supplier_id \r\n" + 
			"and t_material_receipt_note_detail.mrn_id=t_material_receipt_note.mrn_id \r\n" + 
			"and t_material_receipt_note_detail.rm_id=m_rm.rm_id \r\n" + 
			"and t_material_receipt_note.status=5 \r\n" + 
			"group by t_material_receipt_note.mrn_no,m_rm.rm_clo_qty ",nativeQuery=true) 
	List<GetMaterialRecieptReportHsnCodeWise> materialRecieptHsnCodeWise( @Param("suppId")List<String> suppId,@Param("fromDate")String fromDate,@Param("toDate")String toDate);
   

}
