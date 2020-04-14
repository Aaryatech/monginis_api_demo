package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.rawmaterial.RawMaterialDetails;

public interface RawMaterialDetailsRepository extends JpaRepository<RawMaterialDetails, Integer>{

	RawMaterialDetails save(RawMaterialDetails rawMaterialMasterDetails);
	
	RawMaterialDetails findByRmId(int rmId);
	
	List<RawMaterialDetails> findByDelStatus(int delStatus);

	@Transactional
	@Modifying
	@Query(" UPDATE RawMaterialDetails SET delStatus=1 WHERE rmId=:rmId ")
	int deleteRawMaterial(@Param("rmId") int rmId);
	
	List<RawMaterialDetails> findByGrpIdAndDelStatus(int grpId, int delStatus);

	List<RawMaterialDetails> findByCatId(int catId);



	@Transactional
	@Modifying
	@Query(" UPDATE RawMaterialDetails SET isTallySync=:isTallySync WHERE rmId=:rmId ")
	int updateRawMaterial(@Param("rmId")int rmId,@Param("isTallySync")int isTallySync);

}
