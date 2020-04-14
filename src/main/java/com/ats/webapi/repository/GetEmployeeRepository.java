package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.spprod.GetEmployee;

@Repository
public interface GetEmployeeRepository extends JpaRepository<GetEmployee, Integer>{

	@Query(value="Select e.emp_id ,e.emp_name,e.emp_type,e.dept_id,d.dept_name,e.emp_mobile,\n" + 
			"  e.emp_dob,\n" + 
			"  e.emp_doj,\n" + 
			"  e.emp_fam_memb,\n" + 
			"  e.disc_id as discount_id,g.discount_head,\n" + 
			"  e.monthly_limit,\n" + 
			" e.yearly_limit,e.is_used,e.del_status,t.type_name from m_emp e,m_cm_dept d ,m_emp_type t,m_gatesale_discount g where g.discount_id=e.disc_id And e.dept_id=d.dept_id AND t.type_id=e.emp_type AND  e.del_status=0 And t.sub_type=:empType",nativeQuery=true)
	List<GetEmployee> findGetEmployeeByDelStatus(@Param("empType")int empType);


}
