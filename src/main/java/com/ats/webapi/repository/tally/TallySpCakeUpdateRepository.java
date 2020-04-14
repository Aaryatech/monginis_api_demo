package com.ats.webapi.repository.tally;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.tally.SpCakes;

@Repository
public interface TallySpCakeUpdateRepository extends JpaRepository<SpCakes, Integer> {

	
	@Transactional
	@Modifying
	@Query("UPDATE SpCakes s SET s.isTallySync =:isTallySync  WHERE s.spId=:spId")
	int updateSpCakes(@Param("spId")int spId,@Param("isTallySync") int isTallySync);
	

}
