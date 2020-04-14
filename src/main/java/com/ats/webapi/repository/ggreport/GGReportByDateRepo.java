package com.ats.webapi.repository.ggreport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.grngvnreport.GGReportByDate;

public interface GGReportByDateRepo extends JpaRepository<GGReportByDate, Integer>{

	
	//r1 group by date
	//r1
	@Query(value=" SELECT t_grn_gvn_header.grn_gvn_header_id,t_grn_gvn_header.grngvn_srno,"
			+ " t_grn_gvn_header.grngvn_date,t_grn_gvn_header.is_grn,t_grn_gvn_header.fr_id,"
			+ " t_grn_gvn_header.apr_grand_total, t_grn_gvn_header.total_amt , "
			+ " sum(t_grn_gvn.grn_gvn_qty) as req_qty, sum(t_grn_gvn.apr_qty_acc) as apr_qty, "
			+ " m_franchisee.fr_name from t_grn_gvn_header,t_grn_gvn, m_franchisee "
			+ " WHERE m_franchisee.fr_id=t_grn_gvn_header.fr_id and t_grn_gvn_header.fr_id IN ( :frIdList) "
			+ " AND t_grn_gvn_header.grngvn_date BETWEEN :fromDate and :toDate AND t_grn_gvn_header.is_grn IN ( :isGrn) "
			+ " AND t_grn_gvn_header.grn_gvn_header_id=t_grn_gvn.grn_gvn_header_id "
			+ " GROUP BY t_grn_gvn_header.grn_gvn_header_id order by t_grn_gvn_header.grngvn_date ",nativeQuery=true)
	
		List<GGReportByDate> getGrnGvnReportByDateSelFr(@Param("fromDate") 
		String fromDate,@Param("toDate") 
		String toDate,@Param("frIdList") List<String> frIdList,@Param("isGrn") List<String> isGrn);
	
	
	@Query(value=" SELECT t_grn_gvn_header.grn_gvn_header_id, from t_grn_gvn_header "
			+ " WHERE t_grn_gvn_header.is_grn= 1 AND t_grn_gvn_header.fr_id=17  "
			+ " group by t_grn_gvn_header.grn_gvn_header_id ",nativeQuery=true)
	
		List<GGReportByDate> hardcode();
	
	
	
	/*@Query(value=" SELECT t_grn_gvn_header.grn_gvn_header_id,t_grn_gvn_header.grngvn_srno,"
			+ " t_grn_gvn_header.grngvn_date,t_grn_gvn_header.is_grn,t_grn_gvn_header.fr_id,"
			+ " t_grn_gvn_header.apr_grand_total, t_grn_gvn_header.total_amt , "
			+ " sum(t_grn_gvn.grn_gvn_qty) as req_qty, sum(t_grn_gvn.apr_qty_acc) as apr_qty, "
			+ " m_franchisee.fr_name from t_grn_gvn_header,t_grn_gvn, m_franchisee "
			+ " WHERE m_franchisee.fr_id=t_grn_gvn_header.fr_id and t_grn_gvn_header.fr_id =17 "
			+ "  AND t_grn_gvn_header.is_grn= 1 "
			+ " AND t_grn_gvn_header.grn_gvn_header_id=t_grn_gvn.grn_gvn_header_id group by t_grn_gvn_header.grn_gvn_header_id ",nativeQuery=true)
	
		List<GGReportByDate> hardcode();
	*/
	
	
//r1
	@Query(value=" SELECT t_grn_gvn_header.grn_gvn_header_id,t_grn_gvn_header.grngvn_srno,"
			+ " t_grn_gvn_header.grngvn_date,t_grn_gvn_header.is_grn,t_grn_gvn_header.fr_id,"
			+ " t_grn_gvn_header.apr_grand_total, t_grn_gvn_header.total_amt , "
			+ " sum(t_grn_gvn.grn_gvn_qty) as req_qty, sum(t_grn_gvn.apr_qty_acc) as apr_qty, "
			+ " m_franchisee.fr_name  from t_grn_gvn_header,t_grn_gvn, m_franchisee "
			+ " WHERE m_franchisee.fr_id=t_grn_gvn_header.fr_id  "
			+ " AND t_grn_gvn_header.grngvn_date BETWEEN :fromDate and :toDate AND t_grn_gvn_header.is_grn IN (:isGrn) "
			+ " AND t_grn_gvn_header.grn_gvn_header_id=t_grn_gvn.grn_gvn_header_id "
			+ " GROUP BY t_grn_gvn_header.grn_gvn_header_id order by t_grn_gvn_header.grngvn_date  ",nativeQuery=true)
	
