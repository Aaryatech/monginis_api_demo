package com.ats.webapi.repository.logistics;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.logistics.VehicalMaster;

public interface VehicalMasterRepository  extends JpaRepository<VehicalMaster, Integer>{

	
	@Transactional
	@Modifying
	@Query(" UPDATE VehicalMaster SET del_status=1 WHERE veh_id=:vehicalId")
	int deleteVehicalMaster(@Param("vehicalId")int vehicalId);

	List<VehicalMaster> findByDelStatus(int delStatus);

	VehicalMaster findByVehId(int vehicalId);

	/*@Query(value="select amc_id,mech_name,mech_id,dealer_name,dealer_id,type_id,amc_from_date,amc_to_date,amc_alert_date,DATEDIFF(amc_to_date,:today) AS remaining_day "
			+ "from m_logis_amc where (amc_to_date >= :today and amc_alert_date <= :today) or amc_to_date < :today",nativeQuery=true)
	List<VehicalMaster> getAlertVehicleRecord(); */

}
