package com.ats.webapi.repo.ownerapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.ownerapp.CreditNoteHeaderDisplayForApp;

public interface CreditNoteHeaderDisplayForAppRepo extends JpaRepository<CreditNoteHeaderDisplayForApp, Integer> {
	
	@Query(value="SELECT c.*,f.fr_name FROM t_credit_note_header c,m_franchisee f WHERE c.fr_id=f.fr_id AND c.crn_date BETWEEN :fromDate AND :toDate AND c.fr_id IN (:frIds) ",nativeQuery=true)
	List<CreditNoteHeaderDisplayForApp> getCrnHeaderByDateAndFr(@Param ("fromDate") String fromDate,@Param("toDate") String toDate,@Param("frIds") ArrayList<Integer> frIds);


}
