package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.webapi.model.GetUserType;

public interface GetUserTypeRepository extends JpaRepository<GetUserType, Integer>{

	

	
	@Query(value="SELECT type_id, type_name from m_emp_type where del_status=0 ",nativeQuery=true)
	List<GetUserType> getType();
}
