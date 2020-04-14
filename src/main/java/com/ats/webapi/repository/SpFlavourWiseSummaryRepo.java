package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.report.SpFlavourWiseSummaryDao;

public interface SpFlavourWiseSummaryRepo extends JpaRepository<SpFlavourWiseSummaryDao, String>{

	/*@Query(value="SELECT\r\n" + 
			"    UUID() AS uid, a.*\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        t1.sp_id AS id,\r\n" + 
			"        t1.sp_name,\r\n" + 
			"        t1.sp_selected_weight,\r\n" + 
			"        t1.sp_flavour_id,\r\n" + 
			"        t1.spf_name,\r\n" + 
			"        t1.sp_qty,\r\n" + 
			"        t1.sp_value,\r\n" + 
			"        COALESCE((t2.crn_qty),\r\n" + 
			"        0) AS crn_qty,\r\n" + 
			"        COALESCE((t2.grn_gvn_amt),\r\n" + 
			"        0) AS grn_gvn_amt\r\n" + 
			"    FROM\r\n" + 
			"        (\r\n" + 
			"        SELECT\r\n" + 
			"            t.sp_id,\r\n" + 
			"            m.sp_name,\r\n" + 
			"            t.sp_selected_weight,\r\n" + 
			"            t.sp_flavour_id,\r\n" + 
			"            f.spf_name,\r\n" + 
			"            COUNT(*) AS sp_qty,\r\n" + 
			"            SUM(t.sp_backend_rate) AS sp_value\r\n" + 
			"        FROM\r\n" + 
			"            t_sp_cake t,\r\n" + 
			"            m_sp_cake m,\r\n" + 
			"            m_sp_flavour f\r\n" + 
			"        WHERE\r\n" + 
			"            t.del_status = 0 AND m.sp_id = t.sp_id AND t.is_bill_generated = 2 AND t.sp_flavour_id = f.spf_id AND t.fr_id IN(:frId) AND t.sp_delivery_date BETWEEN :fromDate AND :toDate\r\n" + 
			"        GROUP BY\r\n" + 
			"            t.sp_flavour_id,\r\n" + 
			"            t.sp_id\r\n" + 
			"        ORDER BY\r\n" + 
			"            t.sp_id,\r\n" + 
			"            m.sp_name,\r\n" + 
			"            f.spf_name,\r\n" + 
			"            t.sp_flavour_id\r\n" + 
			"    ) t1\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        t_credit_note_details.item_id AS sp_id,\r\n" + 
			"        COUNT(*) AS crn_qty,\r\n" + 
			"        SUM(\r\n" + 
			"            t_credit_note_details.grn_gvn_amt\r\n" + 
			"        ) AS grn_gvn_amt\r\n" + 
			"    FROM\r\n" + 
			"        t_credit_note_details,\r\n" + 
			"        t_credit_note_header\r\n" + 
			"    WHERE\r\n" + 
			"        t_credit_note_details.cat_id = 5 AND t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate AND t_credit_note_header.fr_id IN(:frId) AND t_credit_note_header.crn_id = t_credit_note_details.crn_id\r\n" + 
			"    GROUP BY\r\n" + 
			"        t_credit_note_details.item_id\r\n" + 
			") t2\r\n" + 
			"ON\r\n" + 
			"    t1.sp_id = t2.sp_id\r\n" + 
			"UNION\r\n" + 
			"SELECT\r\n" + 
			"    t2.sp_id AS id,\r\n" + 
			"    t2.sp_name,\r\n" + 
			"    0 AS sp_selected_weight,\r\n" + 
			"    t1.sp_flavour_id,\r\n" + 
			"    t1.spf_name,\r\n" + 
			"    COALESCE((t1.sp_qty),\r\n" + 
			"    0) AS sp_qty,\r\n" + 
			"    COALESCE((t1.sp_value),\r\n" + 
			"    0) AS sp_value,\r\n" + 
			"    COALESCE((t2.crn_qty),\r\n" + 
			"    0) AS crn_qty,\r\n" + 
			"    COALESCE((t2.grn_gvn_amt),\r\n" + 
			"    0) AS grn_gvn_amt\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        t.sp_id,\r\n" + 
			"        m.sp_name,\r\n" + 
			"        t.sp_selected_weight,\r\n" + 
			"        t.sp_flavour_id,\r\n" + 
			"        f.spf_name,\r\n" + 
			"        COUNT(*) AS sp_qty,\r\n" + 
			"        SUM(t.sp_backend_rate) AS sp_value\r\n" + 
			"    FROM\r\n" + 
			"        t_sp_cake t,\r\n" + 
			"        m_sp_cake m,\r\n" + 
			"        m_sp_flavour f\r\n" + 
			"    WHERE\r\n" + 
			"        t.del_status = 0 AND m.sp_id = t.sp_id AND t.sp_flavour_id = f.spf_id AND t.is_bill_generated = 2 AND t.fr_id IN(:frId) AND t.sp_delivery_date BETWEEN :fromDate AND :toDate\r\n" + 
			"    GROUP BY\r\n" + 
			"        t.sp_flavour_id,\r\n" + 
			"        t.sp_id\r\n" + 
			"    ORDER BY\r\n" + 
			"        t.sp_id,\r\n" + 
			"        m.sp_name,\r\n" + 
			"        f.spf_name,\r\n" + 
			"        t.sp_flavour_id\r\n" + 
			") t1\r\n" + 
			"RIGHT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        t_credit_note_details.item_id AS sp_id,\r\n" + 
			"        COUNT(*) AS crn_qty,\r\n" + 
			"        m_sp_cake.sp_name,\r\n" + 
			"        SUM(\r\n" + 
			"            t_credit_note_details.grn_gvn_amt\r\n" + 
			"        ) AS grn_gvn_amt\r\n" + 
			"    FROM\r\n" + 
			"        t_credit_note_details,\r\n" + 
			"        t_credit_note_header,\r\n" + 
			"        m_sp_cake\r\n" + 
			"    WHERE\r\n" + 
			"        t_credit_note_details.cat_id = 5 AND t_credit_note_header.fr_id IN(:frId) AND t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate AND t_credit_note_header.crn_id = t_credit_note_details.crn_id AND m_sp_cake.sp_id = t_credit_note_details.item_id\r\n" + 
			"    GROUP BY\r\n" + 
			"        t_credit_note_details.item_id\r\n" + 
			") t2\r\n" + 
			"ON\r\n" + 
			"    t1.sp_id = t2.sp_id\r\n" + 
			") a\r\n" + 
			"ORDER BY\r\n" + 
			"    sp_name,\r\n" + 
			"    spf_name",nativeQuery=true)
	List<SpFlavourWiseSummaryDao> getFlavourSummaryReport(@Param("fromDate")String fromDate,@Param("toDate") String toDate,@Param("frId") List<Integer> frId);
*/
	
	
	