		List<GGReportByDate> getGrnGvnReportByDateAllFr(@Param("fromDate") 
		String fromDate,@Param("toDate") 
		String toDate,@Param("isGrn") List<String> isGrn);
	
	//r1
	
	@Query(value=" SELECT t_grn_gvn_header.grn_gvn_header_id,t_grn_gvn_header.grngvn_srno,"
			+ "t_grn_gvn_header.grngvn_date,t_grn_gvn_header.is_grn,t_grn_gvn_header.fr_id,"
			+ "t_grn_gvn_header.apr_grand_total, t_grn_gvn_header.total_amt , "
			+ "sum(t_grn_gvn.grn_gvn_qty) as reqQty, sum(t_grn_gvn.apr_qty_acc) as aprQty, "
			+ "m_franchisee.fr_name  from t_grn_gvn_header,t_grn_gvn, m_franchisee "
			+ "WHERE m_franchisee.fr_id=t_grn_gvn_header.fr_id and t_grn_gvn_header.fr_id IN(:frIdList) "
			+ "AND t_grn_gvn_header.grngvn_date BETWEEN :fromDate and :toDate "
			+ " AND t_grn_gvn_header.grn_gvn_header_id=t_grn_gvn.grn_gvn_header_id "
			+ "GROUP BY t_grn_gvn_header.grn_gvn_header_id order by t_grn_gvn_header.grngvn_date  ",nativeQuery=true)
	
		List<GGReportByDate> getGrnGvnReportByDateSelFrAllGG(@Param("fromDate") 
		String fromDate,@Param("toDate") 
		String toDate,@Param("frIdList") List<String> frIdList);
	
//r1
	@Query(value=" SELECT t_grn_gvn_header.grn_gvn_header_id,t_grn_gvn_header.grngvn_srno,"
			+ "t_grn_gvn_header.grngvn_date,t_grn_gvn_header.is_grn,t_grn_gvn_header.fr_id,"
			+ "t_grn_gvn_header.apr_grand_total, t_grn_gvn_header.total_amt , "
			+ "sum(t_grn_gvn.grn_gvn_qty) as reqQty, sum(t_grn_gvn.apr_qty_acc) as aprQty, "
			+ "m_franchisee.fr_name from t_grn_gvn_header,t_grn_gvn, m_franchisee "
			+ "WHERE m_franchisee.fr_id=t_grn_gvn_header.fr_id  "
			+ "AND t_grn_gvn_header.grngvn_date BETWEEN :fromDate and :toDate  "
			+ " AND t_grn_gvn_header.grn_gvn_header_id=t_grn_gvn.grn_gvn_header_id "
			+ "GROUP BY t_grn_gvn_header.grn_gvn_header_id order by t_grn_gvn_header.grngvn_date  ",nativeQuery=true)
	
		List<GGReportByDate> getGrnGvnReportByDateAllFrAllGG(@Param("fromDate") 
		String fromDate,@Param("toDate") 
		String toDate);
	
	//r2 group by frId
	
