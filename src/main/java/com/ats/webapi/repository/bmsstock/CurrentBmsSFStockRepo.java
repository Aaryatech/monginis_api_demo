package com.ats.webapi.repository.bmsstock;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.stock.GetCurrentBmsSFStock;

public interface CurrentBmsSFStockRepo extends JpaRepository<GetCurrentBmsSFStock, Integer> {

	
	@Query(value=" SELECT m_item_sf_header.sf_uom_id,"
			+ "m_item_sf_header.sf_id,m_item_sf_header.sf_name,COALESCE(s7.bms_opening_stock,0) AS bms_opening_stock,COALESCE(s7.bms_opening_stock,0) AS bms_closing_stock\n" + 
			" ,COALESCE(s1.prod_issue_qty,0) as prod_issue_qty, COALESCE(s3.prod_rejected_qty,0) as prod_rejected_qty, \n" + 
			"COALESCE(s3.prod_return_qty,0) as prod_return_qty,COALESCE(s2.mixing_production_qty,0) as mixing_issue_qty, \n" + 
			"COALESCE(s4.mixing_rejected_qty,0) AS mixing_rejected_qty FROM m_item_sf_header\n" + 
			"\n" + 
			"LEFT JOIN ( select SUM(t_req_bom_detail.rm_issue_qty) as prod_issue_qty, t_req_bom_detail.rm_id AS rm_id \n" + 
			"from t_req_bom_detail,t_req_bom where t_req_bom.approved_date=:curDate and t_req_bom.from_dept_id=:prodDeptId \n" + 
			"AND t_req_bom_detail.rm_type=2 AND t_req_bom.req_id=t_req_bom_detail.req_id AND t_req_bom.status>0 \n" + 
			"group by t_req_bom_detail.rm_id ) s1 ON s1.rm_id = m_item_sf_header.sf_id\n" + 
			"\n" + 
			"LEFT JOIN ( select SUM( t_mixing_detail.production_qty) as mixing_production_qty, t_mixing_detail.sf_id AS sf_id \n" + 
			"from t_mixing_detail ,t_mixing_header where t_mixing_header.mix_date=:curDate  \n" + 
			"AND t_mixing_header.mix_id=t_mixing_detail.mixing_id AND t_mixing_header.status>0 \n" + 
			"group by t_mixing_detail.sf_id ) s2 ON s2.sf_id = m_item_sf_header.sf_id\n" + 
			"\n" + 
			"LEFT JOIN ( select SUM(t_req_bom_detail.rejected_qty) as prod_rejected_qty,SUM(t_req_bom_detail.return_qty) \n" + 
			"as prod_return_qty, t_req_bom_detail.rm_id AS rm_id from t_req_bom_detail,t_req_bom \n" + 
			"where t_req_bom.rej_approve_date=:curDate and t_req_bom.from_dept_id=:prodDeptId AND \n" + 
			"t_req_bom_detail.rm_type=2 AND t_req_bom.req_id=t_req_bom_detail.req_id AND t_req_bom.status>2 \n" + 
			"group by t_req_bom_detail.rm_id ) s3 ON s3.rm_id = m_item_sf_header.sf_id\n" + 
			"\n" + 
			"LEFT JOIN ( select SUM( t_mixing_detail.rejected_qty) as mixing_rejected_qty, t_mixing_detail.sf_id \n" + 
			"AS sf_id from t_mixing_detail ,t_mixing_header where t_mixing_detail.mixing_date=:curDate  \n" + 
			"AND t_mixing_header.mix_id=t_mixing_detail.mixing_id AND t_mixing_header.status>1 group by \n" + 
			"t_mixing_detail.sf_id ) s4 ON s4.sf_id = m_item_sf_header.sf_id\n" + 
			"LEFT JOIN ( select SUM(t_bms_stock_details.bms_opening_stock) as bms_opening_stock,\n" + 
			" t_bms_stock_details.rm_id AS rm_id from t_bms_stock_details,t_bms_stock where t_bms_stock.bms_stock_date=:curDate and \n" + 
			"t_bms_stock.bms_stock_id=t_bms_stock_details.bms_stock_id AND t_bms_stock.bms_status=0 \n" + 
			"group by t_bms_stock_details.rm_id ) s7 ON s7.rm_id = m_item_sf_header.sf_id\n" + 
			"WHERE m_item_sf_header.del_status=0 GROUP BY m_item_sf_header.sf_id ",nativeQuery=true)
		
