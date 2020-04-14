package com.ats.webapi.repository.logistics;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.logistics.Variant;

public interface VariantRepository extends JpaRepository<Variant, Integer>{

	
	@Transactional
	@Modifying
	@Query(" UPDATE Variant SET del_status=1 WHERE variant_id=:variantId")
	int deleteVariant(@Param("variantId")int variantId);

	List<Variant> findAllByDelStatus(int delStatus);

	Variant findByVariantId(int variantId);

	List<Variant> findAllByMakeIdAndVehTypeIdAndDelStatus(int makeId, int typeId, int delStatus); 
	

}
