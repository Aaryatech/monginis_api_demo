package com.ats.webapi.model.opstock;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustListRepo extends JpaRepository<CustList, Integer> {

	@Query(value = "  SELECT  DISTINCT b.user_phone , b.user_name,b.user_gst_no  FROM \n"
			+ "(SELECT  DISTINCT b.user_phone , b.user_name,b.user_gst_no  FROM t_sell_bill_header b WHERE b.del_status=0\n"
			+ "UNION\n"
			+ "SELECT DISTINCT s.sp_cust_mob_no As user_phone, s.sp_cust_name AS user_name ,s.sp_cust_dob  AS  user_gst_no FROM t_sp_cake s WHERE s.del_status=0) b WHERE trim(coalesce( b.user_phone, '')) <>''", nativeQuery = true)
	List<CustList> getOpStockAdjReport();

	@Query(value = "SELECT\n" + 
			"        DISTINCT b.user_phone ,\n" + 
			"        b.user_name,\n" + 
			"        b.user_gst_no  \n" + 
			"    FROM\n" + 
			"        (SELECT\n" + 
			"            DISTINCT b.user_phone ,\n" + 
			"            b.user_name,\n" + 
			"            b.user_gst_no  \n" + 
			"        FROM\n" + 
			"            t_sell_bill_header b \n" + 
			"        WHERE\n" + 
			"            b.del_status=0 \n" + 
			"            AND b.fr_id=:frId \n" + 
			"        UNION\n" + 
			"        SELECT\n" + 
			"            DISTINCT s.sp_cust_mob_no As user_phone,\n" + 
			"            s.sp_cust_name AS user_name ,\n" + 
			"            '-'  AS  user_gst_no \n" + 
			"        FROM\n" + 
			"            t_sp_cake s \n" + 
			"        WHERE\n" + 
			"            s.del_status=0  \n" + 
			"            AND s.fr_id=:frId\n" + 
			"    ) b \n" + 
			"WHERE\n" + 
			"    trim(coalesce( b.user_phone, '')) <>''\n" + 
			"group by \n" + 
			"    user_phone", nativeQuery = true)
	List<CustList> getOpStockAdjReportByfrId(@Param("frId") int frId);
}
