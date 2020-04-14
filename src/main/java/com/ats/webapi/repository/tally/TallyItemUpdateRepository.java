package com.ats.webapi.repository.tally;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.tally.Items;

@Repository
public interface TallyItemUpdateRepository extends JpaRepository<Items, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE Items i SET i.isTallySync =:isTallySync  WHERE i.id=:id")
	int updateItems(@Param("id")int id,@Param("isTallySync") int isTallySync);
	
	

}