			List<GetCurrentBmsSFStock> getBmsCurStockForSF(@Param("curDate") Date curDate,@Param("prodDeptId") int prodDeptId);
	//BMS Stock between date Same finish (sf) 6 FEB 2018
	
	@Query(value=" SELECT m_item_sf_header.sf_uom_id, m_item_sf_header.sf_id,m_item_sf_header.sf_name,COALESCE(s7.bms_opening_stock,0) \n" + 
			"as bms_opening_stock ,COALESCE(s1.prod_issue_qty,0) as prod_issue_qty, COALESCE(s1.prod_rejected_qty,0) as prod_rejected_qty, \n" + 
			"COALESCE(s1.prod_return_qty,0) as prod_return_qty,COALESCE(s1.mixing_issue_qty,0) as mixing_issue_qty, \n" + 
			"COALESCE(s1.mixing_rejected_qty,0) AS mixing_rejected_qty,COALESCE(s8.bms_closing_stock,0) as bms_closing_stock \n" + 
			" FROM m_item_sf_header\n" + 
			"\n" + 
			"LEFT JOIN ( select SUM(t_bms_stock_details.prod_issue_qty) as prod_issue_qty,SUM(t_bms_stock_details.prod_rejected_qty)\n" + 
			" as prod_rejected_qty,SUM(t_bms_stock_details.prod_return_qty) as prod_return_qty,SUM( t_bms_stock_details.mixing_issue_qty) \n" + 
			"as mixing_issue_qty,SUM( t_bms_stock_details.mixing_rejected) as mixing_rejected_qty, t_bms_stock_details.rm_id AS rm_id \n" + 
			"from t_bms_stock_details,t_bms_stock where t_bms_stock.bms_stock_date BETWEEN :fromDate AND :toDate \n" + 
			" and t_bms_stock.bms_stock_id=t_bms_stock_details.bms_stock_id group by t_bms_stock_details.rm_id ) \n" + 
			"s1 ON s1.rm_id = m_item_sf_header.sf_id\n" + 
			"\n" + 
			"\n" + 
			"LEFT JOIN ( select SUM(t_bms_stock_details.bms_opening_stock) as bms_opening_stock, t_bms_stock_details.rm_id AS rm_id \n" + 
			"from t_bms_stock_details,t_bms_stock where t_bms_stock.bms_stock_date=:fromDate \n" + 
			"and t_bms_stock.bms_stock_id=t_bms_stock_details.bms_stock_id  group by t_bms_stock_details.rm_id ) \n" + 
			"s7 ON s7.rm_id = m_item_sf_header.sf_id\n" + 
			"\n" + 
			"LEFT JOIN ( select SUM(t_bms_stock_details.closing_qty) as bms_closing_stock, t_bms_stock_details.rm_id AS rm_id \n" + 
			"from t_bms_stock_details,t_bms_stock where t_bms_stock.bms_stock_date=:toDate and \n" + 
			"t_bms_stock.bms_stock_id=t_bms_stock_details.bms_stock_id   group by t_bms_stock_details.rm_id ) \n" + 
			"s8 ON s8.rm_id = m_item_sf_header.sf_id\n" + 
			"\n" + 
			"WHERE m_item_sf_header.del_status=0 GROUP BY m_item_sf_header.sf_id ",nativeQuery=true)
		
			List<GetCurrentBmsSFStock> getBmsStockForSFBetDate(@Param("fromDate") java.util.Date fromDate,@Param("toDate") java.util.Date toDate);
		
}
