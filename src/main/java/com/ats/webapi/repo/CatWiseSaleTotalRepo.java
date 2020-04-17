package com.ats.webapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.saledashboard.CatWiseSaleTotal;

public interface CatWiseSaleTotalRepo extends JpaRepository<CatWiseSaleTotal, Integer> {

	@Query(value="SELECT\r\n" + 
			"    COALESCE(SUM(d.grand_total),0) as total,d.cat_id,c.cat_name\r\n" + 
			"FROM\r\n" + 
			"    t_bill_header h,t_bill_detail d,m_category c\r\n" + 
			"WHERE\r\n" + 
			"    h.bill_no=d.bill_no AND d.cat_id=c.cat_id AND h.bill_date BETWEEN :fromDate AND :toDate AND h.del_status = 0 AND d.del_status=0\r\n" + 
			"    GROUP BY d.cat_id\r\n" + 
			"    ORDER BY total",nativeQuery=true)
	public List<CatWiseSaleTotal> getCatWiseSaleAmt( @Param("fromDate") String fromDate, @Param("toDate") String toDate);
	
	
	@Query(value="SELECT\r\n" + 
			"    COALESCE(SUM(d.grn_gvn_amt),0) as total,d.cat_id,c.cat_name\r\n" + 
			"FROM\r\n" + 
			"    t_credit_note_header h,t_credit_note_details d,m_category c\r\n" + 
			"WHERE\r\n" + 
			"    h.crn_id=d.crn_id AND d.cat_id=c.cat_id AND h.crn_date BETWEEN :fromDate AND :toDate \r\n" + 
			"    GROUP BY d.cat_id\r\n" + 
			"    ORDER BY total",nativeQuery=true)
	public List<CatWiseSaleTotal> getCatWiseCRNAmt( @Param("fromDate") String fromDate, @Param("toDate") String toDate);
	
	
	@Query(value="SELECT\r\n" + 
			"    t1.cat_id,\r\n" + 
			"    t1.cat_name,\r\n" + 
			"    COALESCE(t1.total - t2.total, 0) AS total\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        COALESCE(SUM(d.grand_total),\r\n" + 
			"        0) AS total,\r\n" + 
			"        d.cat_id,\r\n" + 
			"        c.cat_name\r\n" + 
			"    FROM\r\n" + 
			"        t_bill_header h,\r\n" + 
			"        t_bill_detail d,\r\n" + 
			"        m_category c\r\n" + 
			"    WHERE\r\n" + 
			"        h.bill_no = d.bill_no AND d.cat_id = c.cat_id AND h.bill_date BETWEEN :fromDate AND :toDate AND h.del_status = 0 AND d.del_status = 0\r\n" + 
			"    GROUP BY\r\n" + 
			"        d.cat_id\r\n" + 
			"    ORDER BY\r\n" + 
			"        total\r\n" + 
			"    DESC\r\n" + 
			") t1\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT COALESCE(SUM(d.grn_gvn_amt),\r\n" + 
			"        0) AS total,\r\n" + 
			"        d.cat_id,\r\n" + 
			"        c.cat_name\r\n" + 
			"    FROM\r\n" + 
			"        t_credit_note_header h,\r\n" + 
			"        t_credit_note_details d,\r\n" + 
			"        m_category c\r\n" + 
			"    WHERE\r\n" + 
			"        h.crn_id = d.crn_id AND d.cat_id = c.cat_id AND h.crn_date BETWEEN :fromDate AND :toDate\r\n" + 
			"    GROUP BY\r\n" + 
			"        d.cat_id\r\n" + 
			"    ORDER BY\r\n" + 
			"        total\r\n" + 
			"    DESC\r\n" + 
			") t2\r\n" + 
			"ON\r\n" + 
			"    t1.cat_id = t2.cat_id ORDER BY total",nativeQuery=true)
	public List<CatWiseSaleTotal> getCatWiseNetAmt( @Param("fromDate") String fromDate, @Param("toDate") String toDate);
	
	

}
