package com.ats.webapi.repo.ownapp;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.ownapp.OwnerAppUser;
import java.lang.String;

public interface OwnerAppUserRepo extends JpaRepository<OwnerAppUser, Integer> {
	
	@Query(value="SELECT * FROM m_ownerapp_usr where usr_name=:userName AND BINARY secret =BINARY (:password)",nativeQuery=true)

	OwnerAppUser getLoginInfo(@Param("userName") String userName,@Param("password") String password);
	
	OwnerAppUser  findByMobNo(String mobno);

	
	@Transactional
	@Modifying
	@Query(value="UPDATE OwnerAppUser SET devToken=:devToken WHERE ownappUsrid=:ownappUsrid")
	int updateDevToken(@Param("devToken") String devToken,@Param("ownappUsrid") int ownappUsrid);
	
	List<OwnerAppUser> findByCompId(int compId);
}
