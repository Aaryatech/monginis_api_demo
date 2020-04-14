package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.purchaseorder.PoDetailsByChkSupp;

public interface PoDetailsByChkSuppRepository extends JpaRepository<PoDetailsByChkSupp, Integer>{

	@Query(value="select :suppId as supp_id,r.rm_id, r.rm_name, r.rm_uom_id, r.rm_specification as specification, (t.cgst_per + t.sgst_per) as gst_per,0 as disc_per,1 as po_qty,\n" + 
			"t.sgst_per, t.cgst_per, t.igst_per,coalesce((select v.rate_tax_extra from m_rm_rate_verif v where v.rm_id=r.rm_id AND v.supp_id=:suppId),0) as rate_tax_extra,\n" + 
			"coalesce((select v.rate_tax_incl from m_rm_rate_verif v where v.rm_id=r.rm_id AND v.supp_id=:suppId),0) as rate_tax_incl,coalesce((select supp_email5 from m_supplier where supp_id=:suppId),0)as sch_days from m_rm r, m_rm_tax t where   r.rm_id IN (select supp_email4 from m_supplier where del_status=0 and supp_id=:suppId) AND t.tax_id=r.tax_id",nativeQuery=true)
	List<PoDetailsByChkSupp> getPoDetailsBySuppId(@Param("suppId")int suppId);

}
