package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.PostBillHeader;

public interface PostBillHeaderRepository extends JpaRepository<PostBillHeader, Integer> {

	PostBillHeader save(PostBillHeader postBillHeader);

	@Transactional
	@Modifying
	@Query("UPDATE PostBillHeader i SET i.frId=:frId,i.frCode=:frCode,i.partyName=:frName,i.partyGstin=:frGstNo,i.partyAddress=:frAddress  WHERE i.billNo=:billNo ")
	int updatefrinfo(@Param("billNo")int billNo,@Param("frId") int frId, @Param("frCode") String frCode,@Param("frName") String frName,@Param("frGstNo") String frGstNo,@Param("frAddress") String frAddress);

	// sum(CASE WHEN payment_mode = 1 THEN payable_amt ELSE 0 END) as cash,
	
	@Query(value="SELECT SUM(t_bill_header.grand_total) FROM t_bill_header WHERE t_bill_header.bill_date BETWEEN :fromDate AND :toDate and t_bill_header.del_status=0 GROUP by t_bill_header.bill_date",nativeQuery=true)
    int getTotalSellBetFdTd(@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	

	// (SELECT m_fr_opening_stock_header.month FROM m_fr_opening_stock_header WHERE
	// fr_id=15 AND is_month_closed=0)
	/*
	 * SELL - SELECT SUM(t_sell_bill_detail.qty) FROM t_sell_bill_detail WHERE
	 * t_sell_bill_detail.item_id =8 AND t_sell_bill_detail.sell_bill_no IN(SELECT
	 * t_sell_bill_header.sell_bill_no FROM t_sell_bill_header WHERE
	 * t_sell_bill_header.fr_id=37 AND t_sell_bill_header.bill_date BETWEEN
	 * '2017-10-01' AND '2017-10-26')
	 * 
	 * Stock- SELECT m_fr_opening_stock_detail.opening_stock FROM
	 * m_fr_opening_stock_detail WHERE m_fr_opening_stock_detail.item_id=22 AND
	 * m_fr_opening_stock_detail.opening_stock_header_id IN(SELECT
	 * m_fr_opening_stock_header.opening_stock_header_id FROM
	 * m_fr_opening_stock_header WHERE m_fr_opening_stock_header.fr_id=17 AND
	 * m_fr_opening_stock_header.month=10)
	 */
	
	

}
