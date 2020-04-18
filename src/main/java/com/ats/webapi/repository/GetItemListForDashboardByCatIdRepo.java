package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GetItemListForDashboardByCatId;

public interface GetItemListForDashboardByCatIdRepo extends JpaRepository<GetItemListForDashboardByCatId, Integer> {

	
	@Query(value = "SELECT round(sum(t_sell_bill_detail.grand_total),2) as total,sum(t_sell_bill_detail.qty) as qty,t_sell_bill_detail.item_id AS item_id,"
			+ "m_item.item_name as item_name   FROM `t_sell_bill_header` ,t_sell_bill_detail,m_item WHERE t_sell_bill_header.`bill_date` BETWEEN :fromDate"
			+ " AND :toDate AND `fr_id` = :frId  and t_sell_bill_header.del_status=0 and t_sell_bill_header.sell_bill_no=t_sell_bill_detail.sell_bill_no "
			+ "and m_item.id=t_sell_bill_detail.item_id and t_sell_bill_detail.cat_id=:catId GROUP BY t_sell_bill_detail.item_id order by total asc", nativeQuery = true)
	List<GetItemListForDashboardByCatId> getItemListForDashboardByCatIdasc(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("frId") int frId,@Param("catId")  int catId);

	@Query(value = "SELECT round(sum(t_sell_bill_detail.grand_total),2) as total,sum(t_sell_bill_detail.qty) as qty,t_sell_bill_detail.item_id AS item_id,"
			+ "m_item.item_name as item_name   FROM `t_sell_bill_header` ,t_sell_bill_detail,m_item WHERE t_sell_bill_header.`bill_date` BETWEEN :fromDate"
			+ " AND :toDate AND `fr_id` = :frId  and t_sell_bill_header.del_status=0 and t_sell_bill_header.sell_bill_no=t_sell_bill_detail.sell_bill_no "
			+ "and m_item.id=t_sell_bill_detail.item_id and t_sell_bill_detail.cat_id=:catId GROUP BY t_sell_bill_detail.item_id order by total desc", nativeQuery = true)
	List<GetItemListForDashboardByCatId> getItemListForDashboardByCatIddesc(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("frId") int frId,@Param("catId")  int catId);

	@Query(value = "SELECT sum(t_sp_cake.sp_grand_total)as total , sum(t_sp_cake.sp_selected_weight)as qty ,t_sp_cake.sp_id as item_id  "
			+ ",concat( m_sp_cake.sp_name,' - ',m_sp_cake.sp_code) as  item_name  FROM `t_sp_cake`,m_sp_cake WHERE `fr_id` = :frId AND "
			+ "`sp_delivery_date` BETWEEN :fromDate AND :toDate AND `sp_book_for_mob_no` NOT LIKE '0' AND t_sp_cake.del_status= 0 "
			+ "and m_sp_cake.sp_id=t_sp_cake.sp_id GROUP by t_sp_cake.sp_id order by total asc", nativeQuery = true)
	List<GetItemListForDashboardByCatId> getItemListForDashboardspdasc(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("frId") int frId);

	@Query(value = "SELECT sum(t_sp_cake.sp_grand_total)as total , sum(t_sp_cake.sp_selected_weight)as qty ,t_sp_cake.sp_id as item_id  "
			+ ",concat( m_sp_cake.sp_name,' - ',m_sp_cake.sp_code) as  item_name  FROM `t_sp_cake`,m_sp_cake WHERE `fr_id` = :frId AND "
			+ "`sp_delivery_date` BETWEEN :fromDate AND :toDate AND `sp_book_for_mob_no` NOT LIKE '0' AND t_sp_cake.del_status= 0 "
			+ "and m_sp_cake.sp_id=t_sp_cake.sp_id GROUP by t_sp_cake.sp_id order by total desc", nativeQuery = true)
	List<GetItemListForDashboardByCatId> getItemListForDashboardspddesc(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("frId") int frId);

}
