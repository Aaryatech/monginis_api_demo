package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.DeleteBill;

public interface DeleteBillRepository extends JpaRepository<DeleteBill, Integer> {
	
	
	
	
	@Transactional
	@Modifying
	@Query(" UPDATE DeleteBill SET delStatus=:delStatus WHERE billNo=:billNo ")
	
	
	int  deleteBill(@Param("delStatus") int delStatus,@Param("billNo") int billNo);
	

}
