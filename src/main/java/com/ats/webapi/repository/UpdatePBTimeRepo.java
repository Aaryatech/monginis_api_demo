package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.UpdatePBDateTime;

@Repository
public interface UpdatePBTimeRepo extends JpaRepository<UpdatePBDateTime, Integer> {
	
	@Transactional
	@Modifying
	@Query("UPDATE UpdatePBDateTime pb SET pb.time =:time  WHERE pb.billNo=:billNo")
	int updateTimeForPurBill(@Param("time") String time,@Param("billNo") int  billNo);

}
