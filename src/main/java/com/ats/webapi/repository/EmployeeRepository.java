package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.spprod.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	Employee findEmployeeByEmpId(int empId);

	 @Transactional
	 @Modifying
	 @Query("UPDATE Employee SET del_status=1 WHERE emp_id=:empId")
	 int deleteByEmpId(@Param("empId")int empId);

	List<Employee> findEmployeeByEmpTypeAndDelStatus(int empType,int delStatus);

}
