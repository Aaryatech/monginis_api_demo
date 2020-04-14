package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.grngvn.UpdateGrnGvnForCreditNote;

public interface UpdateGrnGvnForCreditNoteRepository extends JpaRepository<UpdateGrnGvnForCreditNote, Integer> {
	
	
	@Transactional
	@Modifying
	@Query(" UPDATE UpdateGrnGvnForCreditNote  SET isCreditNote=:isCreditNote "
			+ " WHERE grnGvnId=:grnGvnId ")
		int updateGrnGvnForCreditNoteInsert(@Param("grnGvnId") int grnGvnId,@Param("isCreditNote") 
		int isCreditNote);
	
}
