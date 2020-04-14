package com.ats.webapi.repository.bmsstock;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.prod.GetProdPlanHeader;
import com.ats.webapi.model.stock.GetBmsCurrentStock;

@Repository
public interface GetCurrentBmsStockRepo extends JpaRepository<GetBmsCurrentStock, Integer> {
	
	//old Query
	/*@Query(value=" SELECT m_rm.rm_uom_id,m_rm.rm_id, m_rm.rm_name, coalesce((Select SUM(t_req_bom_detail.rm_issue_qty) "
			+ "FROM t_req_bom_detail,t_req_bom where t_req_bom.approved_date=:curDate AND t_req_bom.from_dept_id=:prodDeptId  AND t_req_bom_detail.rm_type=:rmType AND "
			+ "t_req_bom.req_id=t_req_bom_detail.req_id AND t_req_bom.status>0 AND m_rm.rm_id=t_req_bom_detail.rm_id),0) AS prod_issue_qty,\n" + 
			"\n" + 
			"coalesce((Select SUM( t_req_bom_detail.rejected_qty) "
			+ "FROM t_req_bom_detail,t_req_bom where t_req_bom.rej_approve_date=:curDate "
			+ " AND t_req_bom_detail.rm_type=:rmType AND t_req_bom.from_dept_id=:prodDeptId AND t_req_bom.req_id=t_req_bom_detail.req_id "
			+ "AND t_req_bom.status>2 AND m_rm.rm_id=t_req_bom_detail.rm_id),0) AS prod_rejected_qty,\n" + 
			"\n" +  
			"coalesce((Select SUM( t_req_bom_detail.return_qty)"
			+ " FROM t_req_bom_detail,t_req_bom where t_req_bom.rej_approve_date=:curDate AND"
			+ " t_req_bom.from_dept_id=:prodDeptId AND t_req_bom_detail.rm_type=:rmType AND  t_req_bom.req_id=t_req_bom_detail.req_id AND t_req_bom.status>2 "
			+ "AND m_rm.rm_id=t_req_bom_detail.rm_id),0) AS prod_return_qty,\n" + 
			"\n" + 
			"coalesce((Select SUM( t_req_bom_detail.rm_issue_qty) FROM "
			+ "t_req_bom_detail,t_req_bom where t_req_bom.approved_date=:curDate AND "
			+ "t_req_bom.from_dept_id=:mixDeptId AND t_req_bom.req_id=t_req_bom_detail.req_id AND "
			+ " t_req_bom_detail.rm_type=:rmType AND t_req_bom.status>0 AND m_rm.rm_id=t_req_bom_detail.rm_id),0) AS mixing_issue_qty, \n " + 
			"\n" + 
			"coalesce((Select SUM( t_req_bom_detail.rejected_qty) "
			+ "FROM t_req_bom_detail,t_req_bom where t_req_bom.rej_approve_date=:curDate "
			+ "AND t_req_bom.from_dept_id=:mixDeptId AND t_req_bom.req_id=t_req_bom_detail.req_id "
			+ "AND t_req_bom_detail.rm_type=:rmType AND  t_req_bom.status>2 AND m_rm.rm_id=t_req_bom_detail.rm_id),0) AS mixing_rejected_qty,\n" + 
			"\n" + 
			"coalesce((Select SUM( t_req_bom_detail.return_qty)"
			+ " FROM t_req_bom_detail,t_req_bom where t_req_bom.rej_approve_date=:curDate "
			+ "AND  t_req_bom_detail.rm_type=:rmType AND t_req_bom.from_dept_id=:mixDeptId AND t_req_bom.req_id=t_req_bom_detail.req_id AND"
			+ " t_req_bom.status>2 AND m_rm.rm_id=t_req_bom_detail.rm_id),0) AS mixing_return_qty,\n" + 
			"\n" + 
			"coalesce((Select SUM( t_req_bom_detail.rm_issue_qty) "
			+ "FROM t_req_bom_detail,t_req_bom where t_req_bom.approved_date=:curDate "
			+ "AND t_req_bom_detail.rm_type=:rmType AND  t_req_bom.from_dept_id=:storeDeptId AND t_req_bom.req_id=t_req_bom_detail.req_id AND"
			+ " t_req_bom.status>2 AND m_rm.rm_id=t_req_bom_detail.rm_id),0) AS store_issue_qty,\n" + 
			"\n" + 
			"coalesce((Select SUM( t_req_bom_detail.rejected_qty) FROM "
			+ " t_req_bom_detail,t_req_bom where t_req_bom.rej_approve_date=:curDate "
			+ "AND t_req_bom.from_dept_id=:storeDeptId AND t_req_bom.req_id=t_req_bom_detail.req_id "
			+ "AND t_req_bom_detail.rm_type=:rmType AND  t_req_bom.status>2 AND m_rm.rm_id=t_req_bom_detail.rm_id),0) AS store_rejected_qty \n" +
	
			" from t_req_bom,m_rm Group by rm_id",nativeQuery=true)
		
			List<GetBmsCurrentStock> getBmsCurStock(@Param("curDate") Date curDate,@Param("prodDeptId") int prodDeptId,@Param("mixDeptId") int mixDeptId,
					@Param("storeDeptId") int storeDeptId,@Param("rmType") int rmType);
		*/
	//new Query get Bms RM current stock :Sir 5 Feb
	@Query(value=" SELECT m_rm.rm_uom_id, m_rm.rm_id,m_rm.rm_name,COALESCE(s7.bms_opening_stock,0) as bms_opening_stock,COALESCE(s7.bms_opening_stock,0) as bms_closing_stock ,\n" + 
			"COALESCE(s1.prod_issue_qty,0) as prod_issue_qty, COALESCE(s4.prod_rejected_qty,0) as prod_rejected_qty, \n" + 
			"COALESCE(s4.prod_return_qty,0) as prod_return_qty,COALESCE(s2.mixing_issue_qty,0) as mixing_issue_qty, \n" + 
			"COALESCE(s5.mixing_rejected_qty,0) as mixing_rejected_qty,\n" + 
			" COALESCE(s5.mixing_return_qty,0) as mixing_return_qty,COALESCE(s3.store_issue_qty,0) as store_issue_qty, \n" + 
			"COALESCE(s6.store_rejected_qty,0) as store_rejected_qty FROM m_rm\n" + 
			"\n" + 
			"LEFT JOIN ( select SUM(t_req_bom_detail.rm_issue_qty) as prod_issue_qty, t_req_bom_detail.rm_id AS rm_id \n" + 
			"from t_req_bom_detail,t_req_bom where t_req_bom.approved_date=:curDate and t_req_bom.from_dept_id=:prodDeptId \n" + 
			"AND t_req_bom_detail.rm_type=1 AND t_req_bom.req_id=t_req_bom_detail.req_id AND t_req_bom.status>0 \n" + 
			"group by t_req_bom_detail.rm_id ) s1 ON s1.rm_id = m_rm.rm_id\n" + 
			"\n" + 
			"LEFT JOIN ( select SUM( t_req_bom_detail.rm_issue_qty) as mixing_issue_qty, t_req_bom_detail.rm_id AS rm_id \n" + 
			"from t_req_bom_detail ,t_req_bom where t_req_bom.approved_date=:curDate and t_req_bom.from_dept_id=:mixDeptId \n" + 
			"AND t_req_bom_detail.rm_type=1 AND t_req_bom.req_id=t_req_bom_detail.req_id AND t_req_bom.status>0 \n" + 
			"group by t_req_bom_detail.rm_id ) s2 ON s2.rm_id = m_rm.rm_id\n" + 
			"\n" + 
			"LEFT JOIN ( select SUM( t_req_bom_detail.rm_issue_qty) as  store_issue_qty, t_req_bom_detail.rm_id AS \n" + 
			"rm_id from t_req_bom_detail,t_req_bom where t_req_bom.approved_date=:curDate and t_req_bom.from_dept_id=:bmsDeptId \n" + 
			"AND t_req_bom_detail.rm_type=1 AND t_req_bom.req_id=t_req_bom_detail.req_id AND t_req_bom.status>0\n" + 
			" group by t_req_bom_detail.rm_id ) s3 ON s3.rm_id = m_rm.rm_id\n" + 
			"\n" + 
			"LEFT JOIN ( select SUM(t_req_bom_detail.rejected_qty) as prod_rejected_qty,SUM(t_req_bom_detail.return_qty) \n" + 
			"as prod_return_qty, t_req_bom_detail.rm_id AS rm_id from t_req_bom_detail,\n" + 
			"t_req_bom where t_req_bom.rej_approve_date=:curDate and t_req_bom.from_dept_id=:prodDeptId AND t_req_bom_detail.rm_type=1\n" + 
			" AND t_req_bom.req_id=t_req_bom_detail.req_id AND t_req_bom.status>2 group by t_req_bom_detail.rm_id ) \n" + 
			"s4 ON s4.rm_id = m_rm.rm_id\n" + 
			"\n" + 
			"LEFT JOIN ( select SUM(t_req_bom_detail.rejected_qty) as mixing_rejected_qty,SUM(t_req_bom_detail.return_qty) \n" + 
			"as mixing_return_qty, t_req_bom_detail.rm_id AS rm_id from t_req_bom_detail,t_req_bom \n" + 
			"where t_req_bom.rej_approve_date=:curDate and t_req_bom.from_dept_id=:mixDeptId AND t_req_bom_detail.rm_type=1 \n" + 
			"AND t_req_bom.req_id=t_req_bom_detail.req_id AND t_req_bom.status>2 group by t_req_bom_detail.rm_id ) \n" + 
			"s5 ON s5.rm_id = m_rm.rm_id\n" + 
			"\n" + 
			"LEFT JOIN ( select SUM(t_req_bom_detail.rejected_qty) as store_rejected_qty, t_req_bom_detail.rm_id \n" + 
			"AS rm_id from t_req_bom_detail,t_req_bom where t_req_bom.rej_approve_date=:curDate and t_req_bom.from_dept_id=:bmsDeptId AND \n" + 
			"t_req_bom_detail.rm_type=1 AND t_req_bom.req_id=t_req_bom_detail.req_id AND t_req_bom.status>2 group by t_req_bom_detail.rm_id ) \n" + 
			"s6 ON s6.rm_id = m_rm.rm_id\n" + 
			"\n" + 
			"LEFT JOIN ( select SUM(t_bms_stock_details.bms_opening_stock) as bms_opening_stock, t_bms_stock_details.rm_id \n" + 
			"AS rm_id from t_bms_stock_details,t_bms_stock where t_bms_stock.bms_stock_date=:curDate \n" + 
			"and t_bms_stock.bms_stock_id=t_bms_stock_details.bms_stock_id AND t_bms_stock.bms_status=0 \n" + 
			"group by t_bms_stock_details.rm_id ) s7 ON s7.rm_id = m_rm.rm_id\n" + 
			"\n" + 
			"WHERE m_rm.del_status=0 GROUP BY m_rm.rm_id ",nativeQuery=true)
		
