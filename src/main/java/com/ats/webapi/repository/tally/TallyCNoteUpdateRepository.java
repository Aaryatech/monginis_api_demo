package com.ats.webapi.repository.tally;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.tally.CreditNotes;

@Repository
public interface TallyCNoteUpdateRepository extends JpaRepository<CreditNotes, Integer>{

	
	
	@Transactional
	@Modifying
	@Query("UPDATE CreditNotes c SET c.isTallySync =:isTallySync  WHERE c.crnId=:crnId")
	int updateCreditNote(@Param("crnId")int crnId,@Param("isTallySync") int isTallySync);

}
