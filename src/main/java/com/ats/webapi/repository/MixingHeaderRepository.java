package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.MixingHeader;

public interface MixingHeaderRepository extends JpaRepository<MixingHeader, Integer>{
	
	MixingHeader save(MixingHeader mixingHeader);

	@Query(value=" select * from t_mixing_header where  mix_date BETWEEN :frmdate and :todate and del_status=0",nativeQuery=true)
	List<MixingHeader> getAlllist(@Param("frmdate")String frmdate,@Param("todate")String todate);

	@Query(value=" select * from t_mixing_header where  mix_id=:mixId and del_status=0",nativeQuery=true)
	MixingHeader getBymixId(@Param("mixId")int mixId);

	
	@Transactional
	@Modifying
	@Query(" UPDATE MixingHeader SET is_bom=1,status=1 WHERE mix_id=:mixId")
	int updateisBom(@Param("mixId")int mixId);
	

}
