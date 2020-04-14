package com.ats.webapi.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.spprod.MDept;

@Repository
public interface MDeptRepository extends JpaRepository<MDept, Integer>{
	
	public MDept save(MDept mDept);

	public List<MDept> findMDeptByDelStatus(int delStatus);

	 @Transactional
	 @Modifying
	 @Query("UPDATE MDept SET del_status=1 WHERE dept_id=:deptId")
	 public int deleteById(@Param("deptId")int deptId);

	public MDept findMDeptByDeptId( int deptId);

	
}
