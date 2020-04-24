package com.ats.webapi.repository.bmsstock;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.stock.GetCurrentBmsSFStock;

public interface CurrentBmsSFStockRepo extends JpaRepository<GetCurrentBmsSFStock, Integer> {

	@Query(value="SELECT\n" + 
			"        m_item_sf_header.sf_uom_id,\n" + 
			"        m_item_sf_header.sf_id,\n" + 
			"        m_item_sf_header.sf_name,\n" + 
			"        COALESCE(s7.bms_opening_stock,\n" + 
			"        0) AS bms_opening_stock,\n" + 
			"        COALESCE(s1.issue_qty,\n" + 
			"        0) as prod_issue_qty,\n" + 
			"        COALESCE(s2.production_qty,\n" + 
			"        0) as mixing_issue_qty,\n" + 
			"        COALESCE(0,\n" + 
			"        0) AS bms_closing_stock  , \n" + 
			"        COALESCE(0,\n" + 
			"        0) as prod_rejected_qty,\n" + 
			"        COALESCE(0,\n" + 
			"        0) as prod_return_qty, \n" + 
			"        COALESCE(0,\n" + 
			"        0) AS mixing_rejected_qty \n" + 
			"    FROM\n" + 
			"        m_item_sf_header\n" + 
			"    LEFT JOIN\n" + 
			"        (\n" + 
			"            select\n" + 
			"                SUM(t_bms_stock_details.bms_opening_stock) as bms_opening_stock,\n" + 
			"                t_bms_stock_details.rm_id AS rm_id \n" + 
			"            from\n" + 
			"                t_bms_stock_details,\n" + 
			"                t_bms_stock \n" + 
			"            where\n" + 
			"                t_bms_stock.bms_stock_date=:curDate  \n" + 
			"                and  t_bms_stock.bms_stock_id=t_bms_stock_details.bms_stock_id \n" + 
			"                AND t_bms_stock.bms_status=0 \n" + 
			"                and t_bms_stock.ex_int=:deptId \n" + 
			"                and t_bms_stock.rm_type=2\n" + 
			"            group by\n" + 
			"                t_bms_stock_details.rm_id \n" + 
			"        ) s7 \n" + 
			"            ON s7.rm_id = m_item_sf_header.sf_id\n" + 
			"    LEFT JOIN\n" + 
			"        (\n" + 
			"            select\n" + 
			"                SUM(t_req_bom_detail.rm_issue_qty) as issue_qty,\n" + 
			"                t_req_bom_detail.rm_id AS rm_id  \n" + 
			"            from\n" + 
			"                t_req_bom_detail,\n" + 
			"                t_req_bom \n" + 
			"            where\n" + 
			"                t_req_bom.approved_date=:curDate  \n" + 
			"                and t_req_bom.to_dept_id=:deptId  \n" + 
			"                AND t_req_bom_detail.rm_type=2 \n" + 
			"                AND t_req_bom.req_id=t_req_bom_detail.req_id \n" + 
			"                AND t_req_bom.status>0  \n" + 
			"            group by\n" + 
			"                t_req_bom_detail.rm_id \n" + 
			"        ) s1 \n" + 
			"            ON s1.rm_id = m_item_sf_header.sf_id  \n" + 
			"    LEFT JOIN\n" + 
			"        (\n" + 
			"            select\n" + 
			"                SUM(t_mixing_detail.production_qty) as production_qty,\n" + 
			"                t_mixing_detail.sf_id AS sf_id  \n" + 
			"            from\n" + 
			"                t_mixing_detail ,\n" + 
			"                t_mixing_header \n" + 
			"            where\n" + 
			"                t_mixing_header.mix_date=:curDate   \n" + 
			"                AND t_mixing_header.mix_id=t_mixing_detail.mixing_id \n" + 
			"                AND t_mixing_header.status>0 and t_mixing_header.ex_int1=:deptId  \n" + 
			"            group by\n" + 
			"                t_mixing_detail.sf_id \n" + 
			"        ) s2 \n" + 
			"            ON s2.sf_id = m_item_sf_header.sf_id \n" + 
			"    WHERE\n" + 
			"        m_item_sf_header.del_status=0  and m_item_sf_header.int_1=:deptId\n" + 
			"    GROUP BY\n" + 
			"        m_item_sf_header.sf_id",nativeQuery=true) 
			List<GetCurrentBmsSFStock> getBmsCurStockForSF(@Param("curDate") Date curDate,@Param("deptId") int deptId);
	//BMS Stock between date Same finish (sf) 03 Oct 2019
	
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
		//Changed 24-04
}
