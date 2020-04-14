package com.ats.webapi.repository.storestock;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.stock.StoreStockDetail;

public interface StoreStockDetailRepository extends JpaRepository<StoreStockDetail, Integer>{

	/*
	@Query(value=" SELECT d.store_stock_detail_id, d.store_stock_id, d.store_stock_date, d.rm_id, d.rm_name,"
			+" d.rm_group, d.rm_uom, sum(d.pur_rec_qty) as pur_rec_qty, sum(d.bms_issue_qty) as bms_issue_qty, d.is_delete, d.ex_int1, d.ex_int2, d.ex_bool,"
			+" f.store_opening_stock, t.store_closing_stock from t_store_stock_detail d,t_store_stock_detail f,"
			+" t_store_stock_detail t, t_store_stock_header h,t_store_stock_header h1,t_store_stock_header h2 where d.store_stock_id=h.store_stock_id AND"
			+" t.store_stock_id=h2.store_stock_id AND f.store_stock_id=h1.store_stock_id AND h.store_stock_date BETWEEN :fromDate"
			+ " AND :toDate AND h.store_stock_status=1 AND h1.store_stock_date=:fromDate AND"
			+" h2.store_stock_date=:toDate AND t.rm_id=d.rm_id AND f.rm_id=d.rm_id GROUP BY d.rm_id",nativeQuery=true)*/
	
	@Query(value="SELECT d.store_stock_detail_id, d.store_stock_id, d.store_stock_date, d.rm_id, d.rm_name, d.rm_group, d.rm_uom, sum(d.pur_rec_qty) as pur_rec_qty, sum(d.bms_issue_qty) as bms_issue_qty, d.is_delete, d.ex_int1, d.ex_int2, d.ex_bool, d.store_opening_stock, d.store_closing_stock from t_store_stock_detail d, t_store_stock_header h where d.store_stock_id=h.store_stock_id AND  h.store_stock_date BETWEEN :fromDate AND :toDate AND h.store_stock_status=1 AND h.ex_int1=:grpId  GROUP BY d.rm_id",nativeQuery=true)
	List<StoreStockDetail> getMonthWiseSoreStock(@Param("fromDate")String fromDate,@Param("toDate")String toDate,@Param("grpId")int grpId);

	
	
	 
     
	List<StoreStockDetail> findByStoreStockId(int storeStockId);

}
