package com.ats.webapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.saledashboard.ItemListBySubCat;

public interface ItemListBySubCatRepo extends JpaRepository<ItemListBySubCat, Integer> {

	@Query(value="SELECT\r\n" + 
			"    t1.item_id,\r\n" + 
			"    t1.item_name,\r\n" + 
			"    t1.cat_id,\r\n" + 
			"    t1.sub_cat_id,\r\n" + 
			"    COALESCE(t1.sale, 0) AS sale,\r\n" + 
			"    COALESCE(t1.sale_qty, 0) AS sale_qty,\r\n" + 
			"    COALESCE(t2.crn, 0) AS crn,\r\n" + 
			"    COALESCE(t2.crn_qty, 0) AS crn_qty,\r\n" + 
			"     COALESCE((t1.sale - COALESCE(t2.crn,0)),\r\n" + 
			"    0) AS net,\r\n" + 
			"    COALESCE((t1.sale_qty - COALESCE(t2.crn_qty,0)),\r\n" + 
			"    0) AS net_qty\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        d.bill_detail_no,\r\n" + 
			"        d.item_id,\r\n" + 
			"        i.item_name,\r\n" + 
			"        i.item_grp1 AS cat_id,\r\n" + 
			"        i.item_grp2 AS sub_cat_id,\r\n" + 
			"        SUM(d.grand_total) AS sale,\r\n" + 
			"        SUM(d.order_qty) AS sale_qty\r\n" + 
			"    FROM\r\n" + 
			"        t_bill_header h,\r\n" + 
			"        t_bill_detail d,\r\n" + 
			"        m_item i\r\n" + 
			"    WHERE\r\n" + 
			"        h.bill_no = d.bill_no AND h.bill_date BETWEEN :fromDate AND :toDate AND h.del_status = 0 AND d.del_status = 0 AND d.item_id = i.id AND i.item_grp2 = :subCatId AND d.cat_id != 5\r\n" + 
			"    GROUP BY\r\n" + 
			"        d.item_id\r\n" + 
			") t1\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        d.crnd_id,\r\n" + 
			"        d.item_id,\r\n" + 
			"        i.item_name,\r\n" + 
			"        i.item_grp1 AS cat_id,\r\n" + 
			"        i.item_grp2 AS sub_cat_id,\r\n" + 
			"        SUM(d.grn_gvn_amt) AS crn,\r\n" + 
			"        SUM(d.grn_gvn_qty) AS crn_qty\r\n" + 
			"    FROM\r\n" + 
			"        t_credit_note_header h,\r\n" + 
			"        t_credit_note_details d,\r\n" + 
			"        m_item i\r\n" + 
			"    WHERE\r\n" + 
			"        h.crn_id = d.crn_id AND h.crn_date BETWEEN :fromDate AND :toDate AND d.del_status = 0 AND d.item_id = i.id AND i.item_grp2 = :subCatId AND d.cat_id != 5\r\n" + 
			"    GROUP BY\r\n" + 
			"        d.item_id\r\n" + 
			") t2\r\n" + 
			"ON\r\n" + 
			"    t1.item_id = t2.item_id\r\n" + 
			"UNION\r\n" + 
			"SELECT\r\n" + 
			"    d.item_id,\r\n" + 
			"    i.item_name,\r\n" + 
			"    i.item_grp1 AS cat_id,\r\n" + 
			"    i.item_grp2 AS sub_cat_id,\r\n" + 
			"    0 AS sale,\r\n" + 
			"    0 AS sale_qty,\r\n" + 
			"    SUM(d.grn_gvn_amt) AS crn,\r\n" + 
			"    SUM(d.grn_gvn_qty) AS crn_qty,\r\n" + 
			"    - SUM(d.grn_gvn_amt) AS net,\r\n" + 
			"    - SUM(d.grn_gvn_qty) AS net_qty\r\n" + 
			"FROM\r\n" + 
			"    t_credit_note_header h,\r\n" + 
			"    t_credit_note_details d,\r\n" + 
			"    m_item i\r\n" + 
			"WHERE\r\n" + 
			"    h.crn_id = d.crn_id AND h.crn_date BETWEEN :fromDate AND :toDate AND d.del_status = 0 AND d.item_id = i.id AND i.item_grp2 = :subCatId AND d.cat_id != 5 AND d.item_id NOT IN(\r\n" + 
			"    SELECT\r\n" + 
			"        d.item_id\r\n" + 
			"    FROM\r\n" + 
			"        t_bill_header h,\r\n" + 
			"        t_bill_detail d,\r\n" + 
			"        m_item i\r\n" + 
			"    WHERE\r\n" + 
			"        h.bill_no = d.bill_no AND h.bill_date BETWEEN :fromDate AND :toDate AND h.del_status = 0 AND d.del_status = 0 AND d.item_id = i.id AND i.item_grp2 = :subCatId AND d.cat_id != 5\r\n" + 
			"    GROUP BY\r\n" + 
			"        d.item_id\r\n" + 
			")\r\n" + 
			"GROUP BY\r\n" + 
			"    d.item_id",nativeQuery=true)
	public List<ItemListBySubCat> getItemListBySubCat( @Param("fromDate") String fromDate, @Param("toDate") String toDate,  @Param("subCatId") int subCatId);
	
	
	
