package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.spprod.GetSpStation;

@Repository
public interface GetSpStationRepository extends JpaRepository<GetSpStation, Integer>{

	@Query(value="Select s.st_id,s.st_name,s.st_is_used,s.dept_id,d.dept_name,s.st_location,s.del_status from m_sp_station s,m_cm_dept d where s.dept_id=d.dept_id And s.del_status=0 ",nativeQuery=true)
	List<GetSpStation> findGetSpStationByDelStatus();

}
