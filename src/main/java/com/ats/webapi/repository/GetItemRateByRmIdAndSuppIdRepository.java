package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GetItemRateByRmIdAndSuppId; 

public interface GetItemRateByRmIdAndSuppIdRepository extends JpaRepository< GetItemRateByRmIdAndSuppId, Integer> {

	@Query(value = "select v.rm_rate_ver_id as rate_id, v.rm_id, r.rm_name, v.rate_tax_extra as rate, v.supp_id "
			+ "from m_rm_rate_verif v, m_rm r where v.rm_id in (:rmId) AND v.supp_id=:suppId and v.rm_id=r.rm_id", nativeQuery = true)
	 List<GetItemRateByRmIdAndSuppId> getRateByRmId(@Param("rmId") List<String> rmId,@Param("suppId") int suppId);

}
