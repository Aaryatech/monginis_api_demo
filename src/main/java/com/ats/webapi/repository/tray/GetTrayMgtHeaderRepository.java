package com.ats.webapi.repository.tray;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.tray.GetTrayMgtHeader;

@Repository
public interface GetTrayMgtHeaderRepository extends JpaRepository<GetTrayMgtHeader, Integer>{


	/*@Query(value="select h.tran_id, h.tran_date,h.veh_id,h.drv_id,d.driver_name,h.is_same_day,h.route_id,r.route_name,h.veh_no,h.veh_outtime,h.veh_intime,h.veh_outkm,h.veh_inkm,h.veh_running_km,h.diesel,h.veh_status,h.del_status,h.extra_tray_out, h.extra_tray_in, h.veh_is_regular from t_tray_mgt_header h,m_fr_route r,m_logis_driver d where h.del_status=0 And h.drv_id=d.driver_id And h.route_id=r.route_id And h.tran_date=:date And h.veh_status=:vehStatus",nativeQuery=true)
	List<GetTrayMgtHeader> getLoadedVehicles(@Param("date")String date,@Param("vehStatus")int vehStatus);*/
	
	@Query(value="select h.tran_id, h.tran_date,h.veh_id,h.drv_id,d.driver_name,h.is_same_day,h.route_id,r.route_name,h.veh_no,h.veh_outtime,h.veh_intime,h.veh_outkm,h.veh_inkm,h.veh_running_km,h.diesel,h.veh_status,h.del_status,h.extra_tray_out, h.extra_tray_in, h.veh_is_regular from t_tray_mgt_header h,m_route_tray_mgmt r,m_logis_driver d where h.del_status=0 And h.drv_id=d.driver_id And h.route_id=r.route_tray_id And h.tran_date=:date And h.veh_status=:vehStatus",nativeQuery=true)
	List<GetTrayMgtHeader> getLoadedVehicles(@Param("date")String date,@Param("vehStatus")int vehStatus);
	
	/*@Query(value="select\n" + 
			"  h.tran_id,\n" + 
			"  h.tran_date,\n" + 
			"  h.veh_id,\n" + 
			"  h.drv_id,d.driver_name,\n" + 
			"  h.route_id,r.route_name,\n" + 
			"  h.veh_no,\n" + 
			"  h.veh_outtime,\n" + 
			"  h.veh_intime,\n" + 
			"  h.veh_outkm,\n" + 
			"  h.veh_inkm,\n" + 
			"  h.veh_running_km,\n" + 
			"  h.diesel,\n" + 
			"  h.veh_status,\n" + 
			"  h.del_status,\n" + 
			"  h.extra_tray_out,\n" + 
			"  h.extra_tray_in,\n" + 
			"  h.veh_is_regular"
			+ "h.is_same_day from t_tray_mgt_header h,m_fr_route r,m_logis_driver d where h.del_status=0 And h.drv_id=d.driver_id And h.route_id=r.route_id And h.tran_id=:tranId",nativeQuery=true)
	GetTrayMgtHeader getTrayMgtHeader(@Param("tranId")int tranId);*/
	
	
	
	
	@Query(value="select\n" + 
			"  h.tran_id,\n" + 
			"  h.tran_date,\n" + 
			"  h.veh_id,\n" + 
			"  h.drv_id,d.driver_name,\n" + 
			"  h.route_id,r.route_name,\n" + 
			"  h.veh_no,\n" + 
			"  h.veh_outtime,\n" + 
			"  h.veh_intime,\n" + 
			"  h.veh_outkm,\n" + 
			"  h.veh_inkm,\n" + 
			"  h.veh_running_km,\n" + 
			"  h.diesel,\n" + 
			"  h.veh_status,\n" + 
			"  h.del_status,\n" + 
			"  h.extra_tray_out,\n" + 
			"  h.extra_tray_in,\n" + 
			"  h.veh_is_regular,"
			+ "h.is_same_day from t_tray_mgt_header h,m_route_tray_mgmt r,m_logis_driver d where h.del_status=0 And h.drv_id=d.driver_id And h.route_id=r.route_tray_id And h.tran_id=:tranId",nativeQuery=true)
	GetTrayMgtHeader getTrayMgtHeader(@Param("tranId")int tranId);
	
	
	
