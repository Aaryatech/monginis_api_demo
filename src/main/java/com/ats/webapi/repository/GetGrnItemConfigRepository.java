package com.ats.webapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GetGrnItemConfig;

public interface GetGrnItemConfigRepository extends JpaRepository<GetGrnItemConfig, Integer> {
	
	
    
	@Query(value = "SELECT t_bill_header.bill_no,t_bill_header.bill_date_time," + 
			"t_bill_header.bill_date,t_bill_detail.item_id,m_item.item_name,t_bill_detail.grn_type," + 
			"t_bill_detail.rate,t_bill_detail.mrp,t_bill_detail.bill_qty,t_bill_detail.bill_detail_no," + 
			"t_bill_detail.bill_no,t_bill_detail.sgst_per,t_bill_detail.cgst_per,t_bill_detail.igst_per,t_bill_detail.cess_per,"
			+ "t_bill_detail.cat_id,t_bill_detail.menu_id,t_bill_detail.disc_per,t_bill_detail.hsn_code," + 
			"t_bill_header.fr_id,t_bill_header.invoice_no FROM t_bill_header ,t_bill_detail,m_item " + 
			" WHERE t_bill_header.fr_id=:frId AND t_bill_detail.bill_no=t_bill_header.bill_no AND t_bill_header.status=2 " + 
			"AND t_bill_detail.item_id=m_item.id AND t_bill_detail.grn_type !=3 AND "
			+ "t_bill_detail.expiry_date=:cDate AND t_bill_detail.is_grngvn_applied=0", nativeQuery = true)
	
	public List<GetGrnItemConfig> getAllGrnItemConfig(@Param("cDate") String cDate,@Param("frId") int frId);

	//21 March Front End Manual GRN
	/*@Query(value = "SELECT t_bill_header.bill_no,t_bill_header.bill_date_time," + 
			"			t_bill_header.bill_date,t_bill_detail.item_id,m_item.item_name,m_item.item_grp2,t_bill_detail.grn_type," + 
			"			t_bill_detail.rate,t_bill_detail.mrp,t_bill_detail.bill_qty,t_bill_detail.bill_detail_no," + 
			"			t_bill_detail.bill_no,t_bill_detail.sgst_per,t_bill_detail.cgst_per,t_bill_detail.igst_per," + 
			"			t_bill_detail.cat_id,t_bill_detail.menu_id, " + 
			"			t_bill_header.fr_id,t_bill_header.invoice_no FROM t_bill_header ,t_bill_detail,m_item " + 
			"			WHERE t_bill_header.fr_id=:frId AND t_bill_detail.bill_no=t_bill_header.bill_no AND t_bill_header.status=2 " + 
			" AND m_item.item_grp2 IN(15,16) " + 
			" AND t_bill_detail.item_id=m_item.id AND t_bill_detail.grn_type !=3 AND " + 
			" t_bill_detail.bill_no=:billNo ", nativeQuery = true)
	
	public List<GetGrnItemConfig> getItemForManGrn(@Param("billNo")int billNo,@Param("frId") int frId);

	*/
	
	@Query(value = "SELECT t_bill_header.bill_no,t_bill_header.bill_date_time," + 
			"			t_bill_header.bill_date,t_bill_detail.item_id,m_item.item_name,m_item.item_grp2,t_bill_detail.grn_type," + 
			"			round(t_bill_detail.base_rate,2) as rate,t_bill_detail.mrp,t_bill_detail.bill_qty,t_bill_detail.bill_detail_no," + 
			"			t_bill_detail.bill_no,t_bill_detail.sgst_per,t_bill_detail.cgst_per,t_bill_detail.igst_per,t_bill_detail.cess_per," + 
			"			t_bill_detail.cat_id,t_bill_detail.menu_id,t_bill_detail.disc_per,t_bill_detail.hsn_code," + 
			"			t_bill_header.fr_id,t_bill_header.invoice_no FROM t_bill_header ,t_bill_detail,m_item " + 
			"			WHERE t_bill_header.fr_id=:frId AND t_bill_detail.bill_no=t_bill_header.bill_no AND t_bill_header.status=2 " + 
			" AND t_bill_detail.item_id=m_item.id AND t_bill_detail.grn_type !=3 AND " + 
			" t_bill_detail.bill_no=:billNo ", nativeQuery = true)
	
	public List<GetGrnItemConfig> getItemForManGrn(@Param("billNo")int billNo,@Param("frId") int frId);

	
	
	
	@Query(value = "SELECT t_bill_header.bill_no,t_bill_header.bill_no as autoGrnQty,t_bill_header.bill_date,t_bill_header.bill_date_time,t_bill_detail.item_id,"
			+ " CASE WHEN t_bill_detail.cat_id=5 THEN s.sp_name \n" + 
			" ELSE  m_item.item_name END AS item_name,\n" + 
			"			 t_bill_detail.grn_type,t_bill_detail.rate,t_bill_detail.mrp,t_bill_detail.bill_qty,t_bill_detail.bill_detail_no,\n" + 
			"				t_bill_detail.bill_no,t_bill_detail.sgst_per,t_bill_detail.cgst_per,t_bill_detail.cess_per," + 
			"			 t_bill_detail.igst_per,t_bill_header.fr_id,t_bill_header.invoice_no,\n" + 
			"			 t_bill_detail.cat_id,t_bill_detail.menu_id ,t_bill_detail.disc_per,t_bill_detail.hsn_code" + 
			"			FROM t_bill_header ,t_bill_detail,m_item ,m_sp_cake s\n" + 
			"				 WHERE t_bill_detail.bill_no=:billNo AND t_bill_header.bill_no=t_bill_detail.bill_no AND t_bill_header.status=2 \n" + 
			"			AND CASE WHEN t_bill_detail.cat_id=5 THEN t_bill_detail.item_id=s.sp_id ELSE\n" + 
			" t_bill_detail.item_id=m_item.id END  AND t_bill_detail.is_grngvn_applied=0 group by  t_bill_detail.bill_detail_no" + "", nativeQuery = true)
	
	public List<GetGrnItemConfig> getGvnItemConfig(@Param("billNo") int billNo);
	
	
	
}
