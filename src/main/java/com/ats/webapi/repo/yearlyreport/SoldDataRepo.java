package com.ats.webapi.repo.yearlyreport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.yearlyreport.SoldData;

public interface SoldDataRepo extends JpaRepository<SoldData, Integer> {

	@Query(value = "SELECT\r\n" + 
			"    bill_detail_no,\r\n" + 
			"    sub_cat_id,\r\n" + 
			"    fr_id,\r\n" + 
			"    sold_amt,\r\n" + 
			"    sold_qty,\r\n" + 
			"    taxable_amt,\r\n" + 
			"    tax_amt,\r\n" + 
			"    fr_name,\r\n" + 
			"    sub_cat_name,\r\n" + 
			"    MONTH,\r\n" + 
			"    YEAR,\r\n" + 
			"    cat_id,\r\n" + 
			"    item_id,\r\n" + 
			"    item_name\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"        (\r\n" + 
			"        SELECT\r\n" + 
			"            bd.bill_detail_no,\r\n" + 
			"            sc.sub_cat_id,\r\n" + 
			"            f.fr_id,\r\n" + 
			"            ROUND(SUM(bd.grand_total),\r\n" + 
			"            2) AS sold_amt,\r\n" + 
			"            SUM(bd.bill_qty) AS sold_qty,\r\n" + 
			"            ROUND(SUM(bd.taxable_amt),\r\n" + 
			"            2) AS taxable_amt,\r\n" + 
			"            ROUND(SUM(bd.total_tax),\r\n" + 
			"            2) AS tax_amt,\r\n" + 
			"            f.fr_name,\r\n" + 
			"            sc.sub_cat_name,\r\n" + 
			"            MONTH(bh.bill_date) AS MONTH,\r\n" + 
			"            YEAR(bh.bill_date) AS YEAR,\r\n" + 
			"            bd.cat_id,\r\n" + 
			"            bd.item_id,\r\n" + 
			"            i.item_name\r\n" + 
			"        FROM\r\n" + 
			"            t_bill_detail bd,\r\n" + 
			"            m_cat_sub sc,\r\n" + 
			"            t_bill_header bh,\r\n" + 
			"            m_item i,\r\n" + 
			"            m_franchisee f\r\n" + 
			"        WHERE\r\n" + 
			"            bh.bill_no = bd.bill_no AND bd.item_id = i.id AND i.item_grp2 = sc.sub_cat_id AND bh.fr_id = f.fr_id AND bh.del_status = 0 AND bd.del_status = 0 AND bd.cat_id IN(:catIdList) AND bh.fr_id IN(:frIdList) AND bh.bill_date BETWEEN :fromDate AND :toDate AND bd.cat_id != 5\r\n" + 
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
			"        bd.bill_detail_no,\r\n" + 
			"        sc.sub_cat_id,\r\n" + 
			"        f.fr_id,\r\n" + 
			"        ROUND(SUM(bd.grand_total),\r\n" + 
			"        2) AS sold_amt,\r\n" + 
			"        SUM(bd.bill_qty) AS sold_qty,\r\n" + 
			"        ROUND(SUM(bd.taxable_amt),\r\n" + 
			"        2) AS taxable_amt,\r\n" + 
			"        ROUND(SUM(bd.total_tax),\r\n" + 
			"        2) AS tax_amt,\r\n" + 
			"        f.fr_name,\r\n" + 
			"        sc.sub_cat_name,\r\n" + 
			"        MONTH(bh.bill_date) AS MONTH,\r\n" + 
			"        YEAR(bh.bill_date) AS YEAR,\r\n" + 
			"        bd.cat_id,\r\n" + 
			"        sp.sp_id AS item_id,\r\n" + 
			"        sp.sp_name AS item_name\r\n" + 
			"    FROM\r\n" + 
			"        t_bill_detail bd,\r\n" + 
			"        m_cat_sub sc,\r\n" + 
			"        t_bill_header bh,\r\n" + 
			"        m_sp_cake sp,\r\n" + 
			"        m_franchisee f\r\n" + 
			"    WHERE\r\n" + 
			"        bh.bill_no = bd.bill_no AND bd.item_id = sp.sp_id AND bd.cat_id = sc.cat_id AND bh.fr_id = f.fr_id AND bh.del_status = 0 AND bd.del_status = 0 AND bd.cat_id IN(:catIdList) AND bh.fr_id IN(:frIdList) AND bh.bill_date BETWEEN :fromDate AND :toDate AND bd.cat_id = 5\r\n" + 
			"    GROUP BY\r\n" + 
			"        sp.sp_id,\r\n" + 
			"        bh.fr_id,\r\n" + 
			"        sp.sp_id,\r\n" + 
			"        MONTH(bh.bill_date),\r\n" + 
			"        YEAR(bh.bill_date)\r\n" + 
			")\r\n" + 
			"    ) AS i\r\n" + 
			"ORDER BY\r\n" + 
			"    cat_id,\r\n" + 
			"    sub_cat_id ", nativeQuery = true)
	List<SoldData> getBillData(@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("frIdList") List<Integer> frIdList, @Param("catIdList") List<Integer> catIdList);

}
