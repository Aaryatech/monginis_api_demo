package com.ats.webapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.pettycash.PettyCashManagmt;



@Repository
public interface PettyCashManagmtRepo extends JpaRepository<PettyCashManagmt, Integer> {

	@Query(value="SELECT * FROM t_pettycash_mgmnt WHERE fr_id=:frId AND status=:status ORDER BY pettycash_id DESC LIMIT 1",nativeQuery=true)
	public PettyCashManagmt findByFrIdAndStatusLimit1(@Param("frId") int frId, @Param("status") int status);

	@Query(value="SELECT * FROM t_pettycash_mgmnt WHERE fr_id=:frId AND status=:status  ORDER BY pettycash_id DESC",nativeQuery=true)
	public List<PettyCashManagmt> findByFrIdAndStatus(@Param("frId") int frId, @Param("status") int status);

	public PettyCashManagmt findByPettycashId(int id);

	@Query(value="SELECT  pettycash_id,\n" + 
			"    fr_id,\n" + 
			"    date,\n" + 
			"    opening_amt,\n" + 
			"    cash_amt,\n" + 
			"    card_amt,\n" + 
			"    other_amt,\n" + 
			"    total_amt,\n" + 
			"    withdrawal_amt,\n" + 
			"    closing_amt,\n" + 
			"    status,\n" + 
			"    opn_edit_amt,\n" + 
			"    cash_edit_amt,\n" + 
			"    card_edit_Amt,\n" + 
			"    ttl_edit_amt,\n" + 
			"    ex_float1,\n" + 
			"    ex_var1,\n" + 
			"     COALESCE((SELECT e.fr_emp_name FROM m_fr_emp e WHERE e.fr_emp_id=t_pettycash_mgmnt.ex_int1),'') as ex_var2,\n" + 
			"    CASE WHEN t_pettycash_mgmnt.date = SUBDATE(CURRENT_DATE, 1) THEN 1 ELSE 0\n" + 
			"END AS ex_int1 FROM t_pettycash_mgmnt WHERE fr_id=:frId AND status=:status AND date BETWEEN :fromDate AND :toDate ORDER BY pettycash_id DESC",nativeQuery=true)
	public List<PettyCashManagmt> findByFrIdAndStatusDateWise(@Param("frId") int frId,@Param("status")  int status,@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Transactional
	@Modifying
	@Query(value="UPDATE t_pettycash_mgmnt SET withdrawal_amt=:withdrawl, closing_amt=:closeAmt WHERE pettycash_id = :id", nativeQuery=true)
	public int changeWithdrawalAmt(@Param("id") int id, @Param("closeAmt") float closeAmt, @Param("withdrawl") float withdrawl);
	
	@Transactional
	@Modifying
	@Query(value="delete from t_pettycash_mgmnt WHERE pettycash_id = :id", nativeQuery=true)
	public int deletePettyCashDataById(@Param("id") int id);
	
}
