package com.ats.webapi.repository.logistics;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.logistics.AlertAmcRecord;
import com.ats.webapi.model.logistics.DriverMaster;

public interface DriverMasterRepository extends JpaRepository<DriverMaster, Integer>{

	
	@Transactional
	@Modifying
	@Query(" UPDATE DriverMaster SET del_status=1 WHERE driver_id=:driverId")
	int deleteDriverMaster(@Param("driverId")int driverId);
 
	List<DriverMaster> findAllByDelStatus(int delStatus);


	DriverMaster findByDriverIdAndDelStatus(int driverId, int delStatus);

	
	@Query(value="select * from m_logis_driver where lic_expire_date < :today and del_status=0",nativeQuery=true) 
	List<DriverMaster> getAlertDriverRecord(@Param("today")String today);

	DriverMaster findByString1AndString2AndDelStatus(String userName, String password, int i); 

}
