package com.ats.webapi.repository.storestock;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.stock.GetStoreCurrentStock;

public interface GetStoreCurrentStockRepository extends JpaRepository<GetStoreCurrentStock, Integer>{

	
	@Query(value="SELECT d.store_stock_detail_id,h.store_stock_date,m_rm.rm_id,m_rm.rm_code, m_rm.rm_name,m_rm.rm_min_qty,m_rm.rm_max_qty,m_rm.rm_rol_qty,coalesce((Select SUM(t_req_bom_detail.rm_issue_qty) From t_req_bom_detail,t_req_bom where t_req_bom.approved_date=h.store_stock_date AND t_req_bom.to_dept_id=:deptId AND t_req_bom.req_id=t_req_bom_detail.req_id AND t_req_bom.status>0 AND m_rm.rm_id=t_req_bom_detail.rm_id),0) AS bms_issue_qty,coalesce((Select (SUM( t_material_receipt_note_detail.recd_qty) -SUM( t_material_receipt_note_detail.rejected_qty)) From t_material_receipt_note_detail,t_material_receipt_note where t_material_receipt_note.mrn_store_date=h.store_stock_date\r\n" + 
			"AND t_material_receipt_note.mrn_id=t_material_receipt_note_detail.mrn_id AND t_material_receipt_note.status=4 AND m_rm.rm_id=t_material_receipt_note_detail.rm_id),0)	AS pur_rec_qty,coalesce((Select t_store_stock_detail.store_opening_stock From t_store_stock_detail,	t_store_stock_header where t_store_stock_detail.store_stock_id=t_store_stock_header.store_stock_id AND	t_store_stock_header.store_stock_status=0 AND t_store_stock_detail.rm_id=m_rm.rm_id),0) AS store_opening_stock,	coalesce((Select t_store_stock_detail.store_closing_stock From t_store_stock_detail,t_store_stock_header where	t_store_stock_detail.store_stock_id=t_store_stock_header.store_stock_id AND t_store_stock_header.store_stock_status=0 AND	t_store_stock_detail.rm_id=m_rm.rm_id),0) AS store_closing_stock FROM m_rm,t_store_stock_detail d,t_store_stock_header h where m_rm.rm_id=d.rm_id AND h.store_stock_id=d.store_stock_id AND h.store_stock_status=0 GROUP by m_rm.rm_id",nativeQuery=true)
	List<GetStoreCurrentStock> getCurrentStock(@Param("deptId")int deptId);

	@Query(value="SELECT d.store_stock_detail_id,h.store_stock_date,m_item.id as rm_id,m_item.item_id as rm_code, m_item.item_name as rm_name,coalesce((select s.min_qty from m_fr_item_stock s where s.type=8 and s.item_id=m_item.id),0) as rm_min_qty,coalesce((select s.max_qty from m_fr_item_stock s where s.type=8 and s.item_id=m_item.id),0) as  rm_max_qty,coalesce((select s.reorder_qty from m_fr_item_stock s where s.type=8 and s.item_id=m_item.id),0) as  rm_rol_qty,coalesce((Select SUM(t_bill_detail.bill_qty) From t_bill_header,t_bill_detail where t_bill_header.bill_date=h.store_stock_date AND  t_bill_header.bill_no=t_bill_detail.bill_no AND t_bill_header.del_status=0 AND m_item.id=t_bill_detail.item_id),0) AS bms_issue_qty,coalesce((Select (SUM( t_material_receipt_note_detail.recd_qty) -SUM( t_material_receipt_note_detail.rejected_qty)) From t_material_receipt_note_detail,t_material_receipt_note where t_material_receipt_note.mrn_store_date=h.store_stock_date\r\n" + 
			"AND t_material_receipt_note.mrn_id=t_material_receipt_note_detail.mrn_id AND t_material_receipt_note.status=4 AND m_item.id=t_material_receipt_note_detail.rm_id),0)	AS pur_rec_qty,coalesce((Select t_store_stock_detail.store_opening_stock From t_store_stock_detail,	t_store_stock_header where t_store_stock_detail.store_stock_id=t_store_stock_header.store_stock_id AND	t_store_stock_header.store_stock_status=0 AND t_store_stock_detail.rm_id=m_item.id),0) AS store_opening_stock,	coalesce((Select t_store_stock_detail.store_closing_stock From t_store_stock_detail,t_store_stock_header where	t_store_stock_detail.store_stock_id=t_store_stock_header.store_stock_id AND t_store_stock_header.store_stock_status=0 AND	t_store_stock_detail.rm_id=m_item.id),0) AS store_closing_stock FROM m_item,t_store_stock_detail d,t_store_stock_header h where m_item.id=d.rm_id AND h.store_stock_id=d.store_stock_id AND h.store_stock_status=0 and m_item.item_grp2=:grpId GROUP by m_item.id",nativeQuery=true)
	List<GetStoreCurrentStock> getCurrentStockGrp2(@Param("grpId")int grpId);

	 
	
}
