package com.ats.webapi.repository.logistics;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.logistics.SparePart;

public interface SparePartRepository extends JpaRepository<SparePart, Integer>{

	
	@Transactional
	@Modifying
	@Query(" UPDATE SparePart SET del_status=1 WHERE spr_id=:sprId") 
	int deleteSparePart(@Param("sprId")int sprId);

	List<SparePart> findAllByDelStatus(int delStatus);

	SparePart findBySprId(int sprId);

	List<SparePart> findAllByGroupIdAndDelStatus(int groupId, int delStatus); 

}
