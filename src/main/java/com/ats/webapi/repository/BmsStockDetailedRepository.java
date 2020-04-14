package com.ats.webapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.BmsStockDetailed;
import com.ats.webapi.model.stock.GetBmsStock;


public interface BmsStockDetailedRepository extends JpaRepository<BmsStockDetailed,Long>{ 

	
	@Query(value="select * from t_bms_stock_details where bms_stock_id=:bmsStockId",nativeQuery=true)
	List<BmsStockDetailed> getStockDetailsItem(@Param("bmsStockId")int bmsStockId);
 
//	@Query(value=" SELECT d.bms_stock_deatil_id,u.uom, d.is_del_status, d.rm_type, d.rm_name, d.rm_id, d.rm_uom, d.bms_stock_date, d.bms_stock_id, b.bms_opening_stock, sum(d.store_rec_qty) as store_rec_qty, sum(d.store_rejected_qty) as store_rejected_qty, sum(d.mixing_rec_qty) as mixing_rec_qty,"
//			+" sum(d.mixing_receive_rejected_qty) as mixing_receive_rejected_qty, sum(d.mixing_issue_qty) as mixing_issue_qty, sum(d.mixing_return_qty) as mixing_return_qty, sum(d.mixing_rejected) as mixing_rejected,"
//				+" sum(d.prod_issue_qty) as prod_issue_qty, sum(d.prod_return_qty) as prod_return_qty, sum(d.prod_rejected_qty) as prod_rejected_qty, m.closing_qty FROM t_bms_stock_details d,"
//			+" t_bms_stock_details b, t_bms_stock_details m, m_rm_uom u WHERE "
//				+ "d.bms_stock_date BETWEEN :fromDate AND :toDate AND d.rm_type=:rmType AND b.bms_stock_date =:fromDate "
//			+" AND b.rm_type=:rmType AND m.bms_stock_date=:toDate AND m.rm_type=:rmType AND m.rm_id=d.rm_id AND d.rm_id=b.rm_id AND d.rm_uom=u.uom_id group by d.rm_id "
//				+ "",nativeQuery=true)
//	 List<BmsStockDetailed> getStockDetails(@Param("fromDate")String fromDate, @Param("toDate")String toDate, @Param("rmType")int rmType);
	
	
	

	//get Bms Stock Detail with Stock Id and rm type for Day end 7Feb
	
	 List<BmsStockDetailed> findByBmsStockId(int bmsStockId);
	
	
	
}
