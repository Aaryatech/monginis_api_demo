package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.spprod.GetAllocStationCk;

@Repository
public interface GetAllocStationCkRepository extends JpaRepository<GetAllocStationCk, Integer>{

	
	@Query(value="select d.sp_ck_alloc_d_id,h.station_id,st.st_name,d.t_sp_cake_id,d.sp_name,d.sp_code ,d.sp_id,d.is_bom,h.req_date from t_sp_ck_alloc_header h,t_sp_ck_alloc_detail d,m_sp_station st where h.sp_ck_alloc_id=d.sp_ck_alloc_id AND h.station_id=st.st_id AND h.req_date Between :fromDate AND :toDate AND h.station_id In(:stationId) And d.del_status=0",nativeQuery=true)
	List<GetAllocStationCk> findStationwiseAllocCk(@Param("stationId")List<String> stationId,@Param("fromDate") String fromDate,@Param("toDate") String toDate);

}
