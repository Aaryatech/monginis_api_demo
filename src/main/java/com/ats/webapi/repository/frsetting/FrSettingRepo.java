package com.ats.webapi.repository.frsetting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.frsetting.FrSetting;

public interface FrSettingRepo extends JpaRepository<FrSetting, Integer> {
	
	
	FrSetting findByFrId(int frId);
	
	FrSetting save(FrSetting setting);
	
	
	
	@Transactional
	@Modifying
	@Query(" UPDATE FrSetting  SET sellBillNo=:sellBillNo "
			+ " WHERE frId=:frId ")
		int updateFrSettingBillNo(@Param("sellBillNo") 
		int sellBillNo,@Param("frId") int frId);
	
	@Transactional
	@Modifying
	@Query(" UPDATE FrSetting  SET grnGvnNo=:grnGvnNo "
			+ " WHERE frId=:frId ")
		int updateFrSettingGrnGvnNo(@Param("grnGvnNo") 
		int grnGvnNo,@Param("frId") int frId);
	@Transactional
	@Modifying
	@Query(" UPDATE FrSetting  SET ex_int=(ex_int+1) "
			+ " WHERE frId=:frId ")
	int updateFrSettingSpNo(@Param("frId") int frId);

}
