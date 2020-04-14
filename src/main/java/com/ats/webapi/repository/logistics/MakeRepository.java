package com.ats.webapi.repository.logistics;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.logistics.Make; 

public interface MakeRepository extends JpaRepository<Make, Integer>{
	
	
	@Transactional
	@Modifying
	@Query(" UPDATE Make SET del_status=1 WHERE make_id=:makeId")
	int deleteMake(@Param("makeId")int makeId);

	List<Make> findAllByDelStatus(int delStatus);

	Make findByMakeId(int makeId); 
}
