package com.ats.webapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.PettyCashHandover;
import com.ats.webapi.model.pettycash.PettyCashManagmt;

public interface PettyCashHandoverRepo extends JpaRepository<PettyCashHandover, Integer> {
	@Query(value="SELECT * FROM t_fr_pettycash_handover WHERE fr_id=:frId AND closing_date=:lastdate AND del_status=0 ORDER BY cash_handover_id DESC LIMIT 1",nativeQuery=true)
	public PettyCashHandover getLastRecordFrmPettyCashHndOvr(@Param("frId") int frId, @Param("lastdate") String lastdate);

	public List<PettyCashHandover> findByFrIdAndDelStatus(int frId, int del);
	
	public List<PettyCashHandover> findByFrIdAndDelStatusAndClosingDateBetween(int frId, int del,String fromDate, String toDate);
	
	@Query(value="SELECT * FROM t_fr_pettycash_handover WHERE fr_id =:frId AND transaction_date LIKE %:lastdate% ORDER BY cash_handover_id DESC LIMIT 1",nativeQuery=true)
	public PettyCashHandover getLastRecord(@Param("frId") int frId, @Param("lastdate") String lastdate);

}
