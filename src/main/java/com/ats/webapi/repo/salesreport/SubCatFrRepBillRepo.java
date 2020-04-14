package com.ats.webapi.repo.salesreport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.salesreport.SubCatFrRepBill;

public interface SubCatFrRepBillRepo extends JpaRepository<SubCatFrRepBill, Integer> {

	/*@Query(value = " SELECT  UUID() as id," + 
			"			        td.bill_detail_no,  \n" + 
			"			        SUM(td.grand_total) AS sold_amt,  \n" + 
			"			        SUM(td.bill_qty) AS sold_qty,  \n" + 
			"			        f.fr_name,  \n" + 
			"			        sc.sub_cat_id,  \n" + 
			"			        sc.sub_cat_name,  \n" + 
			"			        f.fr_id 			\n" + 
			"			    FROM  \n" + 
			"			        t_bill_header tb,  \n" + 
			"			        t_bill_detail td,  \n" + 
			"			        m_franchisee f ,  \n" + 
			"			        m_cat_sub sc ,  \n" + 
			"			        m_item        \n" + 
			"			    WHERE  \n" + 
			"			        tb.del_status=0            \n" + 
			"			        AND tb.fr_id IN(:frIdList)  \n" + 
			"			        AND tb.bill_no=td.bill_no  \n" + 
			"			        AND tb.bill_date BETWEEN :fromDate AND :toDate   \n" + 
			"			        AND f.fr_id=tb.fr_id            \n" + 
			"			        AND m_item.id=td.item_id            \n" + 
			"			        AND m_item.item_grp2=sc.sub_cat_id  and  sc.sub_cat_id IN(:subCatIdList)   \n" + 
			"			          AND td.cat_id!=5 \n" + 
			"			    GROUP BY  \n" + 
			"			        tb.fr_id,m_item.item_grp2     \n" + 
			"			          \n" + 
			"			          \n" + 
			"			        UNION All  \n" + 
			"			          \n" + 
			"			        SELECT UUID() as id," + 
			"			        td.bill_detail_no,  \n" + 
			"			        SUM(td.grand_total) AS sold_amt,  \n" + 
			"			        SUM(td.bill_qty) AS sold_qty ,  \n" + 
			"			        f.fr_name,  \n" + 
			"			        sc.sub_cat_id,  \n" + 
			"			        sc.sub_cat_name ,  \n" + 
			"			        f.fr_id  \n" + 
			"			\n" + 
			"			    FROM  \n" + 
			"			        t_bill_header tb,  \n" + 
			"			        t_bill_detail td,  \n" + 
			"			        m_franchisee f ,  \n" + 
			"			        m_cat_sub sc ,  \n" + 
			"			        m_sp_cake        \n" + 
			"			    WHERE  \n" + 
			"			        tb.del_status=0  \n" + 
			"			        AND tb.fr_id IN(:frIdList)  \n" + 
			"			        AND tb.bill_no=td.bill_no  \n" + 
			"			        AND tb.bill_date BETWEEN :fromDate AND :toDate  \n" + 
			"			        AND f.fr_id=tb.fr_id  \n" + 
			"			        AND m_sp_cake.sp_id=td.item_id  \n" + 
			"			          AND td.cat_id=5  AND sc.cat_id=5 and  sc.sub_cat_id IN(:subCatIdList)\n" + 
			"			    GROUP BY  \n" + 
			"			        tb.fr_id,sc.sub_cat_id", nativeQuery = true)
	List<SubCatFrRepBill> getData(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("frIdList") List<Integer> frIdList, @Param("subCatIdList") List<Integer> subCatIdList);*/
	
	
	
	@Query(value = " SELECT\n" + 
			"    id,\n" + 
			"    bill_detail_no,\n" + 
			"    sold_amt,\n" + 
			"    sold_qty,\n" + 
			"    fr_name,\n" + 
			"    sub_cat_id,\n" + 
			"    sub_cat_name,\n" + 
			"    fr_id,\n" + 
			"    cat_id\n" + 
			"FROM\n" + 
			"    (\n" + 
			"    SELECT\n" + 
			"        UUID() AS id, td.bill_detail_no, SUM(td.grand_total) AS sold_amt,\n" + 
			"        SUM(td.bill_qty) AS sold_qty,\n" + 
			"        f.fr_name,\n" + 
			"        sc.sub_cat_id,\n" + 
			"        sc.sub_cat_name,\n" + 
			"        f.fr_id,\n" + 
			"        td.cat_id\n" + 
			"    FROM\n" + 
			"        t_bill_header tb,\n" + 
			"        t_bill_detail td,\n" + 
			"        m_franchisee f,\n" + 
			"        m_cat_sub sc,\n" + 
			"        m_item\n" + 
			"    WHERE\n" + 
			"        tb.del_status = 0 AND tb.fr_id IN(:frIdList) AND tb.bill_no = td.bill_no AND tb.bill_date BETWEEN :fromDate AND :toDate AND f.fr_id = tb.fr_id AND m_item.id = td.item_id AND m_item.item_grp2 = sc.sub_cat_id AND sc.sub_cat_id IN(:subCatIdList) AND td.cat_id != 5\n" + 
			"    GROUP BY\n" + 
			"        tb.fr_id,\n" + 
			"        m_item.item_grp2\n" + 
			"    UNION ALL\n" + 
			"SELECT\n" + 
			"    UUID() AS id, td.bill_detail_no, SUM(td.grand_total) AS sold_amt,\n" + 
			"    SUM(td.bill_qty) AS sold_qty,\n" + 
			"    f.fr_name,\n" + 
			"    sc.sub_cat_id,\n" + 
			"    sc.sub_cat_name,\n" + 
			"    f.fr_id,\n" + 
			"    td.cat_id\n" + 
			"FROM\n" + 
			"    t_bill_header tb,\n" + 
			"    t_bill_detail td,\n" + 
			"    m_franchisee f,\n" + 
			"    m_cat_sub sc,\n" + 
			"    m_sp_cake\n" + 
			"WHERE\n" + 
			"    tb.del_status = 0 AND tb.fr_id IN(:frIdList) AND tb.bill_no = td.bill_no AND tb.bill_date BETWEEN :fromDate AND :toDate AND f.fr_id = tb.fr_id AND m_sp_cake.sp_id = td.item_id AND td.cat_id = 5 AND sc.cat_id = 5 AND sc.sub_cat_id IN(:subCatIdList)\n" + 
			"GROUP BY\n" + 
			"    tb.fr_id,\n" + 
			"    sc.sub_cat_id) a\n" + 
			"ORDER BY\n" + 
			"    a.fr_name,\n" + 
			"    a.cat_id,\n" + 
			"    a.sub_cat_name", nativeQuery = true)
	List<SubCatFrRepBill> getData(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("frIdList") List<Integer> frIdList, @Param("subCatIdList") List<Integer> subCatIdList);

}
