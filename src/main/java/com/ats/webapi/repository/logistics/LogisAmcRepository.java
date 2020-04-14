package com.ats.webapi.repository.logistics;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional; 
import com.ats.webapi.model.logistics.LogisAmc;

public interface LogisAmcRepository extends JpaRepository<LogisAmc, Integer>{

	
	@Transactional
	@Modifying
	@Query(" UPDATE LogisAmc SET del_status=1 WHERE amc_id=:amcId") 
	int deleteLogisAmc(@Param("amcId")int amcId);

	LogisAmc findByAmcId(int amcId);

	List<LogisAmc> findAllByTypeId(int typeId);

	List<LogisAmc> findAllByTypeIdAndMechId(int typeId, int mechId); 

}
