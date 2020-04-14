package com.ats.webapi.repository.bmsstock;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.stock.FinishedGoodStockDetail;

public interface FinishedGoodStockDetailRepo  extends JpaRepository<FinishedGoodStockDetail, Integer> {

	FinishedGoodStockDetail save(FinishedGoodStockDetail finishedGoodStockDetail);
	
	List<FinishedGoodStockDetail> findByStockDateAndCatId(Date stockDate,int catId);
	
	@Query(value=" SELECT d.cat_id, d.op_t1,d.op_t2,d.op_t3,d.stock_date,d.item_id,d.item_name,SUM(d.op_total) AS op_total,SUM(d.prod_qty)AS prod_qty ,SUM(d.rej_qty) AS rej_qty," + 
			"SUM(d.fr_sale_qty) AS fr_sale_qty,SUM(d.gate_sale_qty)AS gate_sale_qty,d.clo_t1,d.clo_t2,d.clo_t3,SUM(d.clo_current) AS clo_current,SUM(d.total_clo_stk) AS total_clo_stk,d.fin_stock_detail_id," + 
			"d.fin_stock_id,d.del_status" + 
			" FROM finished_good_stock_detail d," + 
			"			finished_good_stock h WHERE h.fin_good_stock_status=:stockStatus AND h.fin_stock_id=d.fin_stock_id" + 
			"			 AND d.stock_date BETWEEN :fromDate AND :toDate  GROUP BY d.item_id" + 
			"" + 
			"",nativeQuery=true)
	
		List<FinishedGoodStockDetail> findByStockDateBetween(@Param("fromDate")Date fromStockDate, 
			@Param("toDate")Date toStockDate,@Param("stockStatus") int stockStatus);

	@Query(value="   select\n" + 
			"			        finishedgo.fin_stock_detail_id,\n" + 
			"			       finishedgo.cat_id,\n" + 
			"			       finishedgo.clo_current,\n" + 
			"			       finishedgo.clo_t1,\n" +  
			"			        finishedgo.clo_t2,\n" + 
			"			        finishedgo.clo_t3,\n" + 
			"			       finishedgo.del_status,\n" + 
			"			        finishedgo.fin_stock_id,\n" + 
			"			       finishedgo.fr_sale_qty,\n" + 
			"			        finishedgo.gate_sale_qty,\n" + 
			"			        finishedgo.item_id,\n" + 
			"			       finishedgo.item_name,\n" + 
			"			        finishedgo.op_t1,\n" + 
			"			       finishedgo.op_t2,\n" + 
			"			       finishedgo.op_t3,\n" + 
			"			       finishedgo.op_total,\n" + 
			"			        finishedgo.prod_qty,\n" + 
			"			        finishedgo.rej_qty,\n" + 
			"			       finishedgo.stock_date,\n" + 
			"			        finishedgo.total_clo_stk \n" + 
			"			    from\n" + 
			"			       finished_good_stock_detail finishedgo ,m_item\n" + 
			"			    where\n" + 
			"			        finishedgo.stock_date=:stkDate and m_item.id=finishedgo.item_id order by m_item.item_grp1,m_item.item_grp2,m_item.item_name ",nativeQuery=true)
	List<FinishedGoodStockDetail> findByStockDate(@Param("stkDate")Date stkDate);
	
	
	//Final Qury GIven by SUMIT SIR //3feb for Fin good Stock Bet Date
	@Query(value="SELECT m_item.id as item_id,m_item.item_name,m_item.item_grp1 AS cat_id,m_item.del_status,COALESCE(s1.stock_date,2018-01-01) AS stock_date," + 
			"COALESCE(s1.fin_stock_detail_id,0) AS fin_stock_detail_id, COALESCE(s1.fin_stock_id,0) AS fin_stock_id," + 
			"COALESCE(s1.t1,0) AS op_t1 , COALESCE(s1.t2,0) AS op_t2 ,COALESCE(s1.t3,0) AS op_t3 ,COALESCE(s1.op_total,0) " + 
			"AS op_total ," + 
			" COALESCE(s2.fr_sale_qty,0) AS fr_sale_qty,COALESCE(s2.gate_sale_qty,0) AS gate_sale_qty," + 
			"COALESCE(s2.prod_qty,0) AS prod_qty,COALESCE(s2.rej_qty,0) AS rej_qty, " + 
			"COALESCE(s3.clo_current,0)as clo_current,COALESCE(s3.clo_t1,0)as clo_t1," + 
			"" + 
			"COALESCE(s3.clo_t2,0)as clo_t2,COALESCE(s3.clo_t3,0)as clo_t3,COALESCE(s3.total_clo_stk,0)as total_clo_stk FROM m_item " + 
			"LEFT JOIN (Select finished_good_stock_detail.stock_date as stock_date,finished_good_stock_detail.fin_stock_detail_id " + 
			"as fin_stock_detail_id, finished_good_stock_detail.fin_stock_id as fin_stock_id,  finished_good_stock_detail.op_t1 as t1," + 
			"finished_good_stock_detail.op_t2 as t2,finished_good_stock_detail.op_t3 as t3, " + 
			"finished_good_stock_detail.op_total as op_total," + 
			"finished_good_stock_detail.item_id From finished_good_stock_detail " + 
			"where finished_good_stock_detail.stock_date= :fromDate group by item_id ) s1 ON s1.item_id = m_item.id " + 
			
			"LEFT JOIN ( select SUM(finished_good_stock_detail.fr_sale_qty ) as fr_sale_qty,SUM(finished_good_stock_detail.gate_sale_qty) as " + 
			"gate_sale_qty, SUM(finished_good_stock_detail.prod_qty) as prod_qty,SUM(finished_good_stock_detail.rej_qty) as rej_qty, " + 
			"finished_good_stock_detail.item_id from finished_good_stock_detail " + 
			
			" where finished_good_stock_detail.stock_date BETWEEN :fromDate AND :toDate group by finished_good_stock_detail.item_id ) " + 
			"s2 ON s2.item_id = m_item.id LEFT JOIN ( Select finished_good_stock_detail.clo_current as clo_current," + 
			"finished_good_stock_detail.clo_t1 as clo_t1,finished_good_stock_detail.clo_t2 as clo_t2,finished_good_stock_detail.clo_t3 " + 
			"as clo_t3, finished_good_stock_detail.total_clo_stk as total_clo_stk, " + 
			"finished_good_stock_detail.item_id From finished_good_stock_detail where finished_good_stock_detail.stock_date= :toDate " + 
			"group by item_id ) s3 ON s3.item_id = m_item.id WHERE m_item.del_status=0 GROUP BY m_item.id" + 
		
			"",nativeQuery=true)
	
