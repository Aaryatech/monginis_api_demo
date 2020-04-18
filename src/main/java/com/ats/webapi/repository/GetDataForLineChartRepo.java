package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GetDataForLineChart; 

public interface GetDataForLineChartRepo extends JpaRepository<GetDataForLineChart, Integer>{

	@Query(value="SELECT\n" + 
			"UUID() as id, data1.bill_date, sum(data1.total) as total\n" + 
			"FROM\n" + 
			"(SELECT t_sell_bill_header.bill_date as bill_date ,sum(grand_total) As total FROM `t_sell_bill_header` WHERE `bill_date` BETWEEN :fromDate AND :toDate AND `fr_id` = :frId  and t_sell_bill_header.del_status=0 GROUP by t_sell_bill_header.bill_date\n" + 
			"UNION ALL\n" + 
			"SELECT sp_delivery_date as  bill_date,sum(t_sp_cake.sp_grand_total)as total FROM `t_sp_cake` WHERE `fr_id` = :frId AND `sp_delivery_date` BETWEEN :fromDate AND :toDate AND `sp_book_for_mob_no` NOT LIKE '0' AND `del_status` = 0 GROUP BY sp_delivery_date\n" + 
			")data1\n" + 
			"GROUP BY data1.bill_date\n" + 
			"ORDER BY data1.bill_date",nativeQuery=true)
	List<GetDataForLineChart> getDataForLineChartdate(@Param("fromDate") String fromDate,@Param("toDate") String toDate,
			@Param("frId") int frId);

	@Query(value="SELECT\n" + 
			" UUID() as id,sum(data1.total) as total,\n" + 
			"    CONCAT('week ',WEEK(data1.bill_date)+1) as bill_date\n" + 
			"FROM\n" + 
			"(SELECT t_sell_bill_header.bill_date as bill_date ,sum(grand_total) As total FROM `t_sell_bill_header` WHERE `bill_date` BETWEEN :fromDate AND :toDate AND `fr_id` = :frId  and t_sell_bill_header.del_status=0 GROUP by t_sell_bill_header.bill_date\n" + 
			"UNION ALL\n" + 
			"SELECT sp_delivery_date as  bill_date,sum(t_sp_cake.sp_grand_total)as total FROM `t_sp_cake` WHERE `fr_id` = :frId AND `sp_delivery_date` BETWEEN :fromDate AND :toDate AND `sp_book_for_mob_no` NOT LIKE '0' AND `del_status` = 0 GROUP BY sp_delivery_date\n" + 
			")data1\n" + 
			"GROUP BY WEEK(data1.bill_date)\n" + 
			"ORDER BY data1.bill_date",nativeQuery=true)
	List<GetDataForLineChart> getDataForLineChartweek(@Param("fromDate") String fromDate,@Param("toDate") String toDate,
			@Param("frId") int frId);

	@Query(value="SELECT\n" + 
			" UUID() as id,sum(data1.total) as total , \n" + 
			" concat(MONTHNAME(data1.bill_date), '-', Year(data1.bill_date)) AS bill_date\n" + 
			"FROM\n" + 
			"(SELECT t_sell_bill_header.bill_date as bill_date ,sum(grand_total) As total FROM `t_sell_bill_header` WHERE `bill_date` BETWEEN :fromDate AND :toDate AND `fr_id` = :frId  and t_sell_bill_header.del_status=0 GROUP by t_sell_bill_header.bill_date\n" + 
			"UNION ALL\n" + 
			"SELECT sp_delivery_date as  bill_date,sum(t_sp_cake.sp_grand_total)as total FROM `t_sp_cake` WHERE `fr_id` = :frId AND `sp_delivery_date` BETWEEN :fromDate AND :toDate AND `sp_book_for_mob_no` NOT LIKE '0' AND `del_status` = 0 GROUP BY sp_delivery_date\n" + 
			")data1\n" + 
			"GROUP BY Year(data1.bill_date), Month(data1.bill_date)\n" + 
			"ORDER BY data1.bill_date DESC",nativeQuery=true)
	List<GetDataForLineChart> getDataForLineChartmonth(@Param("fromDate") String fromDate,@Param("toDate") String toDate,
			@Param("frId") int frId);

}
