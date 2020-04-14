package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GetPoDetailedForPdf; 

public interface GetPoDetailedPdfRepository extends JpaRepository<GetPoDetailedForPdf, Integer>{
	
	
/*	@Query(value="select \r\n" + 
			"p.po_detail_id,\r\n" + 
			"p.rm_id,\r\n" + 
			"p.rm_name, \r\n" + 
			"p.po_qty,\r\n" + 
			"p.po_rate,\r\n" + 
			"p.disc_per,\r\n" + 
			"p.po_taxable,\r\n" + 
			"ru.uom,\r\n" + 
			"rm.rm_clo_qty\r\n" + 
			"from \r\n" + 
			"t_purchase_order_detail p,\r\n" + 
			"m_rm_uom ru,\r\n" + 
			"m_rm rm\r\n" + 
			"where\r\n" + 
			"p.po_id=:poId\r\n" + 
			"and ru.uom_id=p.rm_uom_id\r\n" + 
			"and rm.rm_id=p.rm_id",nativeQuery=true)*/
	
	@Query(value="select p.po_detail_id,p.rm_id,p.rm_name, p.po_qty,p.po_rate,p.disc_per,p.po_taxable,ru.uom,tax.tax_desc as rm_clo_qty from \r\n" + 
			"	t_purchase_order_detail p,m_rm_uom ru,m_rm rm,m_rm_tax tax where p.po_id=:poId and ru.uom_id=p.rm_uom_id\r\n" + 
			"	and rm.tax_id=tax.tax_id and rm.rm_id=p.rm_id",nativeQuery=true)
	List<GetPoDetailedForPdf> purchaseOrderDetaillist(@Param("poId")int poId);

}
