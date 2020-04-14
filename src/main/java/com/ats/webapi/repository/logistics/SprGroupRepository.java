package com.ats.webapi.repository.logistics;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.logistics.SprGroup;

public interface SprGroupRepository extends JpaRepository<SprGroup, Integer>{

	List<SprGroup> findAllByDelStatus(int Delstatus);

	
	@Transactional
	@Modifying
	@Query(" UPDATE SprGroup SET del_status=1 WHERE group_id=:groupId") 
	int deleteSprGroup(@Param("groupId")int groupId);


	SprGroup findByGroupId(int groupId);


	List<SprGroup> findAllByTypeIdAndDelStatus(int typeId, int delStatus); 

}
