package com.ats.webapi.repo.salesreport3;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.opssalesreport.FrItemWiseSellData;

public interface FrItemWiseSellDataRepo extends JpaRepository<FrItemWiseSellData, Integer> {
	
	
	@Query(value = "SELECT\r\n" + 
			"    *\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"        (\r\n" + 
			"        SELECT\r\n" + 
			"            MONTH(sh.bill_date) AS MONTH,\r\n" + 
			"            YEAR(sh.bill_date) AS YEAR,\r\n" + 
			"            sd.sell_bill_detail_no,\r\n" + 
			"            sh.fr_id,\r\n" + 
			"            i.id AS item_id,\r\n" + 
			"            i.item_name,\r\n" + 
			"            i.item_grp2 AS sub_cat_id,\r\n" + 
			"            subcat.sub_cat_name,\r\n" + 
			"            sd.cat_id,\r\n" + 
			"            SUM(sd.qty) AS sold_qty,\r\n" + 
			"            ROUND(SUM(sd.grand_total),\r\n" + 
			"            2) AS sold_amt\r\n" + 
			"        FROM\r\n" + 
			"            t_sell_bill_header sh,\r\n" + 
			"            t_sell_bill_detail sd,\r\n" + 
			"            m_item i,\r\n" + 
			"            m_cat_sub subcat\r\n" + 
			"        WHERE\r\n" + 
			"            sd.sell_bill_no = sh.sell_bill_no AND i.id = sd.item_id AND subcat.sub_cat_id = i.item_grp2 AND sd.cat_id != 5 AND sh.del_status = 0 AND sh.bill_date BETWEEN :fromDate AND :toDate AND sh.fr_id = :frId AND sd.cat_id IN(:catIdList)\r\n" + 
			"        GROUP BY\r\n" + 
			"            i.id,\r\n" + 
			"            sh.fr_id,\r\n" + 
			"            i.item_grp2,\r\n" + 
			"            MONTH(sh.bill_date),\r\n" + 
			"            YEAR(sh.bill_date)\r\n" + 
			"    )\r\n" + 
			"UNION\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        MONTH(sh.bill_date) AS MONTH,\r\n" + 
			"        YEAR(sh.bill_date) AS YEAR,\r\n" + 
			"        sd.sell_bill_detail_no,\r\n" + 
			"        sh.fr_id,\r\n" + 
			"        sp.sp_id AS item_id,\r\n" + 
			"        sp.sp_name AS item_name,\r\n" + 
			"        catsub.sub_cat_id AS sub_cat_id,\r\n" + 
			"        catsub.sub_cat_name,\r\n" + 
			"        sd.cat_id,\r\n" + 
			"        SUM(sd.qty) AS sold_qty,\r\n" + 
			"        ROUND(SUM(sd.grand_total),\r\n" + 
			"        2) AS sold_amt\r\n" + 
			"    FROM\r\n" + 
			"        t_sell_bill_header sh,\r\n" + 
			"        t_sell_bill_detail sd,\r\n" + 
			"        m_sp_cake sp,\r\n" + 
			"        m_cat_sub catsub\r\n" + 
			"    WHERE\r\n" + 
			"        sd.sell_bill_no = sh.sell_bill_no AND sp.sp_id = sd.item_id AND sd.cat_id = catsub.cat_id AND sd.cat_id = 5 AND sh.del_status = 0 AND sh.bill_date BETWEEN :fromDate AND :toDate AND sh.fr_id = :frId AND sd.cat_id IN(:catIdList)\r\n" + 
			"    GROUP BY\r\n" + 
			"        sp.sp_id,\r\n" + 
			"        sh.fr_id,\r\n" + 
			"        catsub.sub_cat_id,\r\n" + 
			"        MONTH(sh.bill_date),\r\n" + 
			"        YEAR(sh.bill_date)\r\n" + 
			")\r\n" + 
			"    ) AS i\r\n" + 
			"ORDER BY\r\n" + 
			"    cat_id,\r\n" + 
			"    sub_cat_id,\r\n" + 
			"    item_name" + 
			" ", nativeQuery = true)
	List<FrItemWiseSellData> getItemwiseSellBillData(@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("catIdList") List<Integer> catIdList, @Param("frId") int frId);

	


}
