package com.ats.webapi.repo.salesreport3;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.opssalesreport.SubCatDateWiseData;

public interface SubCatDateWiseDataRepo extends JpaRepository<SubCatDateWiseData, Integer> {

	@Query(value = "SELECT\r\n" + 
			"    sd.sell_bill_detail_no,\r\n" + 
			"    sc.sub_cat_id,\r\n" + 
			"    sh.fr_id,\r\n" + 
			"    ROUND(SUM(sd.grand_total),\r\n" + 
			"    2) AS sold_amt,\r\n" + 
			"    SUM(sd.qty) AS sold_qty,\r\n" + 
			"    sc.sub_cat_name,\r\n" + 
			"    sd.cat_id,\r\n" + 
			"    ROUND(SUM(sd.taxable_amt),\r\n" + 
			"    2) AS taxable_amt,\r\n" + 
			"    ROUND(SUM(sd.total_tax),\r\n" + 
			"    2) AS total_tax\r\n" + 
			"FROM\r\n" + 
			"    t_sell_bill_detail sd,\r\n" + 
			"    m_cat_sub sc,\r\n" + 
			"    t_sell_bill_header sh,\r\n" + 
			"    m_item i\r\n" + 
			"WHERE\r\n" + 
			"    sh.sell_bill_no = sd.sell_bill_no AND sd.item_id = i.id AND i.item_grp2 = sc.sub_cat_id AND sh.del_status = 0 AND sd.del_status = 0 AND sd.cat_id IN(:catIdList) AND sh.fr_id = :frId AND sh.bill_date BETWEEN :fromDate AND :toDate\r\n" + 
			"GROUP BY\r\n" + 
			"    sh.fr_id,\r\n" + 
			"    i.item_grp2\r\n" + 
			"ORDER BY\r\n" + 
			"    sd.cat_id,\r\n" + 
			"    sc.sub_cat_id", nativeQuery = true)
	List<SubCatDateWiseData> getSellBillData(@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("frId") int frId, @Param("catIdList") List<Integer> catIdList);
	
	@Query(value = "SELECT\r\n" + 
			"        sd.sell_bill_detail_no,\r\n" + 
			"        sc.sub_cat_id,\r\n" + 
			"        sh.fr_id,\r\n" + 
			"        ROUND(SUM(sd.grand_total),\r\n" + 
			"        2) AS sold_amt,\r\n" + 
			"        SUM(sd.qty) AS sold_qty,\r\n" + 
			"        sc.sub_cat_name,\r\n" + 
			"        sd.cat_id,\r\n" + 
			"        ROUND(SUM(sd.taxable_amt),\r\n" + 
			"        2) AS taxable_amt,\r\n" + 
			"        ROUND(SUM(sd.total_tax),\r\n" + 
			"        2) AS total_tax  \r\n" + 
			"    FROM\r\n" + 
			"        t_sell_bill_detail sd,\r\n" + 
			"        m_cat_sub sc,\r\n" + 
			"        t_sell_bill_header sh,\r\n" + 
			"        m_sp_cake i  \r\n" + 
			"    WHERE\r\n" + 
			"        sh.sell_bill_no = sd.sell_bill_no \r\n" + 
			"        AND sd.item_id = i.sp_id  \r\n" + 
			"        AND sh.del_status = 0 \r\n" + 
			"        AND sd.del_status = 0 \r\n" + 
			"        AND sd.cat_id IN(:catIdList) \r\n" + 
			"        AND sh.fr_id = :frId \r\n" + 
			"        AND sh.bill_date BETWEEN :fromDate AND :toDate \r\n" + 
			"        and sd.cat_id=sc.cat_id\r\n" + 
			"    GROUP BY\r\n" + 
			"        sh.fr_id,\r\n" + 
			"        sc.sub_cat_id \r\n" + 
			"    ORDER BY\r\n" + 
			"        sd.cat_id,\r\n" + 
			"        sc.sub_cat_id\r\n" + 
			" ", nativeQuery = true)
	List<SubCatDateWiseData> getSellBillDataspcake(@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("frId") int frId, @Param("catIdList") List<Integer> catIdList);

}
