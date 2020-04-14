package com.ats.webapi.repo.salesreport3;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.opssalesreport.FrItemwiseData;

public interface FrItemWiseSoldDataRepo extends JpaRepository<FrItemwiseData, Integer> {
	
	
	@Query(value = "SELECT\r\n" + 
			"    *\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"        (\r\n" + 
			"        SELECT\r\n" + 
			"            MONTH(bh.bill_date) AS MONTH,\r\n" + 
			"            YEAR(bh.bill_date) AS YEAR,\r\n" + 
			"            bd.bill_detail_no,\r\n" + 
			"            bh.fr_id,\r\n" + 
			"            i.id AS item_id,\r\n" + 
			"            i.item_name,\r\n" + 
			"            i.item_grp2 AS sub_cat_id,\r\n" + 
			"            subcat.sub_cat_name,\r\n" + 
			"            bd.cat_id,\r\n" + 
			"            SUM(bd.bill_qty) AS sold_qty,\r\n" + 
			"            ROUND(SUM(bd.grand_total),\r\n" + 
			"            2) AS sold_amt,\r\n" + 
			"            ROUND(SUM(bd.taxable_amt),\r\n" + 
			"            2) AS taxable_amt,\r\n" + 
			"            ROUND(SUM(bd.total_tax),\r\n" + 
			"            2) AS tax_amt\r\n" + 
			"        FROM\r\n" + 
			"            t_bill_header bh,\r\n" + 
			"            t_bill_detail bd,\r\n" + 
			"            m_item i,\r\n" + 
			"            m_cat_sub subcat\r\n" + 
			"        WHERE\r\n" + 
			"            bd.bill_no = bh.bill_no AND i.id = bd.item_id AND subcat.sub_cat_id = i.item_grp2 AND bd.cat_id != 5 AND bh.del_status = 0 AND bh.bill_date BETWEEN :fromDate AND :toDate AND bh.fr_id = :frId AND bd.cat_id IN(:catIdList)\r\n" + 
			"        GROUP BY\r\n" + 
			"            i.id,\r\n" + 
			"            bh.fr_id,\r\n" + 
			"            i.item_grp2,\r\n" + 
			"            MONTH(bh.bill_date),\r\n" + 
			"            YEAR(bh.bill_date)\r\n" + 
			"    )\r\n" + 
			"UNION\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        MONTH(bh.bill_date) AS MONTH,\r\n" + 
			"        YEAR(bh.bill_date) AS YEAR,\r\n" + 
			"        bd.bill_detail_no,\r\n" + 
			"        bh.fr_id,\r\n" + 
			"        sp.sp_id AS item_id,\r\n" + 
			"        sp.sp_name AS item_name,\r\n" + 
			"        catsub.sub_cat_id AS sub_cat_id,\r\n" + 
			"        catsub.sub_cat_name,\r\n" + 
			"        bd.cat_id,\r\n" + 
			"        SUM(bd.bill_qty) AS sold_qty,\r\n" + 
			"        ROUND(SUM(bd.grand_total),\r\n" + 
			"        2) AS sold_amt,\r\n" + 
			"        ROUND(SUM(bd.taxable_amt),\r\n" + 
			"        2) AS taxable_amt,\r\n" + 
			"        ROUND(SUM(bd.total_tax),\r\n" + 
			"        2) AS tax_amt\r\n" + 
			"    FROM\r\n" + 
			"        t_bill_header bh,\r\n" + 
			"        t_bill_detail bd,\r\n" + 
			"        m_sp_cake sp,\r\n" + 
			"        m_cat_sub catsub\r\n" + 
			"    WHERE\r\n" + 
			"        bd.bill_no = bh.bill_no AND sp.sp_id = bd.item_id AND bd.cat_id = catsub.cat_id AND bd.cat_id = 5 AND bh.del_status = 0 AND bh.bill_date BETWEEN :fromDate AND :toDate AND bh.fr_id = :frId AND bd.cat_id IN(:catIdList)\r\n" + 
			"    GROUP BY\r\n" + 
			"        sp.sp_id,\r\n" + 
			"        bh.fr_id,\r\n" + 
			"        catsub.sub_cat_id,\r\n" + 
			"        MONTH(bh.bill_date),\r\n" + 
			"        YEAR(bh.bill_date)\r\n" + 
			")\r\n" + 
			"    ) AS i\r\n" + 
			"ORDER BY\r\n" + 
			"    cat_id,\r\n" + 
			"    sub_cat_id,\r\n" + 
			"    item_name" + 
			" ", nativeQuery = true)
	List<FrItemwiseData> getItemwiseBillData(@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("catIdList") List<Integer> catIdList, @Param("frId") int frId);

	

}
