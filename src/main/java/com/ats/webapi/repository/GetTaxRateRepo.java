package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.webapi.model.taxrate.GetTaxRate;

public interface GetTaxRateRepo extends JpaRepository<GetTaxRate, Integer> {
	
	@Query(value=" SELECT m_tax_rate.tax_rate_id " + 
			", m_tax_rate.hsn_code " + 
			", m_tax_rate.sgst_per " + 
			", m_tax_rate.cgst_per " + 
			", m_tax_rate.igst_per " + 
			" , m_rm_uom.uom," + 
			" m_cat_sub.sub_cat_name " + 
			" FROM m_tax_rate,m_rm_uom,m_cat_sub WHERE m_tax_rate.sub_cat_id=m_cat_sub.sub_cat_id AND m_tax_rate.uom=m_rm_uom.uom_id AND m_tax_rate.del_status=0 ",nativeQuery=true)

	List<GetTaxRate> getTaxRateList();

}
