package com.ats.webapi.repository.tally;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.tally.SalesVouchers;


@Repository
public interface TallySVoucherUpdateRepository extends JpaRepository<SalesVouchers, Integer> {

	
	@Transactional
	@Modifying
	@Query("UPDATE SalesVouchers s SET s.isTallySync =:isTallySync  WHERE s.billNo=:billNo")
	int updateSalesVouchers(@Param("billNo")int billNo,@Param("isTallySync") int isTallySync);

}