	/*//r2
	
	@Query(value=" SELECT t_grn_gvn_header.grn_gvn_header_id,t_grn_gvn_header.grngvn_srno,"
			+ "t_grn_gvn_header.grngvn_date,t_grn_gvn_header.is_grn,t_grn_gvn_header.fr_id,"
			+ "t_grn_gvn_header.apr_grand_total, t_grn_gvn_header.total_amt , "
			+ "sum(t_grn_gvn.grn_gvn_qty) as reqQty, sum(t_grn_gvn.apr_qty_acc) as aprQty, "
			+ "m_franchisee.fr_name  from t_grn_gvn_header,t_grn_gvn, m_franchisee "
			+ "WHERE m_franchisee.fr_id=t_grn_gvn_header.fr_id and t_grn_gvn_header.fr_id IN(:frIdList) "
			+ "AND t_grn_gvn_header.grngvn_date BETWEEN :fromDate and :toDate AND t_grn_gvn_header.is_grn=:isGrn"
			+ " AND t_grn_gvn_header.grn_gvn_header_id=t_grn_gvn.grn_gvn_header_id "
			+ "GROUP BY t_grn_gvn_header.fr_id ",nativeQuery=true)
	
		List<GGReportByDateRepo> getGrnGvnReportByDateSelFrGroup(@Param("fromDate") 
		String fromDate,@Param("toDate") 
		String toDate,@Param("frIdList") List<String> frIdList,@Param("isGrn") int isGrn);
	//r2

	@Query(value=" SELECT t_grn_gvn_header.grn_gvn_header_id,t_grn_gvn_header.grngvn_srno,"
			+ "t_grn_gvn_header.grngvn_date,t_grn_gvn_header.is_grn,t_grn_gvn_header.fr_id,"
			+ "t_grn_gvn_header.apr_grand_total, t_grn_gvn_header.total_amt , "
			+ "sum(t_grn_gvn.grn_gvn_qty) as reqQty, sum(t_grn_gvn.apr_qty_acc) as aprQty, "
			+ "m_franchisee.fr_name  from t_grn_gvn_header,t_grn_gvn, m_franchisee "
			+ "WHERE m_franchisee.fr_id=t_grn_gvn_header.fr_id  "
			+ "AND t_grn_gvn_header.grngvn_date BETWEEN :fromDate and :toDate AND t_grn_gvn_header.is_grn=:isGrn"
			+ " AND t_grn_gvn_header.grn_gvn_header_id=t_grn_gvn.grn_gvn_header_id "
			+ "GROUP BY t_grn_gvn_header.fr_id ",nativeQuery=true)
	
		List<GGReportByDateRepo> getGrnGvnReportByDateAllFrGroup(@Param("fromDate") 
		String fromDate,@Param("toDate") 
		String toDate,@Param("isGrn") int isGrn);
	
	//r2
	
	@Query(value=" SELECT t_grn_gvn_header.grn_gvn_header_id,t_grn_gvn_header.grngvn_srno,"
			+ "t_grn_gvn_header.grngvn_date,t_grn_gvn_header.is_grn,t_grn_gvn_header.fr_id,"
			+ "t_grn_gvn_header.apr_grand_total, t_grn_gvn_header.total_amt , "
			+ "sum(t_grn_gvn.grn_gvn_qty) as reqQty, sum(t_grn_gvn.apr_qty_acc) as aprQty, "
			+ "m_franchisee.fr_name  from t_grn_gvn_header,t_grn_gvn, m_franchisee "
			+ "WHERE m_franchisee.fr_id=t_grn_gvn_header.fr_id and t_grn_gvn_header.fr_id IN(:frIdList) "
			+ "AND t_grn_gvn_header.grngvn_date BETWEEN :fromDate and :toDate "
			+ " AND t_grn_gvn_header.grn_gvn_header_id=t_grn_gvn.grn_gvn_header_id "
			+ "GROUP BY t_grn_gvn_header.fr_id ",nativeQuery=true)
	
		List<GGReportByDateRepo> getGrnGvnReportByDateSelFrAllGGGroupByFr(@Param("fromDate") 
		String fromDate,@Param("toDate") 
		String toDate,@Param("frIdList") List<String> frIdList);
	
//r2
	@Query(value=" SELECT t_grn_gvn_header.grn_gvn_header_id,t_grn_gvn_header.grngvn_srno,"
			+ "t_grn_gvn_header.grngvn_date,t_grn_gvn_header.is_grn,t_grn_gvn_header.fr_id,"
			+ "t_grn_gvn_header.apr_grand_total, t_grn_gvn_header.total_amt , "
			+ "sum(t_grn_gvn.grn_gvn_qty) as reqQty, sum(t_grn_gvn.apr_qty_acc) as aprQty, "
			+ "m_franchisee.fr_name  from t_grn_gvn_header,t_grn_gvn, m_franchisee "
			+ "WHERE m_franchisee.fr_id=t_grn_gvn_header.fr_id  "
			+ "AND t_grn_gvn_header.grngvn_date BETWEEN :fromDate and :toDate  "
			+ " AND t_grn_gvn_header.grn_gvn_header_id=t_grn_gvn.grn_gvn_header_id "
			+ "GROUP BY t_grn_gvn_header.fr_id ",nativeQuery=true)
	
		List<GGReportByDateRepo> getGrnGvnReportByDateAllFrAllGGGroupByFr(@Param("fromDate") 
		String fromDate,@Param("toDate") 
		String toDate);
	*/
	//
	//sumit sir final query r2
	//SELECT t_grn_gvn_header.is_grn,t_grn_gvn_header.fr_id, sum(t_grn_gvn.apr_grand_total)as apr_grand_total, 
	//sum(t_grn_gvn.grn_gvn_amt) as total_amt, m_franchisee.fr_name,sum(t_grn_gvn.grn_gvn_qty),sum(t_grn_gvn.apr_qty_acc) 
	//from t_grn_gvn_header,m_franchisee,t_grn_gvn WHERE t_grn_gvn_header.fr_id IN (17,63,18) AND m_franchisee.fr_id=t_grn_gvn_header.fr_id
	//AND t_grn_gvn_header.grngvn_date BETWEEN '2018-04-01' and '2018-04-13' AND t_grn_gvn_header.is_grn=1 
	//AND t_grn_gvn_header.grn_gvn_header_id=t_grn_gvn.grn_gvn_header_id AND t_grn_gvn.fr_id=m_franchisee.fr_id GROUP by t_grn_gvn.fr_id
	
	
	

}
