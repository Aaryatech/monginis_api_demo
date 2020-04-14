package com.ats.webapi.repository.logistics;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.logistics.AlertAmcRecord;
import com.ats.webapi.model.logistics.VehicleDcoument;

public interface VehicleDcoumentRepository extends JpaRepository<VehicleDcoument, Integer>{

	
	@Transactional
	@Modifying
	@Query(" UPDATE VehicleDcoument SET del_status=1 WHERE veh_doc_id=:vehDocId")
	int deleteVehicleDcoument(@Param("vehDocId")int vehDocId);

	List<VehicleDcoument> findByDelStatus(int delStatus);

	VehicleDcoument findByVehDocId(int vehDocId);

	
	@Query(value="select veh_doc_id, veh_id, doc_id, entry_date, doc_date, doc_expire_date, doc_exp_notification_date, doc_path, "
			+ "current_km, del_status, DATEDIFF(doc_expire_date, :today) AS remaining_day from m_logis_veh_doc"
			+ " where ( doc_expire_date >= :today and doc_exp_notification_date <= :today ) "
			+ "or doc_exp_notification_date < :today",nativeQuery=true) 
	List<VehicleDcoument> getAlertDocumentRecord(@Param("today")String today);

}
