package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.rawmaterial.RmRateVerification;

public interface RmRateVerificationRepository extends JpaRepository<RmRateVerification, Integer>{
	
	@Query(value=" select r.* from m_rm_rate_verif r where supp_id=:suppId AND rm_id=:rmId and grp_id=:grpId",nativeQuery=true)
	RmRateVerification getRmTaxVer(@Param("suppId") int suppId,@Param("rmId") int rmId,@Param("grpId") int grpId);
	
	RmRateVerification save(RmRateVerification rmRateVerification);

	@Query(value=" select tax_id from m_rm where rm_id=:rmId",nativeQuery=true)
	int getTaxId(@Param("rmId")int rmId);

}
