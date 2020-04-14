package com.ats.webapi.repository.materialrecreport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param; 
import com.ats.webapi.model.materialrecreport.GetMaterialRecieptReportItemWise;

public interface MaterialRecieptReportRepositoryItemWise extends JpaRepository<GetMaterialRecieptReportItemWise,Long>{
	
	@Query(value="select t_material_receipt_note_detail.rm_id, t_material_receipt_note_detail.rm_name, m_rm.rm_clo_qty as hsncd_no, "
			+ "t_material_receipt_note_detail.cgst_per+t_material_receipt_note_detail.sgst_per as tax_rate, "
			+ "sum(t_material_receipt_note_detail.recd_qty) as recd_qty, sum(t_material_receipt_note_detail.cgst_rs) as cgst, "
			+ "sum(t_material_receipt_note_detail.sgst_rs) as sgst, sum(t_material_receipt_note_detail.igst_rs) as igst, "
			+ "sum(t_material_receipt_note_detail.amount) as taxable_amt from t_material_receipt_note_detail , m_rm, t_material_receipt_note "
			+ "where t_material_receipt_note.inv_book_date between :fromDate and :toDate and t_material_receipt_note_detail.rm_id in (:item) and "
			+ "t_material_receipt_note_detail.mrn_id=t_material_receipt_note.mrn_id and "
			+ "t_material_receipt_note_detail.rm_id=m_rm.rm_id and "
			+ "t_material_receipt_note.status=5 group by t_material_receipt_note_detail.rm_id",nativeQuery=true) 
	List<GetMaterialRecieptReportItemWise> materialRecieptItemWise( @Param("item")List<String> item,@Param("fromDate")String fromDate,@Param("toDate")String toDate);
 

}
