package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.spprod.GetInstVerifHeader;

@Repository
public interface GetInstVerifHeaderRepository extends JpaRepository<GetInstVerifHeader, Integer>{

	@Query(value="select h.inst_verif_h_id,h.inst_verif_date,h.user_id,u.usr_name as user_name,h.station_id,st.st_name,h.shift_id,s.shift_name,h.st_status,h.start_time,h.end_time,h.del_status from t_sp_inst_verif_h h,m_user u,m_shift s,m_sp_station st WHERE h.user_id=u.usr_id AND h.shift_id=s.shift_id AND h.station_id=st.st_id And h.del_status=0",nativeQuery=true)
	List<GetInstVerifHeader> findAllByDelStatus();



}
