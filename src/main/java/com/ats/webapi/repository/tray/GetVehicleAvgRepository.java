package com.ats.webapi.repository.tray;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.tray.GetVehicleAvg;

@Repository
public interface GetVehicleAvgRepository extends JpaRepository<GetVehicleAvg, Integer> {

	@Query(value = "select h.tran_id, h.tran_date,h.veh_id,h.is_same_day,h.drv_id,d.driver_name,h.route_id,r.route_name,"
			+ "h.veh_no,h.veh_outtime,h.veh_intime,h.veh_outkm,h.veh_inkm,h.veh_running_km,h.diesel,h.veh_status,"
			+ "v.veh_comp_avg,v.veh_stand_avg,v.veh_mini_avg,h.del_status,h.extra_tray_out, h.extra_tray_in, h.veh_is_regular"
			+ " from t_tray_mgt_header h,m_fr_route r,m_logis_driver d,m_logis_vehical v where h.del_status=0 "
			+ "And h.drv_id=d.driver_id And v.veh_id=h.veh_id And  h.route_id=r.route_id And h.tran_date=:date "
			+ "order by h.tran_id DESC", nativeQuery = true)
	List<GetVehicleAvg> getAllTrayHeadersByDate(@Param("date") String date);

	@Query(value = " select h.tran_id, h.tran_date,h.veh_id,h.is_same_day,h.drv_id,d.driver_name,h.route_id,r.route_name,"
			+ "h.veh_no,h.veh_outtime,h.veh_intime,h.veh_outkm,h.veh_inkm,SUM(h.veh_running_km) AS veh_running_km,SUM(h.diesel)"
			+ " AS diesel,h.veh_status,v.veh_comp_avg,v.veh_stand_avg,v.veh_mini_avg,h.del_status,h.extra_tray_out, "
			+ "h.extra_tray_in, h.veh_is_regular from t_tray_mgt_header h,m_fr_route r,m_logis_driver d,m_logis_vehical "
			+ "v where h.del_status=0 And h.drv_id=d.driver_id And v.veh_id=h.veh_id And  h.route_id=r.route_id And h.tran_date"
			+ " BETWEEN :fromDate AND :toDate GROUP BY h.veh_id", nativeQuery = true)
	List<GetVehicleAvg> getAllTrayHeadersBetDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = " select h.tran_id, h.tran_date,h.veh_id,h.is_same_day,h.drv_id,d.driver_name,h.route_id,r.route_name,"
			+ "h.veh_no,h.veh_outtime,h.veh_intime,h.veh_outkm,h.veh_inkm,h.veh_running_km  ,h.diesel ,h.veh_status,"
			+ "v.veh_comp_avg,v.veh_stand_avg,v.veh_mini_avg,h.del_status,h.extra_tray_out, h.extra_tray_in, "
			+ "h.veh_is_regular from t_tray_mgt_header h,m_fr_route r,m_logis_driver d,m_logis_vehical v where h.del_status=0"
			+ " And h.drv_id=d.driver_id And v.veh_id=h.veh_id And  h.route_id=r.route_id And h.tran_date BETWEEN  :fromDate "
			+ "AND :toDate and  h.veh_id=:vehId", nativeQuery = true)
	List<GetVehicleAvg> getAllTrayHeadersBetDateANdVehId(@Param("vehId") int vehId, @Param("fromDate") String fromDate,
			@Param("toDate") String toDate);

}