	@Query(value="select\n" + 
			"  h.tran_id,\n" + 
			"  h.tran_date,\n" + 
			"  h.veh_id,\n" + 
			"  h.drv_id,d.driver_name,\n" + 
			"  h.route_id,r.route_name,\n" + 
			"  h.veh_no,\n" + 
			"  h.veh_outtime,\n" + 
			"  h.veh_intime,\n" + 
			"  h.veh_outkm,\n" + 
			"  h.veh_inkm,\n" + 
			"  h.veh_running_km,\n" + 
			"  h.diesel,\n" + 
			"  h.veh_status,\n" + 
			"  h.del_status,\n" + 
			"  h.extra_tray_out,\n" + 
			"  h.extra_tray_in,\n" + 
			"  h.veh_is_regular,"
			+ "h.is_same_day from t_tray_mgt_header h,m_route_tray_mgmt r,m_logis_driver d where h.del_status=0 And h.drv_id=d.driver_id And h.route_id=r.route_tray_id And h.route_id=:routeId AND h.veh_status=1",nativeQuery=true)
	List<GetTrayMgtHeader> getTrayMgtHeaderByRouteId(@Param("routeId")int routeId);

	@Query(value="select h.tran_id, h.tran_date,h.veh_id,h.is_same_day,h.drv_id,d.driver_name,h.route_id,r.route_name,h.veh_no,h.veh_outtime,h.veh_intime,h.veh_outkm,h.veh_inkm,h.veh_running_km,h.diesel,h.veh_status,h.del_status,h.extra_tray_out, h.extra_tray_in, h.veh_is_regular from t_tray_mgt_header h,m_route_tray_mgmt r,m_logis_driver d where h.del_status=0 And h.drv_id=d.driver_id And h.route_id=r.route_tray_id And h.tran_date=:date order by h.tran_id DESC",nativeQuery=true)
	List<GetTrayMgtHeader> getAllVehicles(@Param("date")String date);
	
	/*@Query(value="select h.tran_id, h.tran_date,h.veh_id,h.is_same_day,h.drv_id,d.driver_name,h.route_id,r.route_name,h.veh_no,h.veh_outtime,h.veh_intime,h.veh_outkm,h.veh_inkm,h.veh_running_km,h.diesel,h.veh_status,h.del_status,h.extra_tray_out, h.extra_tray_in, h.veh_is_regular from t_tray_mgt_header h,m_fr_route r,m_logis_driver d where h.del_status=0 And h.drv_id=d.driver_id And h.route_id=r.route_id And h.tran_date=:date order by h.tran_id DESC",nativeQuery=true)
	List<GetTrayMgtHeader> getAllVehicles(@Param("date")String date);*/

	@Query(value="select h.tran_id, h.tran_date,h.veh_id,h.drv_id,h.is_same_day,d.driver_name,h.route_id,r.route_name,h.veh_no,h.veh_outtime,h.veh_intime,h.veh_outkm,h.veh_inkm,h.veh_running_km,h.diesel,h.veh_status,h.del_status,h.extra_tray_out, h.extra_tray_in, h.veh_is_regular from t_tray_mgt_header h,m_route_tray_mgmt r,m_logis_driver d where h.del_status=0 And h.drv_id=d.driver_id And h.route_id=r.route_tray_id  And h.veh_status=:vehStatus order by h.tran_id DESC",nativeQuery=true)
	List<GetTrayMgtHeader> getLoadedVehiclesByStatus(@Param("vehStatus")int vehStatus);
	
	
	/*@Query(value="select h.tran_id, h.tran_date,h.veh_id,h.drv_id,h.is_same_day,d.driver_name,h.route_id,r.route_name,h.veh_no,h.veh_outtime,h.veh_intime,h.veh_outkm,h.veh_inkm,h.veh_running_km,h.diesel,h.veh_status,h.del_status,h.extra_tray_out, h.extra_tray_in, h.veh_is_regular from t_tray_mgt_header h,m_fr_route r,m_logis_driver d where h.del_status=0 And h.drv_id=d.driver_id And h.route_id=r.route_id  And h.veh_status=:vehStatus order by h.tran_id DESC",nativeQuery=true)
	List<GetTrayMgtHeader> getLoadedVehiclesByStatus(@Param("vehStatus")int vehStatus);*/


	
}
