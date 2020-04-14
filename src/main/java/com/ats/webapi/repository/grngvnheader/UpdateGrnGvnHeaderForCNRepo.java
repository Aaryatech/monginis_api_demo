package com.ats.webapi.repository.grngvnheader;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.grngvn.UpdateGrnGvnHeaderForCN;

//Used to update GRN GVN HEADER After Credit Note Generation :set iscredit note and credit note id 

public interface UpdateGrnGvnHeaderForCNRepo extends JpaRepository<UpdateGrnGvnHeaderForCN, Integer> {

	@Transactional
	@Modifying
	@Query(" UPDATE UpdateGrnGvnHeaderForCN  SET creditNoteId=concat(creditNoteId,:creditNoteId,',') ,isCreditNote=:isCreditNote "
			+ " WHERE  grnGvnHeaderId=:grnGvnHeaderId ")
		int updateGrnGvnHeaderForCN(@Param("creditNoteId") int creditNoteId,@Param("isCreditNote") 
		int isCreditNote,@Param("grnGvnHeaderId") int grnGvnHeaderId);

	@Query(value=" select 1 from t_grn_gvn_header where  FIND_IN_SET(:crnSrNo,credit_note_id) AND   grn_gvn_header_id=:grnGvnHeaderId",nativeQuery=true)
	int isCrnNoPresent(@Param("crnSrNo")int crnSrNo,@Param("grnGvnHeaderId") int grnGvnHeaderId);
	
}
