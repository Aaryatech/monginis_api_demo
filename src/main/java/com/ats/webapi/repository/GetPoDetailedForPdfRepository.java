package com.ats.webapi.repository; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param; 
import com.ats.webapi.model.GetPoHeaderForPdf;

public interface GetPoDetailedForPdfRepository extends JpaRepository<GetPoHeaderForPdf, Integer>{

	
	@Query(value="select\r\n" + 
			"        ph.po_id,\r\n" + 
			"        ph.po_no,\r\n" + 
			"        ph.po_date,\r\n" + 
			"        ph.po_type,\r\n" + 
			"        sp.supp_name,\r\n" + 
			"        sp.supp_addr,\r\n" + 
			"        sp.supp_state,\r\n" + 
			"        sp.supp_gstin,\r\n" + 
			"        t.tran_name,\r\n" + 
			"        ph.quotation_ref_no,\r\n" + 
			"        ph.quotation_ref_date,\r\n" + 
			"        ph.kind_attn,\r\n" + 
			"        ph.pay_id,\r\n" + 
			"        ph.delv_at_rem,\r\n" + 
			"        ph.delv_date_rem,\r\n" + 
			"        ph.sp_rem,\r\n" + 
			"        ph.po_total_value  \r\n" + 
			"    from\r\n" + 
			"        t_purchase_order_header ph,\r\n" + 
			"        m_supplier sp,\r\n" + 
			"        m_transporter t\r\n" + 
			"    where\r\n" + 
			"        ph.po_id=:poId \r\n" + 
			"        and  ph.supp_id=sp.supp_id\r\n" + 
			"        and t.tran_id=ph.tran_id",nativeQuery=true)
	GetPoHeaderForPdf poDetailedForPdf(@Param("poId") int poId);

}
