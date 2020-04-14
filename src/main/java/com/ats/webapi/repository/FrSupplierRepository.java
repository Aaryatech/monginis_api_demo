package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.FrSupplier;

public interface FrSupplierRepository extends JpaRepository<FrSupplier, Integer>{

	List<FrSupplier> findByFrIdAndDelStatus(int frId,int delStatus);

	
	@Transactional
	@Modifying
	@Query(" UPDATE FrSupplier SET del_status=1 WHERE supp_id=:suppId")
	int deleteFrSupplier(@Param("suppId")int suppId);


	FrSupplier findBySuppId(int suppId);

 

}
