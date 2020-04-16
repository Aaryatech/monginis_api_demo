package com.ats.webapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.CatWiseDashboardQuery; 

public interface CatWiseDashboardQueryRepo extends JpaRepository<CatWiseDashboardQuery, Integer> {

	
	@Query(value = "SELECT  UUID() as id, IFNULL(data1.cat_name,'-') as cat_name, IFNULL(sum(data1.total),0) as total ,IFNULL(data1.cat_id,0) as cat_id FROM  ((SELECT sum(t_sell_bill_detail.grand_total) "
			+ "as total,t_sell_bill_detail.cat_id AS cat_id,m_category.cat_name as cat_name  FROM `t_sell_bill_header` ,t_sell_bill_detail,m_category WHERE "
			+ "t_sell_bill_header.`bill_date` BETWEEN :fromDate AND :toDate AND `fr_id` = :frId  and t_sell_bill_header.del_status=0 and "
			+ "t_sell_bill_header.sell_bill_no=t_sell_bill_detail.sell_bill_no and m_category.cat_id=t_sell_bill_detail.cat_id) UNION"
			+ " (SELECT sum(t_sp_cake.sp_grand_total)as total ,'5' as cat_id, 'Special Cake' as  cat_name  FROM `t_sp_cake` WHERE `fr_id` = :frId AND"
			+ " `sp_delivery_date` BETWEEN :fromDate AND :toDate AND `sp_book_for_mob_no` NOT LIKE '0' AND `del_status` = 0  )  )data1 "
			+ " GROUP BY data1.cat_id", nativeQuery = true)
	List<CatWiseDashboardQuery> dateWiseDashboardGraphQuery(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("frId") int frId);

}
