package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.spprod.SpStation;

@Repository
public interface SpStationRepository extends JpaRepository<SpStation, Integer>{

	SpStation findSpStationByStId(int stId);

	 @Transactional
	 @Modifying
	 @Query("UPDATE SpStation SET del_status=1 WHERE st_id=:spId")
    	int deleteBySpId(@Param("spId")int spId);

}
