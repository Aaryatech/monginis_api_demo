package com.ats.webapi.model.opstock;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OpStockUpdateRepo extends JpaRepository<OpStockUpdate, Integer> {

	@Query(value = "   SELECT u.* FROM t_opening_stock_update u WHERE u.del_status=0 AND u.date between :fromDate AND :toDate AND u.cat_id=:catId", nativeQuery = true)
	List<OpStockUpdate> getOpStockAdjReport(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("catId") int catId);

}
