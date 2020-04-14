package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GetMaterialReceiptByDate;
import com.ats.webapi.model.MaterialRecNote; 

public interface GetMaterialReceiptByDateRepository extends JpaRepository<GetMaterialReceiptByDate, Integer>{
	
	@Query(value="select t_material_receipt_note.mrn_id,t_material_receipt_note.mrn_no, t_material_receipt_note.gate_entry_date,"
			+ "t_material_receipt_note.vehicle_no,t_material_receipt_note.lr_no, t_material_receipt_note.mrn_store_date, t_material_receipt_note.mrn_type,"
			+ "t_material_receipt_note.against_po, t_material_receipt_note.po_id, t_material_receipt_note.po_no, t_material_receipt_note.po_date,"
			+ "t_material_receipt_note.inv_book_date, t_material_receipt_note.invoice_number, t_material_receipt_note.basic_value,"
			+ "t_material_receipt_note.bill_amount,t_material_receipt_note.status, m_supplier.supp_name, m_transporter.tran_name from m_supplier,"
			+ "m_transporter, t_material_receipt_note where m_supplier.supp_id=t_material_receipt_note.supplier_id and m_transporter.tran_id=t_material_receipt_note.transport_id and\r\n" + 
			"t_material_receipt_note.gate_entry_date between :fromDate and :toDate and t_material_receipt_note.status in (:status) and "
			+ "t_material_receipt_note.del_status=0 order by t_material_receipt_note.mrn_no DESC",nativeQuery=true) 
	 List<GetMaterialReceiptByDate> getMaterialReceiptByDateGateEntry(@Param("status")List<String> status,@Param("fromDate") String fromDate,@Param("toDate") String toDate);
 
	@Query(value="select t_material_receipt_note.mrn_id, t_material_receipt_note.mrn_no, t_material_receipt_note.gate_entry_date,\r\n" + 
			"t_material_receipt_note.vehicle_no, t_material_receipt_note.lr_no, t_material_receipt_note.mrn_store_date, t_material_receipt_note.mrn_type,\r\n" + 
			"t_material_receipt_note.against_po, t_material_receipt_note.po_id, t_material_receipt_note.po_no, t_material_receipt_note.po_date,\r\n" + 
			"t_material_receipt_note.inv_book_date, t_material_receipt_note.invoice_number, t_material_receipt_note.basic_value, t_material_receipt_note.bill_amount,\r\n" + 
			"t_material_receipt_note.status, m_supplier.supp_name, m_transporter.tran_name from m_supplier, m_transporter, t_material_receipt_note \r\n" + 
			"where m_supplier.supp_id=t_material_receipt_note.supplier_id and m_transporter.tran_id=t_material_receipt_note.transport_id and\r\n" + 
			"t_material_receipt_note.mrn_store_date between :fromDate and :toDate and t_material_receipt_note.status in (:status)and\r\n" + 
			"t_material_receipt_note.del_status=0 order by t_material_receipt_note.mrn_no DESC",nativeQuery=true) 
	 List<GetMaterialReceiptByDate> getMaterialReceiptByDateStore(@Param("status")List<String> status,@Param("fromDate") String fromDate,@Param("toDate") String toDate);
  
	@Query(value="select \r\n" + 
			"t_material_receipt_note.mrn_id,\r\n" + 
			"t_material_receipt_note.mrn_no,\r\n" + 
			"t_material_receipt_note.gate_entry_date,\r\n" + 
			"t_material_receipt_note.vehicle_no,\r\n" + 
			"t_material_receipt_note.lr_no,\r\n" + 
			"t_material_receipt_note.mrn_store_date,\r\n" + 
			"t_material_receipt_note.mrn_type,\r\n" + 
			"t_material_receipt_note.against_po,\r\n" + 
			"t_material_receipt_note.po_id,\r\n" + 
			"t_material_receipt_note.po_no,\r\n" + 
			"t_material_receipt_note.po_date,\r\n" + 
			"t_material_receipt_note.inv_book_date,\r\n" + 
			"t_material_receipt_note.invoice_number,\r\n" + 
			"t_material_receipt_note.basic_value,\r\n" + 
			"t_material_receipt_note.bill_amount,\r\n" + 
			"t_material_receipt_note.status,\r\n" + 
			"m_supplier.supp_name,\r\n" + 
			"m_transporter.tran_name\r\n" + 
			"from\r\n" + 
			"m_supplier,\r\n" + 
			"m_transporter,\r\n" + 
			"t_material_receipt_note \r\n" + 
			"where\r\n" + 
			"m_supplier.supp_id=t_material_receipt_note.supplier_id and\r\n" + 
			"m_transporter.tran_id=t_material_receipt_note.transport_id and\r\n" + 
			"t_material_receipt_note.inv_book_date between :fromDate and :toDate\r\n" + 
			"and t_material_receipt_note.status in (:status)and\r\n" + 
			"t_material_receipt_note.del_status=0\r\n" + 
			"order by\r\n" + 
			"t_material_receipt_note.mrn_no DESC",nativeQuery=true) 
	List<GetMaterialReceiptByDate> getMaterialReceiptByDateAcc(@Param("status")List<String> status,@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	
	


}
