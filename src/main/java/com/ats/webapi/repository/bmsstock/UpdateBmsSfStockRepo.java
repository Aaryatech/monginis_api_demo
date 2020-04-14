package com.ats.webapi.repository.bmsstock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.stock.UpdateBmsSfStock;

public interface UpdateBmsSfStockRepo extends JpaRepository<UpdateBmsSfStock, Integer> {
	
	@Transactional
	@Modifying
	@Query(" UPDATE UpdateBmsSfStock  SET prodIssueQty=:prodIssueQty,prodRejectedQty=:prodRejectedQty,"
			+ " prodReturnQty=:prodReturnQty,mixingIssueQty=:mixingIssueQty,mixingRejectedQty=:mixingRejectedQty,"
			+ "bmsClosingStock=:bmsClosingStock"
			+ " WHERE bmsStockId=:bmsStockId AND sfId=:sfId")
		int updateBmsSfStock(@Param("bmsStockId") int bmsStockId,@Param("prodIssueQty") 
		float prodIssueQty,@Param("prodRejectedQty") float prodRejectedQty,
		@Param("prodReturnQty") float prodReturnQty,
		@Param("mixingIssueQty") float mixingIssueQty,
		@Param("mixingRejectedQty") float mixingRejectedQty,
		@Param("bmsClosingStock") float bmsClosingStock,@Param("sfId") int sfId);
}
