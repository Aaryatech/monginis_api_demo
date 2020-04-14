package com.ats.webapi.repository.logistics;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param; 
import com.ats.webapi.model.logistics.AlertMachineServicingRecord;

public interface AlertMachineServicingRepository extends JpaRepository<AlertMachineServicingRecord, Integer>{

	@Query(value="select m.machine_id, m.machine_name, m.dealer_id, d.dealer_name,  m.last_cleaning_date, m.next_cleaning_date, "
			+ "m.next_alert_date, DATEDIFF(next_amc_date, :today) AS remaining_day from m_logis_machine m, "
			+ "m_logis_dealer d where ( ( m.next_cleaning_date >= :today and m.next_alert_date <= :today )"
			+ "or m.next_cleaning_date < :today ) and m.del_status=0 and m.dealer_id=d.dealer_id",nativeQuery=true) 
	List<AlertMachineServicingRecord> getAlertMachineServicingRecord(@Param("today")String today);

}
