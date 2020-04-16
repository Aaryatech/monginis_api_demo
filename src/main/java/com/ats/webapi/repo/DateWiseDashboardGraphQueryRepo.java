package com.ats.webapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.DateWiseDashboardGraphQuery;

public interface DateWiseDashboardGraphQueryRepo extends JpaRepository<DateWiseDashboardGraphQuery, Integer>{

	
	@Query(value = "SELECT  UUID() as id, data1.bill_date, IFNULL(sum(data1.total),0) as total FROM (SELECT t_sell_bill_header.bill_date as bill_date "
			+ ",sum(grand_total) As total FROM `t_sell_bill_header` WHERE `bill_date` BETWEEN :fromDate AND :toDate AND `fr_id` = :frId  and t_sell_bill_header.del_status=0 GROUP by t_sell_bill_header.bill_date "
			+ "UNION ALL SELECT sp_delivery_date as  bill_date,sum(t_sp_cake.sp_grand_total)as total FROM `t_sp_cake` WHERE `fr_id` = :frId AND `sp_delivery_date` BETWEEN :fromDate AND :toDate AND "
			+ "`sp_book_for_mob_no` NOT LIKE '0' AND `del_status` = 0 GROUP BY sp_delivery_date )data1 GROUP BY data1.bill_date ORDER BY data1.bill_date", nativeQuery = true)
	List<DateWiseDashboardGraphQuery> dateWiseDashboardGraphQuery(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("frId") int frId);

}
