package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.spprod.InstAllocToStation;

@Repository
public interface InstAllocToStationRepository extends JpaRepository<InstAllocToStation, Integer>{

	 @Transactional
	 @Modifying
	 @Query("UPDATE InstAllocToStation SET del_status=1 WHERE inst_alloc_id=:instAllocId")
	int deleteByInstAllocId(@Param("instAllocId")int instAllocId);


	InstAllocToStation findInstAllocToStationByInstAllocId(int instAllocId);

}
