package com.ats.webapi.repository.AccessRight;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.AccessRightSubModule;

public interface AccessRightSubModuleRepository extends JpaRepository<AccessRightSubModule, String>{

	
	
	//List<AccessRightSubModule> findByIsDeleteAndModuleId(int isDelete, int moduleId);

	
	@Query(value=" SELECT * FROM m_module_sub WHERE "
			+ "is_delete =0 AND module_id=:moduleId ORDER BY order_by ASC;"
			+ "",nativeQuery=true)
	List<AccessRightSubModule> getSubModule(@Param("moduleId")int moduleId);
	
	

}
