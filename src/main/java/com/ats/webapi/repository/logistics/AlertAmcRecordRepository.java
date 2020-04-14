package com.ats.webapi.repository.logistics;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.logistics.AlertAmcRecord; 

public interface AlertAmcRecordRepository extends JpaRepository<AlertAmcRecord, Integer>{
	
	
	 
	@Query(value="select m.machine_id as id, m.machine_name as name, d.dealer_name, m.dealer_id, m.last_amc_date, m.next_amc_date, "
			+ "m.alert_amc_date, DATEDIFF(m.next_amc_date, :today) AS remaining_day from m_logis_machine m, m_logis_dealer d "
			+ "where (( next_amc_date >= :today and alert_amc_date <= :today ) or next_amc_date < :today) and  "
			+ "d.dealer_id=m.dealer_id and m.del_status=0",nativeQuery=true)
	List<AlertAmcRecord> getAlertAmcRecord(@Param("today")String today);

	@Query(value="select m.veh_id as id, m.veh_no as name, d.dealer_name, m.dealer_id, m.last_amc_date, m.next_amc_date, "
			+ "m.alert_amc_date, DATEDIFF(m.next_amc_date, :today) AS remaining_day from m_logis_vehical m, m_logis_dealer d "
			+ "where (( next_amc_date >= :today and alert_amc_date <= :today ) or next_amc_date < :today) and "
			+ "d.dealer_id=m.dealer_id and m.del_status=0",nativeQuery=true)
	List<AlertAmcRecord> getAlertvehicleAmcRecord(@Param("today")String today);

}