			List<GetBmsCurrentStock> getBmsCurStockForRM(@Param("curDate") Date curDate,@Param("prodDeptId") int prodDeptId,@Param("mixDeptId") int mixDeptId,
					@Param("bmsDeptId") int bmsDeptId);
	
	
	
	
	@Query(value="SELECT m_rm.rm_uom_id, m_rm.rm_id,m_rm.rm_name,COALESCE(s2.bms_opening_stock,0) as bms_opening_stock ,\n" + 
			"COALESCE(s1.prod_issue_qty,0) as prod_issue_qty, COALESCE(s1.prod_rejected_qty,0) as prod_rejected_qty, \n" + 
			"COALESCE(s1.prod_return_qty,0) as prod_return_qty,COALESCE(s1.mixing_issue_qty,0) as mixing_issue_qty,\n" + 
			" COALESCE(s1.mixing_rejected_qty,0) as mixing_rejected_qty, COALESCE(s1.mixing_return_qty,0) as mixing_return_qty,\n" + 
			"COALESCE(s1.store_issue_qty,0) as store_issue_qty, COALESCE(s1.store_rejected_qty,0) as store_rejected_qty,\n" + 
			"COALESCE(s3. bms_closing_stock,0) as bms_closing_stock FROM m_rm\n" + 
			"\n" + 
			"LEFT JOIN ( select SUM(t_bms_stock_details.prod_issue_qty) as prod_issue_qty,\n" + 
			"SUM(t_bms_stock_details.prod_rejected_qty) as prod_rejected_qty,SUM(t_bms_stock_details.prod_return_qty) as prod_return_qty,\n" + 
			"SUM( t_bms_stock_details.mixing_issue_qty) as mixing_issue_qty,SUM(t_bms_stock_details.mixing_rejected) as mixing_rejected_qty,\n" + 
			"SUM(t_bms_stock_details.mixing_return_qty) as mixing_return_qty,SUM( t_bms_stock_details.store_rec_qty) as  store_issue_qty, \n" + 
			"SUM(t_bms_stock_details.store_rejected_qty) as store_rejected_qty,t_bms_stock_details.rm_id AS rm_id from t_bms_stock_details,\n" + 
			"t_bms_stock where t_bms_stock.bms_stock_date BETWEEN :fromDate and :toDate\n" + 
			" AND t_bms_stock.bms_stock_id=t_bms_stock_details.bms_stock_id AND t_bms_stock.rm_type=1  group by  t_bms_stock_details.rm_id ) \n" + 
			"s1 ON s1.rm_id = m_rm.rm_id\n" + 
			"\n" + 
			"LEFT JOIN ( select SUM(t_bms_stock_details.bms_opening_stock) as bms_opening_stock, t_bms_stock_details.rm_id AS rm_id \n" + 
			"from t_bms_stock_details,t_bms_stock where t_bms_stock.bms_stock_date=:fromDate \n" + 
			"and t_bms_stock.bms_stock_id=t_bms_stock_details.bms_stock_id AND  t_bms_stock.rm_type=1  group by t_bms_stock_details.rm_id )\n" + 
			" s2 ON s2.rm_id = m_rm.rm_id\n" + 
			"\n" + 
			"LEFT JOIN ( select SUM(t_bms_stock_details.closing_qty) as bms_closing_stock, t_bms_stock_details.rm_id AS rm_id from \n" + 
			"t_bms_stock_details,t_bms_stock where t_bms_stock.bms_stock_date=:toDate\n" + 
			"and t_bms_stock.bms_stock_id=t_bms_stock_details.bms_stock_id AND t_bms_stock.rm_type=1 group by \n" + 
			"t_bms_stock_details.rm_id ) s3 ON s3.rm_id = m_rm.rm_id\n" + 
			"\n" + 
			"WHERE m_rm.del_status=0 GROUP BY m_rm.rm_id  ",nativeQuery=true)
		
			List<GetBmsCurrentStock> getBmsCurStockForRMBetDate(@Param("fromDate") java.util.Date fromDate,@Param("toDate") java.util.Date toDate);
	
	
	
	/*//GET BMS SF CURRENT STOCK
	@Query(value=" SELECT m_item_sf_header.sf_uom_id,"
			+ "m_item_sf_header.sf_id,m_item_sf_header.sf_name,COALESCE(s7.bms_opening_stock,0) \n" + 
			"as bms_opening_stock ,COALESCE(s1.prod_issue_qty,0) as prod_issue_qty, COALESCE(s3.prod_rejected_qty,0) as prod_rejected_qty, \n" + 
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
		
			List<GetBmsCurrentStock> getBmsCurStockForSF(@Param("curDate") Date curDate,@Param("prodDeptId") int prodDeptId);
		*/

}
