package com.ats.webapi.repository.gatesale;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.gatesale.OtherSupplier;

@Repository
public interface GateOtherSupplierRepository extends JpaRepository<OtherSupplier, Integer>{

	@Transactional
	@Modifying
	@Query("UPDATE OtherSupplier s SET s.delStatus=1  WHERE s.suppId=:suppId")
	int deleteGateOtherSupplier(@Param("suppId")int suppId);

	List<OtherSupplier> findOtherSupplierByDelStatus(int i);

	OtherSupplier findOtherSupplierBySuppId(int suppId);
	

}
