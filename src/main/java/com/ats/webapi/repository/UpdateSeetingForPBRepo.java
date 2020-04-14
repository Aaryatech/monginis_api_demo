package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.FrItemStockConfigure;

public interface UpdateSeetingForPBRepo extends JpaRepository<FrItemStockConfigure, Integer> {
	
	
	
	
	@Transactional
	@Modifying
	@Query("UPDATE FrItemStockConfigure setting SET setting.settingValue =:settingValue  WHERE setting.settingKey=:settingKey")
	int updateSeetingForPurBill(@Param("settingValue") int settingValue,@Param("settingKey") String settingKey);

	
	@Transactional
  	@Modifying
  	@Query("UPDATE FrItemStockConfigure  SET setting_value=(setting_value)+1 where setting_key='gate_sale_invoice'")
	int updateSettingValue();

	@Transactional
  	@Modifying
  	@Query("UPDATE FrItemStockConfigure  SET setting_value=(setting_value)+1 where setting_key='sp_slip_no'")
	int updateSeetingForSlip();

}
