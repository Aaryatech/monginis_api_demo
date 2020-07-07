package com.ats.webapi.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.CreditNotePos;

public interface CreditNotePosRepo extends JpaRepository<CreditNotePos,Integer> {

	List<CreditNotePos> findByDelStatusOrderByCrnDetailNoDesc(int i);
	
	List<CreditNotePos> findByCrnNoAndDelStatusOrderByCrnDetailNoDesc(int i,int j);

	@Query(value="SELECT * from t_credit_note_pos where crn_no=:crnNo AND del_status=0",nativeQuery=true)
	List<CreditNotePos> getCrnDetailsByCrnNo(@Param("crnNo") int crnNo);

}