	@Query(value="SELECT\r\n" + 
			"    t1.item_id,\r\n" + 
			"    t1.item_name,\r\n" + 
			"    t1.cat_id,\r\n" + 
			"    t1.sub_cat_id,\r\n" + 
			"    COALESCE(t1.sale, 0) AS sale,\r\n" + 
			"    COALESCE(t1.sale_qty, 0) AS sale_qty,\r\n" + 
			"    COALESCE(t2.crn, 0) AS crn,\r\n" + 
			"    COALESCE(t2.crn_qty, 0) AS crn_qty,\r\n" + 
			"     COALESCE((t1.sale - COALESCE(t2.crn,0)),  \r\n" + 
			"			    0) AS net,  \r\n" + 
			"			    COALESCE((t1.sale_qty - COALESCE(t2.crn_qty,0)),  \r\n" + 
			"			    0) AS net_qty \r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        d.bill_detail_no,\r\n" + 
			"        d.item_id,\r\n" + 
			"        i.sp_name AS item_name,\r\n" + 
			"        5 AS cat_id,\r\n" + 
			"        5 AS sub_cat_id,\r\n" + 
			"        SUM(d.grand_total) AS sale,\r\n" + 
			"        SUM(d.order_qty) AS sale_qty\r\n" + 
			"    FROM\r\n" + 
			"        t_bill_header h,\r\n" + 
			"        t_bill_detail d,\r\n" + 
			"        m_sp_cake i\r\n" + 
			"    WHERE\r\n" + 
			"        h.bill_no = d.bill_no AND h.bill_date BETWEEN :fromDate AND :toDate AND h.del_status = 0 AND d.del_status = 0 AND d.item_id = i.sp_id AND d.cat_id = 5\r\n" + 
			"    GROUP BY\r\n" + 
			"        d.item_id\r\n" + 
			") t1\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        d.crnd_id,\r\n" + 
			"        d.item_id,\r\n" + 
			"        i.sp_name AS item_name,\r\n" + 
			"        5 AS cat_id,\r\n" + 
			"        5 AS sub_cat_id,\r\n" + 
			"        SUM(d.grn_gvn_amt) AS crn,\r\n" + 
			"        SUM(d.grn_gvn_qty) AS crn_qty\r\n" + 
			"    FROM\r\n" + 
			"        t_credit_note_header h,\r\n" + 
			"        t_credit_note_details d,\r\n" + 
			"        m_sp_cake i\r\n" + 
			"    WHERE\r\n" + 
			"        h.crn_id = d.crn_id AND h.crn_date BETWEEN :fromDate AND :toDate AND d.del_status = 0 AND d.item_id = i.sp_id AND d.cat_id = 5\r\n" + 
			"    GROUP BY\r\n" + 
			"        d.item_id\r\n" + 
			") t2\r\n" + 
			"ON\r\n" + 
			"    t1.item_id = t2.item_id",nativeQuery=true)
	public List<ItemListBySubCat> getItemListBySubCatSpCake( @Param("fromDate") String fromDate, @Param("toDate") String toDate);
	

}
