package com.ats.webapi.repository.logistics;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.logistics.TrayManagementReport;

public interface TrayManagementReportRepository extends JpaRepository<TrayManagementReport, Integer>{

	
	@Query(value="select t.tran_id, t.tran_date, t.veh_id, t.veh_no, t.drv_id, d.driver_name, t.route_id, r.route_name, "
			+ "t.veh_running_km, t.diesel from t_tray_mgt_header t, m_fr_route r, m_logis_driver d where "
			+ "t.tran_date between :fromDate and :toDate and t.route_id=:routeId and t.route_id=r.route_id "
			+ "and t.drv_id=d.driver_id and veh_status=2",nativeQuery=true)  
	List<TrayManagementReport> getTrayManagementReportRouteWise(@Param("fromDate")String fromDate,@Param("toDate")String toDate,@Param("routeId") int routeId);
	
	@Query(value="select t.tran_id, t.tran_date, t.veh_id, t.veh_no, t.drv_id, d.driver_name, t.route_id, r.route_name, "
			+ "t.veh_running_km, t.diesel from t_tray_mgt_header t, m_fr_route r, m_logis_driver d where "
			+ "t.tran_date between :fromDate and :toDate and t.veh_id=:vehId and t.route_id=r.route_id "
			+ "and t.drv_id=d.driver_id and veh_status=2",nativeQuery=true)  
	List<TrayManagementReport> getTrayManagementReportVehId(@Param("fromDate")String fromDate,@Param("toDate")String toDate,@Param("vehId") int vehId);
	
	@Query(value="select t.tran_id, t.tran_date, t.veh_id, t.veh_no, t.drv_id, d.driver_name, t.route_id, r.route_name, "
			+ "t.veh_running_km, t.diesel from t_tray_mgt_header t, m_fr_route r, m_logis_driver d where "
			+ "t.tran_date between :fromDate and :toDate and t.route_id=:routeId and t.veh_id=:vehId and t.route_id=r.route_id "
			+ "and t.drv_id=d.driver_id and veh_status=2",nativeQuery=true)  
	List<TrayManagementReport> getTrayManagementReportRouteWiseAndVehId(@Param("fromDate")String fromDate,@Param("toDate")String toDate,@Param("routeId") int routeId,
			@Param("vehId") int vehId);

	@Query(value="select t.tran_id, t.tran_date, t.veh_id, t.veh_no, t.drv_id, d.driver_name, t.route_id, r.route_name, "
			+ "t.veh_running_km, t.diesel from  t_tray_mgt_header t, m_fr_route r, m_logis_driver d where "
			+ "t.tran_date between :fromDate and :toDate and t.route_id=r.route_id "
			+ "and t.drv_id=d.driver_id and veh_status=2",nativeQuery=true) 
	List<TrayManagementReport> getTrayManagementReport(@Param("fromDate")String fromDate,@Param("toDate")String toDate);

}
