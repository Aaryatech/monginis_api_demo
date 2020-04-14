package com.ats.webapi.repository.tray;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.tray.GetVehDriverMobNo;

public interface GetVehDriverMobNoRepo extends JpaRepository<GetVehDriverMobNo, Integer> {
	
	@Query(value="SELECT th.veh_no,dr.driver_name,dr.mobile1,dr.mobile2,th.tran_id,th.tran_date, r.route_name FROM t_tray_mgt_header th,m_logis_driver dr,m_fr_route r " + 
			" WHERE th.drv_id=dr.driver_id AND r.route_id=th.route_id AND th.route_id=:routeId AND th.tran_date=:curDate AND th.del_status=0 ",nativeQuery=true)
	List<GetVehDriverMobNo> getVehicleAndMobNo(@Param("routeId")int routeUd,@Param("curDate")String curDate);

}
