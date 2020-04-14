package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GetTaxByRmId;


public interface GetTaxListByRmIdRepository extends JpaRepository<GetTaxByRmId, Integer>{
	
	
	@Query(value="select m_rm.rm_id,m_rm_tax.sgst_per,m_rm_tax.cgst_per,m_rm_tax.igst_per,m_rm.tax_id from m_rm,m_rm_tax where m_rm.tax_id=m_rm_tax.tax_id AND m_rm.rm_id In(:rmId)",nativeQuery=true)
	List<GetTaxByRmId> GetTaxByRmIdlist(@Param("rmId") List<String> rmId);

}
