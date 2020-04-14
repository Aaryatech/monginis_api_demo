package com.ats.webapi.repository;

 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.CheckSuppGst;
 

public interface GetSuppGstRepository extends JpaRepository<CheckSuppGst,Integer>{
	
	@Query(value="select  m_supplier.supp_id,m_supplier.supp_gstin,t_setting.setting_key,t_setting.setting_value from m_supplier,t_setting where \r\n" + 
			"m_supplier.supp_id=:suppId and t_setting.setting_key = 'gst'",nativeQuery=true)
	CheckSuppGst checkSuppGst(@Param("suppId") int suppId);

}
