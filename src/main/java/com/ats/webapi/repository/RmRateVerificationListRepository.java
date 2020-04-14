package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.RmRateVerificationList;

public interface RmRateVerificationListRepository extends JpaRepository<RmRateVerificationList, Integer> {
	

	@Query(value="select rv.rm_rate_ver_id,\r\n" + 
			"rv.rm_id,\r\n" + 
			"rv.supp_id,\r\n" + 
			"sp.supp_name,\r\n" + 
			"rm.rm_name\r\n" + 
			"from \r\n" + 
			"m_rm_rate_verif rv,\r\n" + 
			"m_supplier sp,\r\n" + 
			"m_rm rm\r\n" + 
			"where \r\n" + 
			"rv.supp_id in (:suppId) \r\n" + 
			"and rv.rm_id in (:rmId)\r\n" + 
			"and sp.supp_id=rv.supp_id\r\n" + 
			"and rv.rm_id=rm.rm_id",nativeQuery=true)
	List<RmRateVerificationList> rmRateVerificationList(@Param("suppId")List<String> suppId,@Param("rmId")List<String> rmId);
}
