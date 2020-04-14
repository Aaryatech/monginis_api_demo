package com.ats.webapi.repo.salesreport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.salesreport.SubCatFrItemRepBill;

public interface SubCatFrItemRepBillRepo extends JpaRepository<SubCatFrItemRepBill, Integer> {

	@Query(value = "  SELECT UUID() as id," + 
			"        td.bill_detail_no,\n" + 
			"        SUM(td.grand_total) AS sold_amt,\n" + 
			"        SUM(td.bill_qty) AS sold_qty ,\n" + 
			"        f.fr_name,\n" + 
			"        sc.sub_cat_id,\n" + 
			"        sc.sub_cat_name ,\n" + 
			"        f.fr_id ,\n" + 
			"        m_item.id as item_id,\n" + 
			"        m_item.item_name     \n" + 
			"    FROM\n" + 
			"        t_bill_header tb,\n" + 
			"        t_bill_detail td,\n" + 
			"        m_franchisee f ,\n" + 
			"        m_cat_sub sc ,\n" + 
			"        m_item      \n" + 
			"    WHERE\n" + 
			"        tb.del_status=0          \n" + 
			"        AND tb.fr_id IN(\n" + 
			"           :frIdList \n" + 
			"        )          \n" + 
			"        AND tb.bill_no=td.bill_no          \n" + 
			"        AND tb.bill_date BETWEEN :fromDate AND :toDate \n" + 
			"        AND f.fr_id=tb.fr_id          \n" + 
			"        AND m_item.id=td.item_id          \n" + 
			"        AND m_item.item_grp2=sc.sub_cat_id   \n" + 
			"          AND td.cat_id!=5 \n" + 
			"        AND sc.sub_cat_id IN(\n" + 
			"           :subCatIdList   \n" + 
			"        )       \n" + 
			"    GROUP BY\n" + 
			"        tb.fr_id, \n" + 
			"        m_item.id   \n" + 
			"        \n" + 
			"        \n" + 
			"        UNION All\n" + 
			"        \n" + 
			"        SELECT UUID() as id," + 
			"        td.bill_detail_no,\n" + 
			"        SUM(td.grand_total) AS sold_amt,\n" + 
			"        SUM(td.bill_qty) AS sold_qty ,\n" + 
			"        f.fr_name,\n" + 
			"        sc.sub_cat_id,\n" + 
			"        sc.sub_cat_name ,\n" + 
			"        f.fr_id ,\n" + 
			"        m_sp_cake.sp_id as item_id,\n" + 
			"        m_sp_cake.sp_name as item_name     \n" + 
			"    FROM\n" + 
			"        t_bill_header tb,\n" + 
			"        t_bill_detail td,\n" + 
			"        m_franchisee f ,\n" + 
			"        m_cat_sub sc ,\n" + 
			"        m_sp_cake      \n" + 
			"    WHERE\n" + 
			"        tb.del_status=0          \n" + 
			"        AND tb.fr_id IN(\n" + 
			"         :frIdList\n" + 
			"        )          \n" + 
			"        AND tb.bill_no=td.bill_no          \n" + 
			"        AND tb.bill_date BETWEEN :fromDate AND :toDate\n" + 
			"        AND f.fr_id=tb.fr_id          \n" + 
			"        AND m_sp_cake.sp_id=td.item_id          \n" + 
			"          \n" + 
			"          AND td.cat_id=5  AND sc.cat_id=5 \n" + 
			"        AND sc.sub_cat_id IN(\n" + 
			"          :subCatIdList   \n" + 
			"        )       \n" + 
			"    GROUP BY\n" + 
			"        tb.fr_id,\n" + 
			"        m_sp_cake.sp_id   order by fr_name,sub_cat_id,item_name ", nativeQuery = true)
	List<SubCatFrItemRepBill> getData(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("frIdList") List<Integer> frIdList, @Param("subCatIdList") List<Integer> subCatIdList);

}
