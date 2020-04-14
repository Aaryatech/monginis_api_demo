package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.MixingDetailed;


public interface MixingDetailedRepository extends JpaRepository<MixingDetailed, Integer>{
	
	MixingDetailed save(MixingDetailed mixingDetailed);

	
	@Query(value=" select * from t_mixing_detail where mixing_id=:mixId",nativeQuery=true)
	List<MixingDetailed> gemixdetailedListById(@Param("mixId")int mixId);
	
	

}
