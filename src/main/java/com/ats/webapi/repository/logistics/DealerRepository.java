package com.ats.webapi.repository.logistics;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.logistics.Dealer;

public interface DealerRepository extends JpaRepository<Dealer, Integer>{

	
	@Transactional
	@Modifying
	@Query(" UPDATE Dealer SET del_status=1 WHERE dealer_id=:dealerId") 
	int deleteDealer(@Param("dealerId")int dealerId);

	List<Dealer> findAllByDelStatus(int delStatus);

	Dealer findByDealerId(int dealerId);

	List<Dealer> findAllByMakeIdAndDelStatus(int makeId, int delStatus);

}
