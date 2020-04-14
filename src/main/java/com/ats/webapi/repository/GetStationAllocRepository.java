package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.spprod.GetStationAllocation;

@Repository
public interface GetStationAllocRepository extends JpaRepository<GetStationAllocation, Integer>{

	@Query(value="Select c.allocation_id, c.station_id, st.st_name, s.shift_id, s.shift_name, c.emp_mistry_id, c.emp_helper_id, c.del_status,(Select e1.emp_name from m_emp As e1 where e1.emp_id=c.emp_mistry_id )as emp_mistry_name,(Select e2.emp_name from m_emp As e2 where e2.emp_id=c.emp_helper_id )as emp_helper_name from m_shift s, t_prod_station_allocation c ,m_sp_station st WHERE c.del_status=0 AND c.shift_id=s.shift_id AND c.station_id=st.st_id",nativeQuery=true)
  List<GetStationAllocation> findStationAllocations();

}
