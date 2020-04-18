package com.ats.webapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.saledashboard.SubCatListByCat;

public interface SubCatListByCatRepo extends JpaRepository<SubCatListByCat, Integer> {

	@Query(value="SELECT\r\n" + 
			"    t1.cat_id,\r\n" + 
			"    t1.sub_cat_id,\r\n" + 
			"    t1.sub_cat_name,\r\n" + 
			"    COALESCE(t1.sale,0) as sale,\r\n" + 
			"    COALESCE(t2.crn,0) as crn,\r\n" + 
			"    COALESCE((t1.sale - t2.crn),0) AS net\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        d.bill_detail_no,\r\n" + 
			"        d.item_id,\r\n" + 
			"        i.item_name,\r\n" + 
			"        i.item_grp1 AS cat_id,\r\n" + 
			"        i.item_grp2 AS sub_cat_id,\r\n" + 
			"        s.sub_cat_name,\r\n" + 
			"        COALESCE(SUM(d.grand_total),\r\n" + 
			"        0) AS sale\r\n" + 
			"    FROM\r\n" + 
			"        t_bill_header h,\r\n" + 
			"        t_bill_detail d,\r\n" + 
			"        m_item i,\r\n" + 
			"        m_cat_sub s\r\n" + 
			"    WHERE\r\n" + 
			"        h.bill_no = d.bill_no AND h.bill_date BETWEEN :fromDate AND :toDate AND h.del_status = 0 AND d.del_status = 0 AND d.item_id = i.id AND i.item_grp2 = s.sub_cat_id AND d.cat_id = :catId AND d.cat_id=i.item_grp1 \r\n" + 
			"    GROUP BY\r\n" + 
			"        s.sub_cat_id\r\n" + 
			") t1\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        d.crnd_id,\r\n" + 
			"        d.item_id,\r\n" + 
			"        i.item_grp2,\r\n" + 
			"        i.item_grp1,\r\n" + 
			"        COALESCE(SUM(d.grn_gvn_amt),\r\n" + 
			"        0) AS crn\r\n" + 
			"    FROM\r\n" + 
			"        t_credit_note_header h,\r\n" + 
			"        t_credit_note_details d,\r\n" + 
			"        m_item i\r\n" + 
			"    WHERE\r\n" + 
			"        h.crn_id = d.crn_id AND h.crn_date BETWEEN :fromDate AND :toDate AND d.del_status = 0 AND d.item_id = i.id AND d.cat_id = :catId AND d.cat_id=i.item_grp1\r\n" + 
			"    GROUP BY\r\n" + 
			"        i.item_grp2\r\n" + 
			") t2\r\n" + 
			"ON\r\n" + 
			"    t1.sub_cat_id = t2.item_grp2",nativeQuery=true)
	public List<SubCatListByCat> getSubCatAmtByCat( @Param("fromDate") String fromDate, @Param("toDate") String toDate,  @Param("catId") int catId);
	
	
	
	//SP CAKE CAT=5
	@Query(value="SELECT\r\n" + 
			"    t1.cat_id,\r\n" + 
			"    t1.sub_cat_id,\r\n" + 
			"    t1.sub_cat_name,\r\n" + 
			"    COALESCE(t1.sale, 0) AS sale,\r\n" + 
			"    COALESCE(t2.crn, 0) AS crn,\r\n" + 
			"    COALESCE((t1.sale - t2.crn),\r\n" + 
			"    0) AS net\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        d.bill_detail_no,\r\n" + 
			"        d.item_id,\r\n" + 
			"        i.sp_name AS item_name,\r\n" + 
			"        d.cat_id,\r\n" + 
			"        s.sub_cat_id,\r\n" + 
			"        s.sub_cat_name,\r\n" + 
			"        COALESCE(SUM(d.grand_total),\r\n" + 
			"        0) AS sale\r\n" + 
			"    FROM\r\n" + 
			"        t_bill_header h,\r\n" + 
			"        t_bill_detail d,\r\n" + 
			"        m_sp_cake i,\r\n" + 
			"        m_cat_sub s\r\n" + 
			"    WHERE\r\n" + 
			"        h.bill_no = d.bill_no AND h.bill_date BETWEEN :fromDate AND :toDate AND h.del_status = 0 AND d.del_status = 0 AND d.item_id = i.sp_id AND s.sub_cat_id = 4 AND d.cat_id = 5\r\n" + 
			"    GROUP BY\r\n" + 
			"        s.sub_cat_id\r\n" + 
			") t1\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        d.crnd_id,\r\n" + 
			"        d.item_id,\r\n" + 
			"        4 AS item_grp2,\r\n" + 
			"        COALESCE(SUM(d.grn_gvn_amt),\r\n" + 
			"        0) AS crn\r\n" + 
			"    FROM\r\n" + 
			"        t_credit_note_header h,\r\n" + 
			"        t_credit_note_details d,\r\n" + 
			"        m_sp_cake i\r\n" + 
			"    WHERE\r\n" + 
			"        h.crn_id = d.crn_id AND h.crn_date BETWEEN :fromDate AND :toDate AND d.del_status = 0 AND d.item_id = i.sp_id AND d.cat_id = 5\r\n" + 
			"    GROUP BY\r\n" + 
			"        item_grp2\r\n" + 
			") t2\r\n" + 
			"ON\r\n" + 
			"    t1.sub_cat_id = 4",nativeQuery=true)
	public List<SubCatListByCat> getSubCatAmtByCatSpCake( @Param("fromDate") String fromDate, @Param("toDate") String toDate);
	

}