		List<FinishedGoodStockDetail> findByStockDateBetweenTwoDates(@Param("fromDate")java.sql.Date fromDate, 
			@Param("toDate")java.sql.Date toDate);
	
	@Query(value="SELECT m_item.id as item_id,m_item.item_name,m_item.item_grp1 AS cat_id,m_item.del_status,COALESCE(s1.stock_date,2018-01-01) AS stock_date," + 
			"COALESCE(s1.fin_stock_detail_id,0) AS fin_stock_detail_id, COALESCE(s1.fin_stock_id,0) AS fin_stock_id," + 
			"COALESCE(s1.t1,0) AS op_t1 , COALESCE(s1.t2,0) AS op_t2 ,COALESCE(s1.t3,0) AS op_t3 ,COALESCE(s1.op_total,0) " + 
			"AS op_total ," + 
			" COALESCE(s2.fr_sale_qty,0) AS fr_sale_qty,COALESCE(s2.gate_sale_qty,0) AS gate_sale_qty," + 
			"COALESCE(s2.prod_qty,0) AS prod_qty,COALESCE(s2.rej_qty,0) AS rej_qty, " + 
			"COALESCE(s3.clo_current,0)as clo_current,COALESCE(s3.clo_t1,0)as clo_t1," + 
			"" + 
			"COALESCE(s3.clo_t2,0)as clo_t2,COALESCE(s3.clo_t3,0)as clo_t3,COALESCE(s3.total_clo_stk,0)as total_clo_stk FROM m_item " + 
			"LEFT JOIN (Select finished_good_stock_detail.stock_date as stock_date,finished_good_stock_detail.fin_stock_detail_id " + 
			"as fin_stock_detail_id, finished_good_stock_detail.fin_stock_id as fin_stock_id,  finished_good_stock_detail.op_t1 as t1," + 
			"finished_good_stock_detail.op_t2 as t2,finished_good_stock_detail.op_t3 as t3, " + 
			"finished_good_stock_detail.op_total as op_total," + 
			"finished_good_stock_detail.item_id From finished_good_stock_detail " + 
			"where finished_good_stock_detail.stock_date= :fromDate group by item_id ) s1 ON s1.item_id = m_item.id " + 
			
			"LEFT JOIN ( select SUM(finished_good_stock_detail.fr_sale_qty ) as fr_sale_qty,SUM(finished_good_stock_detail.gate_sale_qty) as " + 
			"gate_sale_qty, SUM(finished_good_stock_detail.prod_qty) as prod_qty,SUM(finished_good_stock_detail.rej_qty) as rej_qty, " + 
			"finished_good_stock_detail.item_id from finished_good_stock_detail " + 
			
			" where finished_good_stock_detail.stock_date BETWEEN :fromDate AND :toDate group by finished_good_stock_detail.item_id ) " + 
			"s2 ON s2.item_id = m_item.id LEFT JOIN ( Select finished_good_stock_detail.clo_current as clo_current," + 
			"finished_good_stock_detail.clo_t1 as clo_t1,finished_good_stock_detail.clo_t2 as clo_t2,finished_good_stock_detail.clo_t3 " + 
			"as clo_t3, finished_good_stock_detail.total_clo_stk as total_clo_stk, " + 
			"finished_good_stock_detail.item_id From finished_good_stock_detail where finished_good_stock_detail.stock_date= :toDate " + 
			"group by item_id ) s3 ON s3.item_id = m_item.id WHERE m_item.del_status=0 and m_item.item_grp1=:catId GROUP BY m_item.id" + 
		
			"",nativeQuery=true)
	
		List<FinishedGoodStockDetail> findByStockDateBetweenTwoDateByCat(@Param("fromDate")java.sql.Date fromDate, 
			@Param("toDate")java.sql.Date toDate,@Param("catId") int catId);
	
	
}
