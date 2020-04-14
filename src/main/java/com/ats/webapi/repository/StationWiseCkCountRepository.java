package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.spprod.StationWiseCkCount;

@Repository
public interface StationWiseCkCountRepository extends JpaRepository<StationWiseCkCount, Integer>
{
    @Query(value="select t_sp_ck_alloc_header.station_id,m_sp_station.st_name, coalesce(SUM((Select COUNT(t_sp_ck_alloc_detail.sp_ck_alloc_id) From t_sp_ck_alloc_detail where t_sp_ck_alloc_header.sp_ck_alloc_id=t_sp_ck_alloc_detail.sp_ck_alloc_id AND t_sp_ck_alloc_detail.status=1)),0) AS comp_qty,coalesce(SUM((Select COUNT(t_sp_ck_alloc_detail.sp_ck_alloc_id) From t_sp_ck_alloc_detail where t_sp_ck_alloc_header.sp_ck_alloc_id=t_sp_ck_alloc_detail.sp_ck_alloc_id)),0) AS tot_qty FROM t_sp_ck_alloc_header,m_sp_station WHERE t_sp_ck_alloc_header.req_date=:currentDate AND t_sp_ck_alloc_header.station_id=m_sp_station.st_id GROUP BY m_sp_station.st_id",nativeQuery=true)
	List<StationWiseCkCount> findStationwiseCkCount(@Param("currentDate")String currentDate);

}
