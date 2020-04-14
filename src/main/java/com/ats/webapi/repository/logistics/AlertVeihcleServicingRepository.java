package com.ats.webapi.repository.logistics;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.logistics.AlertMachineServicingRecord;
import com.ats.webapi.model.logistics.AlertVeihcleServicing;

public interface AlertVeihcleServicingRepository extends JpaRepository<AlertVeihcleServicing, Integer>{

	AlertVeihcleServicing findByVehIdAndTypeId(int vehId, int typeId);

	
	@Query(value="select s.alert_id, s.veh_id, s.veh_no, s.type_name, s.last_serv_km, s.next_serv_km, s.alert_serv_km, "
			+ "v.current_running_km as type_id from m_logis_alert_vehicle_servicing s, m_logis_vehical v where "
			+ "(s.alert_serv_km <= v.current_running_km or s.next_serv_km<v.current_running_km) "
			+ "and s.veh_id=v.veh_id ",nativeQuery=true)  
	List<AlertVeihcleServicing> getAlertVeihcleServicingRecord();

}
