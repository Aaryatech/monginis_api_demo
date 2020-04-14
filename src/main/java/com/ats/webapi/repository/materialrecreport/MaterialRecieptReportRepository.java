package com.ats.webapi.repository.materialrecreport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.materialrecreport.GetMaterialRecieptReportBillWise;

public interface MaterialRecieptReportRepository extends JpaRepository<GetMaterialRecieptReportBillWise,Long>{
	
	
	@Query(value=" select t_material_receipt_note.mrn_id, t_material_receipt_note.mrn_no, t_material_receipt_note.inv_book_date, "
			+ "t_material_receipt_note.invoice_number, t_material_receipt_note.inv_date, t_material_receipt_note.supplier_id, m_supplier.supp_name, "
			+ "m_supplier.supp_city, m_supplier.supp_gstin, t_material_receipt_note.basic_value, t_material_receipt_note.disc_amt+t_material_receipt_note.disc_amt2+t_material_receipt_note.other1+t_material_receipt_note.other2 as disc_amt, "
			+ "t_material_receipt_note.other3+t_material_receipt_note.other4 as other, t_material_receipt_note.freight_amt, t_material_receipt_note.insurance_amt, "
			+ "t_material_receipt_note.cgst, t_material_receipt_note.sgst, t_material_receipt_note.igst, t_material_receipt_note.round_off, t_material_receipt_note.cess, t_material_receipt_note.bill_amount \r\n" + 
			"    from t_material_receipt_note, m_supplier where t_material_receipt_note.supplier_id in (:suppId) and m_supplier.supp_id=t_material_receipt_note.supplier_id "
			+ "and t_material_receipt_note.inv_book_date between :fromDate and :toDate and t_material_receipt_note.status=5 order by "
			+ "t_material_receipt_note.inv_book_date",nativeQuery=true)
	List<GetMaterialRecieptReportBillWise> billWiseReport( @Param("suppId")List<String> suppId,@Param("fromDate")String fromDate,@Param("toDate")String toDate);

	
	@Query(value="select t_material_receipt_note.mrn_id, t_material_receipt_note.mrn_no, t_material_receipt_note.inv_book_date, t_material_receipt_note.invoice_number,\r\n" + 
			" t_material_receipt_note.inv_date, t_material_receipt_note.supplier_id, m_supplier.supp_name, m_supplier.supp_city, m_supplier.supp_gstin, \r\n" + 
			" sum(t_material_receipt_note.basic_value) as basic_value, sum(t_material_receipt_note.disc_amt+t_material_receipt_note.disc_amt2+t_material_receipt_note.other1+t_material_receipt_note.other2) as disc_amt,\r\n" + 
			" sum(t_material_receipt_note.freight_amt) as freight_amt, sum(t_material_receipt_note.insurance_amt) as insurance_amt,\r\n" + 
			" sum(t_material_receipt_note.other3+t_material_receipt_note.other4) as other,sum(t_material_receipt_note.cgst) as cgst, sum(t_material_receipt_note.sgst) as sgst, sum(t_material_receipt_note.igst) as igst,\r\n" + 
			" sum(t_material_receipt_note.round_off) as round_off, sum(t_material_receipt_note.bill_amount) as bill_amount,sum(t_material_receipt_note.cess) as cess\r\n" + 
			" from t_material_receipt_note , m_supplier where t_material_receipt_note.supplier_id in (:suppId) and m_supplier.supp_id=t_material_receipt_note.supplier_id and\r\n" + 
			" t_material_receipt_note.inv_book_date between :fromDate and :toDate and t_material_receipt_note.status=5 group by  t_material_receipt_note.supplier_id",nativeQuery=true) 
	List<GetMaterialRecieptReportBillWise> materialRecieptSupplierWiseReport( @Param("suppId")List<String> suppId,@Param("fromDate")String fromDate,@Param("toDate")String toDate);

	@Query(value="select\r\n" + 
			"t_material_receipt_note.mrn_id, t_material_receipt_note.mrn_no, t_material_receipt_note.inv_book_date, t_material_receipt_note.invoice_number,\r\n" + 
			" t_material_receipt_note.inv_date, t_material_receipt_note.supplier_id, m_supplier.supp_name,\r\n" + 
			" m_supplier.supp_city, m_supplier.supp_gstin, sum(t_material_receipt_note.basic_value) as basic_value, sum(t_material_receipt_note.disc_amt+t_material_receipt_note.disc_amt2+t_material_receipt_note.other1+t_material_receipt_note.other2) as disc_amt,\r\n" + 
			" sum(t_material_receipt_note.freight_amt) as freight_amt, sum(t_material_receipt_note.insurance_amt) as insurance_amt, sum(t_material_receipt_note.cgst) as cgst,\r\n" + 
			" sum(t_material_receipt_note.other3+t_material_receipt_note.other4) as other, sum(t_material_receipt_note.sgst) as sgst, sum(t_material_receipt_note.igst) as igst, sum(t_material_receipt_note.round_off) as round_off,\r\n" + 
			" sum(t_material_receipt_note.bill_amount) as bill_amount,sum(t_material_receipt_note.cess) as cess from t_material_receipt_note , m_supplier where \r\n" + 
			" t_material_receipt_note.supplier_id in (:suppId) and m_supplier.supp_id=t_material_receipt_note.supplier_id and t_material_receipt_note.inv_book_date between :fromDate and :toDate" + 
			" and t_material_receipt_note.status=5 group by t_material_receipt_note.inv_book_date",nativeQuery=true) 
	List<GetMaterialRecieptReportBillWise> materialRecieptDateWiseReport( @Param("suppId")List<String> suppId,@Param("fromDate")String fromDate,@Param("toDate")String toDate);


	


}
