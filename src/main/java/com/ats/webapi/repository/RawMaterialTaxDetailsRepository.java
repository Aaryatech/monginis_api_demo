package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.rawmaterial.RawMaterialTaxDetails;

public interface RawMaterialTaxDetailsRepository extends JpaRepository<RawMaterialTaxDetails, Integer>{
	
	List<RawMaterialTaxDetails> findAll();
	
	RawMaterialTaxDetails save(RawMaterialTaxDetails rawMaterialTaxDetails);

	List<RawMaterialTaxDetails> findAllByDelStatus(int i);

	RawMaterialTaxDetails findByTaxId(int taxId);

	 
	@Transactional
    @Modifying
    @Query("UPDATE RawMaterialTaxDetails SET del_status=1 WHERE tax_id=:taxId")
	int deleteRmTax(@Param("taxId")int taxId);

}
