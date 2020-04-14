package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

	
	
	@Query(value="SELECT dept_id, dept_name from m_cm_dept where del_status=0 ",nativeQuery=true)
	List<Department> getAllDept();

	
	
}
