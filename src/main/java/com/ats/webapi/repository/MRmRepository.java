package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.MRm;

public interface MRmRepository extends JpaRepository<MRm, Integer>{
	
	@Query(value="select rm_id, rm_name, rm_rate from m_rm where rm_id=:rmId and del_status=0",nativeQuery=true)
	public List<MRm> getList(@Param("rmId")int rmId);

}
