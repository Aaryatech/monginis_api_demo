package com.ats.webapi.repository.gatesale;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.gatesale.GateEmployee;

@Repository
public interface GateEmployeeRepository extends JpaRepository<GateEmployee, Integer>{

	@Transactional
	@Modifying
	@Query("UPDATE GateEmployee e SET e.delStatus=1  WHERE e.empId=:empId")
	int deleteGateEmployee(@Param("empId")int empId);

}
