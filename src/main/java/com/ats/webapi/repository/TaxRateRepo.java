package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.taxrate.TaxRate;

public interface TaxRateRepo  extends JpaRepository<TaxRate, Integer>{
	
	TaxRate save(TaxRate taxRate);
	
	List<TaxRate> findByDelStatus(int delStatus);
	
	TaxRate findByTaxRateId(int taxRateId);
	
	List<TaxRate> findBySubCatIdAndDelStatus(int subCatId,int delStaus);
;
}
