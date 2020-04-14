package com.ats.webapi.repository.ggreport;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ats.webapi.model.grngvnreport.GrnGvnReportByGrnType;

public interface GrnGvnReportByGrnTypeRepo extends JpaRepository<GrnGvnReportByGrnType, Integer> {
	
	@Query(value=" SELECT " + 
			"        m_franchisee.fr_id, " + 
			"        m_franchisee.fr_name, " + 
			"        COALESCE((SELECT " + 
			"            SUM(apr_grand_total) " + 
			"        FROM  " + 
			"            t_grn_gvn " + 
			"        WHERE " + 
			"            t_grn_gvn.is_grn=1 " + 
			"            AND t_grn_gvn.grn_type=0 " + 
			"            AND t_grn_gvn. grn_gvn_status=6 " + 
			"            AND t_grn_gvn.fr_id IN (:frIdList) " + 
			"         AND t_grn_gvn.fr_id=m_franchisee.fr_id " + 
			"            AND t_grn_gvn.grn_gvn_date BETWEEN :fromDate AND :toDate GROUP BY " + 
			"        t_grn_gvn.fr_id),0) AS apr_amt_grn1," + 
			
			"       COALESCE((SELECT " + 
			"            SUM(t_grn_gvn.apr_grand_total) " + 
			"        FROM  " + 
			"            t_grn_gvn " + 
			"        WHERE " + 
			"            t_grn_gvn.is_grn=1 " + 
			"            AND t_grn_gvn.grn_type=1 " + 
			"            AND t_grn_gvn. grn_gvn_status=6 " + 
			"            AND t_grn_gvn.fr_id IN (:frIdList) " + 
			"             AND t_grn_gvn.fr_id=m_franchisee.fr_id    " + 
			"            AND t_grn_gvn.grn_gvn_date BETWEEN :fromDate AND :toDate GROUP BY " + 
			"        t_grn_gvn.fr_id), " + 
			"        0) AS apr_amt_grn2, " + 

			"        COALESCE((SELECT " + 
			"            SUM(t_grn_gvn.apr_grand_total)" + 
			"        FROM " + 
			"            t_grn_gvn " + 
			"        WHERE " + 
			"            t_grn_gvn.is_grn=1 " + 
			"            AND t_grn_gvn.grn_type IN(2,4) " + 
			"            AND t_grn_gvn. grn_gvn_status=6 " + 
			"            AND t_grn_gvn.fr_id IN (:frIdList) " + 
			"             AND t_grn_gvn.fr_id=m_franchisee.fr_id " + 
			"            AND t_grn_gvn.grn_gvn_date BETWEEN :fromDate AND :toDate GROUP BY " + 
			"        t_grn_gvn.fr_id), " + 
			"        0) AS apr_amt_grn3, " + 

			"        COALESCE((SELECT " + 
			"            SUM(t_grn_gvn.apr_grand_total)" + 
			"        FROM " + 
			"            t_grn_gvn " + 
			"        WHERE " + 
			"            t_grn_gvn.is_grn=0 " + 
			"            AND t_grn_gvn. grn_gvn_status=6 " + 
			"            AND t_grn_gvn.fr_id IN (:frIdList) " + 
			"            AND t_grn_gvn.fr_id=m_franchisee.fr_id " + 
			"            AND t_grn_gvn.grn_gvn_date BETWEEN :fromDate AND :toDate GROUP BY " + 
			"        t_grn_gvn.fr_id)," + 
			"        0) AS apr_amt_gvn " + 
			"         FROM " + 
			"        m_franchisee WHERE m_franchisee.fr_id IN (:frIdList)  AND m_franchisee.del_status=0" + 
		
			"",nativeQuery=true)
	
		List<GrnGvnReportByGrnType> getGrnGvnReportByGrnType(@Param("fromDate") 
		String fromDate,@Param("toDate") String toDate, @Param("frIdList") List<String> frIdList);
	
	@Query(value="  SELECT " + 
			"        m_franchisee.fr_id, "+ 
			"        m_franchisee.fr_name, "+ 
			"        COALESCE((SELECT  "+ 
			"            SUM(apr_grand_total) "+ 
			"        FROM  "+ 
			"            t_grn_gvn  "+ 
			"        WHERE  "+ 
			"            t_grn_gvn.is_grn=1  "+ 
			"            AND t_grn_gvn.grn_type=0  "+ 
			"            AND t_grn_gvn. grn_gvn_status=6  "+ 
			"         AND t_grn_gvn.fr_id=m_franchisee.fr_id  "+ 
			"            AND t_grn_gvn.grn_gvn_date BETWEEN :fromDate AND :toDate GROUP BY  "+ 
			"        t_grn_gvn.fr_id),0) AS apr_amt_grn1, "+ 
			"       COALESCE((SELECT  "+ 
			"            SUM(t_grn_gvn.apr_grand_total)  "+ 
			"        FROM   "+ 
			"            t_grn_gvn  "+ 
			"        WHERE  "+ 
			"            t_grn_gvn.is_grn=1  "+ 
			"            AND t_grn_gvn.grn_type=1  "+ 
			"            AND t_grn_gvn. grn_gvn_status=6  "+ 
			"             AND t_grn_gvn.fr_id=m_franchisee.fr_id     "+ 
			"            AND t_grn_gvn.grn_gvn_date BETWEEN :fromDate AND :toDate GROUP BY  "+ 
			"        t_grn_gvn.fr_id),  "+ 
			"        0) AS apr_amt_grn2,  "+ 
			"        COALESCE((SELECT  "+ 
			"            SUM(t_grn_gvn.apr_grand_total) "+ 
			"        FROM  "+ 
			"            t_grn_gvn  "+ 
			"        WHERE  "+ 
			"            t_grn_gvn.is_grn=1  "+ 
			"            AND t_grn_gvn.grn_type IN(2,4)  "+ 
			"            AND t_grn_gvn. grn_gvn_status=6  "+ 
			"             AND t_grn_gvn.fr_id=m_franchisee.fr_id  "+ 
			"            AND t_grn_gvn.grn_gvn_date BETWEEN :fromDate AND :toDate GROUP BY  "+ 
			"        t_grn_gvn.fr_id),  "+ 
			"        0) AS apr_amt_grn3,  "+ 
			"        COALESCE((SELECT  "+ 
			"            SUM(t_grn_gvn.apr_grand_total) "+ 
			"        FROM  "+ 
			"            t_grn_gvn  "+ 
			"        WHERE  "+ 
			"            t_grn_gvn.is_grn=0  "+ 
			"            AND t_grn_gvn. grn_gvn_status=6  "+ 
			"            AND t_grn_gvn.fr_id=m_franchisee.fr_id  "+ 
			"            AND t_grn_gvn.grn_gvn_date BETWEEN :fromDate AND :toDate GROUP BY  "+ 
			"        t_grn_gvn.fr_id), "+ 
			"        0) AS apr_amt_gvn  "+ 
			"         FROM  "+ 
			"        m_franchisee WHERE m_franchisee.del_status=0  " +
			"",nativeQuery=true)
	
		List<GrnGvnReportByGrnType> getGrnGvnReportByGrnTypeAllFr(@Param("fromDate") 
		String fromDate,@Param("toDate") String toDate);
	
}
