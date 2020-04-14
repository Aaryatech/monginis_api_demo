package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.spprod.GetInstAllocToStation;

@Repository
public interface GetInstAllocToStRepository extends JpaRepository<GetInstAllocToStation, Integer>{

	@Query(value="Select i.inst_alloc_id,i.st_id,s.st_name,i.inst_id,i.del_status from t_sp_inst_alloc i,m_sp_station s WHERE i.del_status=0 AND i.st_id=s.st_id",nativeQuery=true)
	List<GetInstAllocToStation> findInstAllocToStationByDelStatus();

}
