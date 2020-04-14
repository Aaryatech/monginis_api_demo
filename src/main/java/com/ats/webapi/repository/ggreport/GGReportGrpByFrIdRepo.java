package com.ats.webapi.repository.ggreport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.grngvnreport.GGReportGrpByFrId;

public interface GGReportGrpByFrIdRepo extends JpaRepository<GGReportGrpByFrId, Integer> {
	
	//sumit Sir Query report 2
	
	@Query(value=" SELECT t_grn_gvn_header.is_grn,t_grn_gvn_header.fr_id, "
			+ " sum(t_grn_gvn.apr_grand_total)as apr_grand_total, sum(t_grn_gvn.grn_gvn_amt) as total_amt,"
			+ " m_franchisee.fr_name,sum(t_grn_gvn.grn_gvn_qty) as req_qty,sum(t_grn_gvn.apr_qty_acc) " + 
			" as apr_qty from t_grn_gvn_header,m_franchisee,t_grn_gvn WHERE t_grn_gvn_header.fr_id IN (:frIdList) "
			+ " AND m_franchisee.fr_id=t_grn_gvn_header.fr_id AND t_grn_gvn_header.grngvn_date BETWEEN :fromDate and :toDate "
			+ " AND t_grn_gvn_header.is_grn IN (:isGrn) AND t_grn_gvn_header.grn_gvn_header_id=t_grn_gvn.grn_gvn_header_id AND "
			+ "t_grn_gvn.fr_id=m_franchisee.fr_id GROUP by t_grn_gvn.fr_id",nativeQuery=true)
	
		List<GGReportGrpByFrId> getGGReportGrpByFrIdSelFr(@Param("fromDate") 
		String fromDate,@Param("toDate") String toDate, @Param("isGrn") List<String> isGrn, @Param("frIdList") List<String> frIdList);
	
	//sumit Sir Query report 2 all fr Selected 

	@Query(value=" SELECT t_grn_gvn_header.is_grn,t_grn_gvn_header.fr_id, "
			+ " sum(t_grn_gvn.apr_grand_total)as apr_grand_total, sum(t_grn_gvn.grn_gvn_amt) as total_amt,"
			+ " m_franchisee.fr_name,sum(t_grn_gvn.grn_gvn_qty) as req_qty,sum(t_grn_gvn.apr_qty_acc)" + 
			" as apr_qty from t_grn_gvn_header,m_franchisee,t_grn_gvn WHERE "
			+ " m_franchisee.fr_id=t_grn_gvn_header.fr_id AND t_grn_gvn_header.grngvn_date BETWEEN :fromDate and :toDate "
			+ " AND t_grn_gvn_header.is_grn IN (:isGrn) AND t_grn_gvn_header.grn_gvn_header_id=t_grn_gvn.grn_gvn_header_id AND "
			+ " t_grn_gvn.fr_id=m_franchisee.fr_id GROUP by t_grn_gvn.fr_id",nativeQuery=true)
	
		List<GGReportGrpByFrId> getGGReportGrpByFrIdSelFrAllFr(@Param("fromDate") 
		String fromDate,@Param("toDate") String toDate, @Param("isGrn") List<String> isGrn);
	
	
	
	

}
