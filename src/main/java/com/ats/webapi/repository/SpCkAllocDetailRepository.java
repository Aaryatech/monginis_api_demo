package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.spprod.SpCkAllocDetail;

@Repository
public interface SpCkAllocDetailRepository extends JpaRepository<SpCkAllocDetail, Integer>{

	 @Transactional
	 @Modifying
	 @Query("UPDATE SpCkAllocDetail SET is_bom=1 WHERE sp_ck_alloc_d_id=:spCkAllocDId")
	int updateIsBomOfSpAlloc(@Param("spCkAllocDId")int spCkAllocDId);

}
