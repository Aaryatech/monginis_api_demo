package com.ats.webapi.repository.salesreturnreport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.salesvaluereport.SalesReturnQtyDao;
import com.ats.webapi.model.salesvaluereport.SalesReturnQtyReportList;

@Repository
public interface SalesReturnQtyDaoRepository extends JpaRepository<SalesReturnQtyDao, Integer>{

//	@Query(value="select CONCAT(:month,\"\",sub_cat_id) as id,sub_cat_id,coalesce((SELECT  SUM(t_bill_detail.bill_qty) as bill_qty   FROM    t_bill_detail,t_bill_header,m_item    WHERE   DATE_FORMAT(t_bill_header.bill_date,'%Y-%m')=:month  AND t_bill_header.del_status=0 And t_bill_header.bill_no=t_bill_detail.bill_no and t_bill_detail.cat_id!=5 and m_item.item_grp2=m_cat_sub.sub_cat_id and m_item.id=t_bill_detail.item_id),0) as bill_qty,\n" + 
//			"\n" + 
//			"coalesce((select SUM(grn_gvn_qty) as grn_qty from t_credit_note_header,t_credit_note_details,m_item where t_credit_note_header.crn_id=t_credit_note_details.crn_id and t_credit_note_header.is_grn=1 and DATE_FORMAT(t_credit_note_header.crn_date,'%Y-%m')=:month and t_credit_note_details.cat_id!=5 and m_item.id=t_credit_note_details.item_id and m_item.item_grp2=m_cat_sub.sub_cat_id),0) as grn_qty,\n" + 
//			"\n" + 
//			"coalesce((select SUM(grn_gvn_qty) as gvn_qty from t_credit_note_header,t_credit_note_details,m_item where t_credit_note_header.crn_id=t_credit_note_details.crn_id  and DATE_FORMAT(t_credit_note_header.crn_date,'%Y-%m')=:month and t_credit_note_header.is_grn=0 and t_credit_note_details.cat_id!=5 and m_item.id=t_credit_note_details.item_id and m_item.item_grp2=m_cat_sub.sub_cat_id),0) as gvn_qty\n" + 
//			"\n" + 
//			"from m_cat_sub where m_cat_sub.cat_id!=5 and m_cat_sub.del_status=0\n" + 
//			"\n" + 
//			"UNION ALL\n" + 
//			"select  CONCAT(:month,\"\",sub_cat_id) as id,m_cat_sub.sub_cat_id,coalesce((SELECT\n" + 
//			"        SUM(t_bill_detail.bill_qty) as bill_qty\n" + 
//			"          FROM\n" + 
//			"        t_bill_detail,t_bill_header,m_sp_cake\n" + 
//			"    WHERE\n" + 
//			"        DATE_FORMAT(t_bill_header.bill_date,'%Y-%m')=:month \n" + 
//			"        AND t_bill_header.del_status=0 And t_bill_header.bill_no=t_bill_detail.bill_no and t_bill_detail.cat_id=5 and  m_sp_cake.sp_id=t_bill_detail.item_id),0) as bill_qty,\n" + 
//			"        0 as grn_qty,\n" + 
//			"        coalesce((select SUM(grn_gvn_qty) as gvn_qty from t_credit_note_header,t_credit_note_details,m_sp_cake where t_credit_note_header.crn_id=t_credit_note_details.crn_id and t_credit_note_header.is_grn=0 and DATE_FORMAT(t_credit_note_header.crn_date,'%Y-%m')=:month and t_credit_note_details.cat_id=5 and m_sp_cake.sp_id=t_credit_note_details.item_id),0) as gvn_qty\n" + 
//			"        from m_cat_sub where m_cat_sub.cat_id=5 and m_cat_sub.del_status=0",nativeQuery=true)
//	List<SalesReturnQtyDao> getSalesReturnQtyReport(@Param("month")String month);

