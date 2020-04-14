package com.ats.webapi.repo.salesreport3;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.opssalesreport.FrSubCatWiseSellData;

public interface FrSubCatWiseSellDataRepo extends JpaRepository<FrSubCatWiseSellData, Integer> {

	@Query(value = "SELECT\r\n" + 
			"    sell_bill_detail_no,\r\n" + 
			"    sub_cat_id,\r\n" + 
			"    fr_id,\r\n" + 
			"    sold_amt,\r\n" + 
			"    sold_qty,\r\n" + 
			"    fr_name,\r\n" + 
			"    sub_cat_name,\r\n" + 
			"    MONTH,\r\n" + 
			"    YEAR\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"        (\r\n" + 
			"        SELECT\r\n" + 
			"            sd.sell_bill_detail_no,\r\n" + 
			"            sc.sub_cat_id,\r\n" + 
			"            f.fr_id,\r\n" + 
			"            ROUND(SUM(sd.grand_total),\r\n" + 
			"            2) AS sold_amt,\r\n" + 
			"            SUM(sd.qty) AS sold_qty,\r\n" + 
			"            f.fr_name,\r\n" + 
			"            sc.sub_cat_name,\r\n" + 
			"            MONTH(sh.bill_date) AS MONTH,\r\n" + 
			"            YEAR(sh.bill_date) AS YEAR,\r\n" + 
			"            sd.cat_id\r\n" + 
			"        FROM\r\n" + 
			"            t_sell_bill_detail sd,\r\n" + 
			"            m_cat_sub sc,\r\n" + 
			"            t_sell_bill_header sh,\r\n" + 
			"            m_item i,\r\n" + 
			"            m_franchisee f\r\n" + 
			"        WHERE\r\n" + 
			"            sh.sell_bill_no = sd.sell_bill_no AND sd.item_id = i.id AND i.item_grp2 = sc.sub_cat_id AND sh.fr_id = f.fr_id AND sh.del_status = 0 AND sd.del_status = 0 AND sc.sub_cat_id IN(:subCatIdList) AND sh.fr_id IN(:frIdList) AND sh.bill_date BETWEEN :fromDate AND :toDate AND sd.cat_id != 5\r\n" + 
			"        GROUP BY\r\n" + 
			"            sh.fr_id,\r\n" + 
			"            i.item_grp2,\r\n" + 
			"            MONTH(sh.bill_date),\r\n" + 
			"            YEAR(sh.bill_date)\r\n" + 
			"    )\r\n" + 
			"UNION\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        sd.sell_bill_detail_no,\r\n" + 
			"        sc.sub_cat_id,\r\n" + 
			"        f.fr_id,\r\n" + 
			"        SUM(sd.grand_total) AS sold_amt,\r\n" + 
			"        SUM(sd.qty) AS sold_qty,\r\n" + 
			"        f.fr_name,\r\n" + 
			"        sc.sub_cat_name,\r\n" + 
			"        MONTH(sh.bill_date) AS MONTH,\r\n" + 
			"        YEAR(sh.bill_date) AS YEAR,\r\n" + 
			"        sd.cat_id\r\n" + 
			"    FROM\r\n" + 
			"        t_sell_bill_detail sd,\r\n" + 
			"        m_cat_sub sc,\r\n" + 
			"        t_sell_bill_header sh,\r\n" + 
			"        m_sp_cake sp,\r\n" + 
			"        m_franchisee f\r\n" + 
			"    WHERE\r\n" + 
			"        sh.sell_bill_no = sd.sell_bill_no AND sd.item_id = sp.sp_id AND sd.cat_id = sc.cat_id AND sh.fr_id = f.fr_id AND sh.del_status = 0 AND sd.del_status = 0 AND sc.sub_cat_id IN(:subCatIdList) AND sh.fr_id IN(:frIdList) AND sh.bill_date BETWEEN :fromDate AND :toDate AND sd.cat_id = 5\r\n" + 
			"    GROUP BY\r\n" + 
			"        sh.fr_id,\r\n" + 
			"        sp.sp_id,\r\n" + 
			"        MONTH(sh.bill_date),\r\n" + 
			"        YEAR(sh.bill_date)\r\n" + 
			")\r\n" + 
			"    ) AS i\r\n" + 
			"ORDER BY\r\n" + 
			"    cat_id,\r\n" + 
			"    sub_cat_id", nativeQuery = true)
	List<FrSubCatWiseSellData> getSellBillData(@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("frIdList") List<Integer> frIds, @Param("subCatIdList") List<Integer> subCatIds);

}
