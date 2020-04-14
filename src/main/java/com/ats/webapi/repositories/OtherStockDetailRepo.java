package com.ats.webapi.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ats.webapi.model.OtherItemStockDetail;

public interface OtherStockDetailRepo extends JpaRepository<OtherItemStockDetail, Integer> {

	@Query(value = "SELECT * FROM other_item_stock_detail WHERE other_stock_header_id=:otherStockHeaderId",nativeQuery=true)
	public @ResponseBody List<OtherItemStockDetail> getstockOtherDetailByHeaderId(@Param("otherStockHeaderId") int otherStockHeaderId);
	
	
	@Query(value = "SELECT * FROM other_item_stock_detail WHERE other_stock_header_id=:otherStockHeaderId",nativeQuery=true)
	public List<OtherItemStockDetail> getstockDetailByHeaderIdAndOtherItemId(@Param("otherStockHeaderId") int otherStockHeaderId);

	@Modifying
	@Transactional
	@Query(value = "UPDATE other_item_stock_detail SET opening_stock=:opnStock WHERE other_item_id=:item_id AND other_stock_header_id=:headId",nativeQuery=true)
	public int updateDetail(@Param("headId") int headId, @Param("item_id") int item_id, @Param("opnStock") int opnStock);
	
}
