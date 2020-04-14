package com.ats.webapi.repository.AccessRight;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.AssignRoleDetailList;

public interface AssignRoleDetailListRepository extends JpaRepository<AssignRoleDetailList, Integer>{

	List<AssignRoleDetailList> findByDelStatus(int delStatus);

	
	@Query(value=" SELECT r.* from m_assign_role r, m_user u where u.usr_id=:usrId AND r.role_id=u.role_id",nativeQuery=true)
	AssignRoleDetailList getRoleJson(@Param("usrId")int usrId);

	@Modifying
	@Transactional
	@Query("Update AssignRoleDetailList  SET del_status=1 WHERE role_id=:roleId")
	int deleteRole(@Param("roleId")int roleId);

}