	@Query(value="SELECT\r\n" + 
			"    UUID() AS uid, a.*\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        t1.sp_id AS id,\r\n" + 
			"        t1.sp_name,\r\n" + 
			"        t1.sp_flavour_id,\r\n" + 
			"        t1.spf_name,\r\n" + 
			"        t1.sp_qty,\r\n" + 
			"        t1.sp_value,\r\n" + 
			"        COALESCE((t2.crn_qty),\r\n" + 
			"        0) AS crn_qty,\r\n" + 
			"        COALESCE((t2.grn_gvn_amt),\r\n" + 
			"        0) AS grn_gvn_amt\r\n" + 
			"    FROM\r\n" + 
			"        (\r\n" + 
			"        SELECT\r\n" + 
			"            t.sp_id,\r\n" + 
			"            m.sp_name,\r\n" + 
			"            t.sp_flavour_id,\r\n" + 
			"            f.spf_name,\r\n" + 
			"            COUNT(*) AS sp_qty,\r\n" + 
			"            SUM(t.sp_backend_rate) AS sp_value\r\n" + 
			"        FROM\r\n" + 
			"            t_sp_cake t,\r\n" + 
			"            m_sp_cake m,\r\n" + 
			"            m_sp_flavour f\r\n" + 
			"        WHERE\r\n" + 
			"            m.sp_id = t.sp_id AND t.is_bill_generated = 2 AND t.sp_flavour_id = f.spf_id AND t.fr_id IN(:frId) AND t.sp_delivery_date BETWEEN :fromDate AND :toDate\r\n" + 
			"        GROUP BY\r\n" + 
			"            t.sp_flavour_id,\r\n" + 
			"            t.sp_id\r\n" + 
			"        ORDER BY\r\n" + 
			"            t.sp_id,\r\n" + 
			"            m.sp_name,\r\n" + 
			"            f.spf_name,\r\n" + 
			"            t.sp_flavour_id\r\n" + 
			"    ) t1\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        t_credit_note_details.item_id AS sp_id,\r\n" + 
			"        COUNT(*) AS crn_qty,\r\n" + 
			"        (\r\n" + 
			"        SELECT\r\n" + 
			"            t.sp_flavour_id\r\n" + 
			"        FROM\r\n" + 
			"            t_sp_cake t\r\n" + 
			"        WHERE\r\n" + 
			"            t.sp_order_no =(\r\n" + 
			"            SELECT\r\n" + 
			"                order_id\r\n" + 
			"            FROM\r\n" + 
			"                t_bill_detail\r\n" + 
			"            WHERE\r\n" + 
			"                t_bill_detail.bill_detail_no =(\r\n" + 
			"                SELECT\r\n" + 
			"                    bill_detail_no\r\n" + 
			"                FROM\r\n" + 
			"                    t_grn_gvn\r\n" + 
			"                WHERE\r\n" + 
			"                    t_grn_gvn.grn_gvn_id = t_credit_note_details.grn_gvn_id\r\n" + 
			"            )\r\n" + 
			"        )\r\n" + 
			"    ) AS crn_flv_id,\r\n" + 
			"    SUM(\r\n" + 
			"        t_credit_note_details.grn_gvn_amt\r\n" + 
			"    ) AS grn_gvn_amt\r\n" + 
			"FROM\r\n" + 
			"    t_credit_note_details,\r\n" + 
			"    t_credit_note_header\r\n" + 
			"WHERE\r\n" + 
			"    t_credit_note_details.cat_id = 5 AND t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate AND t_credit_note_header.fr_id IN(:frId) AND t_credit_note_header.crn_id = t_credit_note_details.crn_id\r\n" + 
			"GROUP BY\r\n" + 
			"    crn_flv_id,\r\n" + 
			"    t_credit_note_details.item_id\r\n" + 
			") t2\r\n" + 
			"ON\r\n" + 
			"    t1.sp_id = t2.sp_id AND t1.sp_flavour_id = t2.crn_flv_id\r\n" + 
			"UNION\r\n" + 
			"SELECT\r\n" + 
			"    t2.sp_id AS id,\r\n" + 
			"    t2.sp_name,\r\n" + 
			"    t1.sp_flavour_id,\r\n" + 
			"    t1.spf_name,\r\n" + 
			"    COALESCE((t1.sp_qty),\r\n" + 
			"    0) AS sp_qty,\r\n" + 
			"    COALESCE((t1.sp_value),\r\n" + 
			"    0) AS sp_value,\r\n" + 
			"    COALESCE((t2.crn_qty),\r\n" + 
			"    0) AS crn_qty,\r\n" + 
			"    COALESCE((t2.grn_gvn_amt),\r\n" + 
			"    0) AS grn_gvn_amt\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        t.sp_id,\r\n" + 
			"        m.sp_name,\r\n" + 
			"        t.sp_flavour_id,\r\n" + 
			"        f.spf_name,\r\n" + 
			"        COUNT(*) AS sp_qty,\r\n" + 
			"        SUM(t.sp_backend_rate) AS sp_value\r\n" + 
			"    FROM\r\n" + 
			"        t_sp_cake t,\r\n" + 
			"        m_sp_cake m,\r\n" + 
			"        m_sp_flavour f\r\n" + 
			"    WHERE\r\n" + 
			"        t.del_status = 0 AND m.sp_id = t.sp_id AND t.sp_flavour_id = f.spf_id AND t.is_bill_generated = 2 AND t.fr_id IN(:frId) AND t.sp_delivery_date BETWEEN :fromDate AND :toDate\r\n" + 
			"    GROUP BY\r\n" + 
			"        t.sp_flavour_id,\r\n" + 
			"        t.sp_id\r\n" + 
			"    ORDER BY\r\n" + 
			"        t.sp_id,\r\n" + 
			"        m.sp_name,\r\n" + 
			"        f.spf_name,\r\n" + 
			"        t.sp_flavour_id\r\n" + 
			") t1\r\n" + 
			"RIGHT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        t_credit_note_details.item_id AS sp_id,\r\n" + 
			"        COUNT(*) AS crn_qty,\r\n" + 
			"        m_sp_cake.sp_name,\r\n" + 
			"        (\r\n" + 
			"        SELECT\r\n" + 
			"            t.sp_flavour_id\r\n" + 
			"        FROM\r\n" + 
			"            t_sp_cake t\r\n" + 
			"        WHERE\r\n" + 
			"            t.sp_order_no =(\r\n" + 
			"            SELECT\r\n" + 
			"                order_id\r\n" + 
			"            FROM\r\n" + 
			"                t_bill_detail\r\n" + 
			"            WHERE\r\n" + 
			"                t_bill_detail.bill_detail_no =(\r\n" + 
			"                SELECT\r\n" + 
			"                    bill_detail_no\r\n" + 
			"                FROM\r\n" + 
			"                    t_grn_gvn\r\n" + 
			"                WHERE\r\n" + 
			"                    t_grn_gvn.grn_gvn_id = t_credit_note_details.grn_gvn_id\r\n" + 
			"            )\r\n" + 
			"        )\r\n" + 
			"    ) AS crn_flv_id,\r\n" + 
			"    SUM(\r\n" + 
			"        t_credit_note_details.grn_gvn_amt\r\n" + 
			"    ) AS grn_gvn_amt\r\n" + 
			"FROM\r\n" + 
			"    t_credit_note_details,\r\n" + 
			"    t_credit_note_header,\r\n" + 
			"    m_sp_cake\r\n" + 
			"WHERE\r\n" + 
			"    t_credit_note_details.cat_id = 5 AND t_credit_note_header.fr_id IN(:frId) AND t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate AND t_credit_note_header.crn_id = t_credit_note_details.crn_id AND m_sp_cake.sp_id = t_credit_note_details.item_id\r\n" + 
			"GROUP BY\r\n" + 
			"    crn_flv_id,\r\n" + 
			"    t_credit_note_details.item_id\r\n" + 
			") t2\r\n" + 
			"ON\r\n" + 
			"    t1.sp_id = t2.sp_id AND t1.sp_flavour_id = t2.crn_flv_id\r\n" + 
			") a\r\n" + 
			"ORDER BY\r\n" + 
			"    sp_name,\r\n" + 
			"    spf_name",nativeQuery=true)
	List<SpFlavourWiseSummaryDao> getFlavourSummaryReport(@Param("fromDate")String fromDate,@Param("toDate") String toDate,@Param("frId") List<Integer> frId);

	

}
