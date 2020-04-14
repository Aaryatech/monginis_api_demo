package com.ats.webapi.repository.tally;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.tally.Franchisees;

public interface TallyFrUpdateRepository extends JpaRepository<Franchisees, Integer>{


	@Transactional
	@Modifying
	@Query("UPDATE Franchisees f SET f.isTallySync =:isTallySync  WHERE f.frId=:frId")
	int updateFranchisee(@Param("frId")int customerId,@Param("isTallySync") int isTallySync);

}