	@Query(value="SELECT\n" + 
			"    CONCAT(:month, '', s.sub_cat_id) AS id,\n" + 
			"    s.sub_cat_id,\n" + 
			"    COALESCE(t1.bill_qty, 0) AS bill_qty,\n" + 
			"    COALESCE(t2.grn_qty, 0) AS grn_qty,\n" + 
			"    COALESCE(t3.gvn_qty, 0) AS gvn_qty\n" + 
			"FROM\n" + 
			"    (\n" + 
			"    SELECT\n" + 
			"        *\n" + 
			"    FROM\n" + 
			"        m_cat_sub s\n" + 
			"    WHERE\n" + 
			"        s.cat_id != 5 AND s.del_status = 0\n" + 
			") s\n" + 
			"LEFT JOIN(\n" + 
			"    SELECT\n" + 
			"        i.item_grp2 AS sub_cat_id,\n" + 
			"        COALESCE(SUM(d.bill_qty),\n" + 
			"        0) AS bill_qty\n" + 
			"    FROM\n" + 
			"        t_bill_detail d,\n" + 
			"        t_bill_header h,\n" + 
			"        m_item i,\n" + 
			"        m_franchisee f\n" + 
			"    WHERE\n" + 
			"        DATE_FORMAT(h.bill_date, '%Y-%m') = :month AND h.del_status = 0 AND h.bill_no = d.bill_no AND d.cat_id != 5 AND i.id = d.item_id AND h.fr_id = f.fr_id AND f.del_status = 0\n" + 
			"    GROUP BY\n" + 
			"        i.item_grp2\n" + 
			") t1\n" + 
			"ON\n" + 
			"    s.sub_cat_id = t1.sub_cat_id\n" + 
			"LEFT JOIN(\n" + 
			"    SELECT\n" + 
			"        i.item_grp2 AS sub_cat_id,\n" + 
			"        SUM(grn_gvn_qty) AS grn_qty\n" + 
			"    FROM\n" + 
			"        t_credit_note_header h,\n" + 
			"        t_credit_note_details d,\n" + 
			"        m_item i,\n" + 
			"        m_franchisee f\n" + 
			"    WHERE\n" + 
			"        h.crn_id = d.crn_id AND h.is_grn = 1 AND DATE_FORMAT(h.crn_date, '%Y-%m') = :month AND d.cat_id != 5 AND i.id = d.item_id AND h.fr_id = f.fr_id AND f.del_status = 0\n" + 
			"    GROUP BY\n" + 
			"        i.item_grp2\n" + 
			") t2\n" + 
			"ON\n" + 
			"    s.sub_cat_id = t2.sub_cat_id\n" + 
			"LEFT JOIN(\n" + 
			"    SELECT\n" + 
			"        i.item_grp2 AS sub_cat_id,\n" + 
			"        SUM(grn_gvn_qty) AS gvn_qty\n" + 
			"    FROM\n" + 
			"        t_credit_note_header h,\n" + 
			"        t_credit_note_details d,\n" + 
			"        m_item i,\n" + 
			"        m_franchisee f\n" + 
			"    WHERE\n" + 
			"        h.crn_id = d.crn_id AND h.is_grn = 0 AND DATE_FORMAT(h.crn_date, '%Y-%m') = :month AND d.cat_id != 5 AND i.id = d.item_id AND h.fr_id = f.fr_id AND f.del_status = 0\n" + 
			"    GROUP BY\n" + 
			"        i.item_grp2\n" + 
			") t3\n" + 
			"ON\n" + 
			"    s.sub_cat_id = t3.sub_cat_id\n" + 
			"UNION ALL\n" + 
			"SELECT\n" + 
			"    CONCAT(:month, '', s.sub_cat_id) AS id,\n" + 
			"    s.sub_cat_id,\n" + 
			"    COALESCE(t1.bill_qty, 0) AS bill_qty,\n" + 
			"    COALESCE(t2.grn_qty, 0) AS grn_qty,\n" + 
			"    COALESCE(t3.gvn_qty, 0) AS gvn_qty\n" + 
			"FROM\n" + 
			"    (\n" + 
			"    SELECT\n" + 
			"        *\n" + 
			"    FROM\n" + 
			"        m_cat_sub s\n" + 
			"    WHERE\n" + 
			"        s.cat_id = 5 AND s.del_status = 0\n" + 
			") s\n" + 
			"LEFT JOIN(\n" + 
			"    SELECT\n" + 
			"        54 AS sub_cat_id,\n" + 
			"        COALESCE(SUM(d.bill_qty),\n" + 
			"        0) AS bill_qty\n" + 
			"    FROM\n" + 
			"        t_bill_detail d,\n" + 
			"        t_bill_header h,\n" + 
			"        m_sp_cake i,\n" + 
			"        m_franchisee f\n" + 
			"    WHERE\n" + 
			"        DATE_FORMAT(h.bill_date, '%Y-%m') = :month AND h.del_status = 0 AND h.bill_no = d.bill_no AND d.cat_id = 5 AND i.sp_id = d.item_id AND h.fr_id = f.fr_id AND f.del_status = 0\n" + 
			") t1\n" + 
			"ON\n" + 
			"    s.sub_cat_id = t1.sub_cat_id\n" + 
			"LEFT JOIN(\n" + 
			"    SELECT\n" + 
			"        54 AS sub_cat_id,\n" + 
			"        SUM(grn_gvn_qty) AS grn_qty\n" + 
			"    FROM\n" + 
			"        t_credit_note_header h,\n" + 
			"        t_credit_note_details d,\n" + 
			"        m_sp_cake i,\n" + 
			"        m_franchisee f\n" + 
			"    WHERE\n" + 
			"        h.crn_id = d.crn_id AND h.is_grn = 1 AND DATE_FORMAT(h.crn_date, '%Y-%m') = :month AND d.cat_id = 5 AND i.sp_id = d.item_id AND h.fr_id = f.fr_id AND f.del_status = 0\n" + 
			") t2\n" + 
			"ON\n" + 
			"    s.sub_cat_id = t2.sub_cat_id\n" + 
			"LEFT JOIN(\n" + 
			"    SELECT\n" + 
			"        54 AS sub_cat_id,\n" + 
			"        SUM(grn_gvn_qty) AS gvn_qty\n" + 
			"    FROM\n" + 
			"        t_credit_note_header h,\n" + 
			"        t_credit_note_details d,\n" + 
			"        m_sp_cake i,\n" + 
			"        m_franchisee f\n" + 
			"    WHERE\n" + 
			"        h.crn_id = d.crn_id AND h.is_grn = 0 AND DATE_FORMAT(h.crn_date, '%Y-%m') = :month AND d.cat_id = 5 AND i.sp_id = d.item_id AND h.fr_id = f.fr_id AND f.del_status = 0\n" + 
			") t3\n" + 
			"ON\n" + 
			"    s.sub_cat_id = t3.sub_cat_id",nativeQuery=true)
	List<SalesReturnQtyDao> getSalesReturnQtyReport(@Param("month")String month);
	
}
