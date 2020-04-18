package com.ats.webapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.DashboardData;

public interface DashboardDataRepo extends JpaRepository<DashboardData, Integer> {

	@Query(value = "SELECT \n" + 
			"    a.fr_id,\n" + 
			"    ROUND(IFNULL((SELECT sum(t_sell_bill_header.grand_total)  FROM `t_sell_bill_header` WHERE `bill_date` BETWEEN :fromDate AND :toDate AND `fr_id` = a.fr_id  and t_sell_bill_header.del_status=0),0),0) AS total_sell,\n" + 
			"    ROUND(IFNULL(( SELECT sum(t_sp_cake.sp_grand_total)  FROM t_sp_cake WHERE `sp_delivery_date` BETWEEN :fromDate AND :toDate AND `t_sp_cake`.`fr_id`= a.fr_id  AND t_sp_cake.sp_book_for_mob_no  NOT LIKE '0'),0),0) AS sp_cake_total_bill,\n" + 
			"     ROUND(IFNULL(( SELECT sum(t_sp_cake.sp_advance)  FROM t_sp_cake WHERE `sp_delivery_date` BETWEEN :fromDate AND :toDate AND `t_sp_cake`.`fr_id`= a.fr_id  AND t_sp_cake.sp_book_for_mob_no  LIKE '0'),0),0) AS sp_cake_total_book,\n" + 
			"     ROUND(IFNULL(( SELECT sum(t_sp_cake.sp_grand_total)  FROM t_sp_cake WHERE `sp_delivery_date` BETWEEN :fromDate AND :toDate AND `t_sp_cake`.`fr_id`= a.fr_id   ),0),0) AS sp_cake_grand_total_book,\n" + 
			"     ROUND(IFNULL((SELECT  sum(t_sell_bill_header.grand_total) FROM `t_sell_bill_header` WHERE `bill_date` BETWEEN :fromDate AND :toDate AND `fr_id` =  a.fr_id AND `payment_mode` = 1 AND  t_sell_bill_header.del_status=0),0),0) AS cash_amt,\n" + 
			"    ROUND(IFNULL((SELECT  sum(t_sell_bill_header.grand_total)  FROM `t_sell_bill_header` WHERE `bill_date` BETWEEN :fromDate AND :toDate AND `fr_id` =  a.fr_id AND `payment_mode` = 2 and  t_sell_bill_header.del_status=0),0),0) AS card_amt,\n" + 
			"       ROUND(IFNULL((SELECT  sum(t_grn_gvn.grn_gvn_amt)  FROM `t_grn_gvn` WHERE t_grn_gvn.grn_gvn_date BETWEEN :fromDate AND :toDate AND `fr_id` =  a.fr_id AND t_grn_gvn.is_grn IN(1) and t_grn_gvn.del_status=0),0),0) AS grn_req_amt,\n" + 
			"         ROUND(IFNULL((SELECT  sum(t_grn_gvn.grn_gvn_amt)  FROM `t_grn_gvn` WHERE t_grn_gvn.grn_gvn_date BETWEEN :fromDate AND :toDate AND `fr_id` =  a.fr_id AND t_grn_gvn.is_grn IN(0,2) and t_grn_gvn.del_status=  0),0),0) AS grn_req_ammt,\n" + 
			"      ROUND(IFNULL((SELECT  sum(t_grn_gvn.apr_grand_total)  FROM `t_grn_gvn` WHERE t_grn_gvn.grn_gvn_date BETWEEN :fromDate AND :toDate AND `fr_id` =  a.fr_id AND t_grn_gvn.is_grn IN(1)and t_grn_gvn.del_status=  0),0),0) AS grn_apr_amt,\n" + 
			"         ROUND(IFNULL((SELECT  sum(t_grn_gvn.apr_grand_total)  FROM `t_grn_gvn` WHERE t_grn_gvn.grn_gvn_date BETWEEN :fromDate AND :toDate AND `fr_id` =  a.fr_id AND t_grn_gvn.is_grn IN(0,2) and t_grn_gvn.del_status=  0),0),0) AS grn_apr_ammt,\n" + 
			"         ROUND(IFNULL((SELECT  sum(t_bill_header.grand_total)  FROM t_bill_header WHERE t_bill_header.bill_date BETWEEN :fromDate AND :toDate AND `fr_id` =  a.fr_id AND t_bill_header.status=2 and t_bill_header.del_status =  0),0),0) AS purchase_bill,\n" + 
			"          ROUND(IFNULL((SELECT  sum(t_credit_note_header.crn_grand_total)  FROM t_credit_note_header WHERE t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate AND `fr_id` =  a.fr_id ),0),0) AS credit_note, "
			+ " ROUND(IFNULL((SELECT fr_target_amt  FROM `m_fr_target` WHERE `fr_id` = a.fr_id AND `fr_target_year` = :year AND `fr_target_month` = :month),0),0) as target FROM\n" + 
			"    m_franchisee a WHERE a.fr_id=:frId", nativeQuery = true)
	DashboardData getDashboardData(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("frId") int frId,@Param("month") int month, @Param("year") int year);

}
