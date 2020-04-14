package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.spprod.StationAllocation;

@Repository
public interface ProdStationAllocRepository extends JpaRepository<StationAllocation, Integer>{

	@Transactional
	 @Modifying
	 @Query("UPDATE StationAllocation SET del_status=1 WHERE allocation_id=:allocationId")
	int deleteByAllocationId(@Param("allocationId")int allocationId);

	StationAllocation findStationAllocationByAllocationId(int allocationId);

}
