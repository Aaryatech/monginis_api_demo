package com.ats.webapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.pettycash.PettyCashManagmt;



@Repository
public interface PettyCashManagmtRepo extends JpaRepository<PettyCashManagmt, Integer> {

	@Query(value="SELECT * FROM t_pettycash_mgmnt WHERE fr_id=:frId AND status=:status ORDER BY pettycash_id DESC LIMIT 1",nativeQuery=true)
	public PettyCashManagmt findByFrIdAndStatusLimit1(@Param("frId") int frId, @Param("status") int status);

	@Query(value="SELECT * FROM t_pettycash_mgmnt WHERE fr_id=:frId AND status=:status  ORDER BY pettycash_id DESC",nativeQuery=true)
	public List<PettyCashManagmt> findByFrIdAndStatus(@Param("frId") int frId, @Param("status") int status);

	public PettyCashManagmt findByPettycashId(int id);

	@Query(value="SELECT * FROM t_pettycash_mgmnt WHERE fr_id=:frId AND status=:status AND date BETWEEN :fromDate AND :toDate ORDER BY pettycash_id DESC",nativeQuery=true)
	public List<PettyCashManagmt> findByFrIdAndStatusDateWise(@Param("frId") int frId,@Param("status")  int status,@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	

}
