package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.PostFrItemStockDetail;
public interface PostFrOpStockDetailRepository extends JpaRepository<PostFrItemStockDetail, Integer> {
	
	PostFrItemStockDetail save(PostFrItemStockDetail postFrItemStockDetail);
	
	@Query(value="SELECT  m_fr_opening_stock_detail.opening_stock_detail_id , m_fr_opening_stock_detail.opening_stock_header_id ,  m_fr_opening_stock_detail.item_id ,m_fr_opening_stock_detail.reg_opening_stock,"
			+ "m_fr_opening_stock_detail.sp_opening_stock, m_fr_opening_stock_detail.physical_stock, m_fr_opening_stock_detail.stock_difference, m_fr_opening_stock_detail.reg_total_purchase , "
			+ "m_fr_opening_stock_detail.sp_total_purchase, m_fr_opening_stock_detail.reg_total_grn_gvn, m_fr_opening_stock_detail.reg_total_sell, m_fr_opening_stock_detail.sp_total_sell, m_fr_opening_stock_detail.remark"
			+ " FROM m_fr_opening_stock_detail"
			+ " WHERE m_fr_opening_stock_detail.opening_stock_header_id =:headerId",nativeQuery=true)
	List<PostFrItemStockDetail> getFrDetail(@Param("headerId")int headerId);
	 
	@Query(value = "SELECT  m_fr_opening_stock_detail.* "
			+ "FROM m_fr_opening_stock_detail "
			+ " WHERE m_fr_opening_stock_detail.item_id=:itemId AND m_fr_opening_stock_detail.opening_stock_header_id " + 
			" IN(SELECT m_fr_opening_stock_header.opening_stock_header_id FROM m_fr_opening_stock_header WHERE m_fr_opening_stock_header.fr_id=:frId "
			+ " AND m_fr_opening_stock_header.month=:currentMonth AND m_fr_opening_stock_header.year=:year AND m_fr_opening_stock_header.cat_id=:catId )", nativeQuery = true)
	PostFrItemStockDetail getOpeningStock(@Param("frId") int frId,@Param("currentMonth") int currentMonth, @Param("year") int year,@Param("itemId") int itemId ,@Param("catId") int catId);
	
	@Query(value = "SELECT  m_fr_opening_stock_detail.* FROM m_fr_opening_stock_detail  WHERE m_fr_opening_stock_detail.item_id=:itemId AND m_fr_opening_stock_detail.opening_stock_header_id " + 
					" IN(SELECT m_fr_opening_stock_header.opening_stock_header_id FROM m_fr_opening_stock_header WHERE m_fr_opening_stock_header.fr_id=:frId AND " + 
					" m_fr_opening_stock_header.cat_id=:catId AND m_fr_opening_stock_header.is_month_closed= 0 )", nativeQuery = true)
	PostFrItemStockDetail getCurrentOpeningStock(@Param("frId") int frId,@Param("itemId") int itemId ,@Param("catId") int catId);

	PostFrItemStockDetail findByOpeningStockHeaderIdAndItemId(int openingStockHeaderId, int parseInt);
//4 jan 2019
	PostFrItemStockDetail findByItemIdAndOpeningStockHeaderId(int id, int openingStockHeaderId);
	
}
