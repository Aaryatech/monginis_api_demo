package com.ats.webapi.repository.bmsstock;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.stock.UpdateBmsStock;


public interface UpdateBmsStockRepo extends JpaRepository<UpdateBmsStock, Integer> {
	
	@Transactional
	@Modifying
	@Query(" UPDATE UpdateBmsStock  SET prodIssueQty=:prodIssueQty,prodRejectedQty=:prodRejectedQty,"
			+ " prodReturnQty=:prodReturnQty,mixingIssueQty=:mixingIssueQty,mixingRejectedQty=:mixingRejectedQty,"
			+ "mixingReturnQty=:mixingReturnQty,storeIssueQty=:storeIssueQty,storeRejectedQty=:storeRejectedQty,"
			+ "bmsClosingStock=:bmsClosingStock,mixingReceiveRejectedQty=:mixingReceiveRejectedQty,"
			+ "mixingRecQty=:mixingRecQty"
			+ " WHERE bmsStockId=:bmsStockId AND rmId=:rmId")
		int updateBmsRmStock(@Param("bmsStockId") int bmsStockId,@Param("prodIssueQty") 
		float prodIssueQty,@Param("prodRejectedQty") float prodRejectedQty,
		@Param("prodReturnQty") float prodReturnQty,
		@Param("mixingIssueQty") float mixingIssueQty,
		@Param("mixingRejectedQty") float mixingRejectedQty,
		@Param("mixingReturnQty") float mixingReturnQty,
		@Param("storeIssueQty") float storeIssueQty,
		@Param("storeRejectedQty") float storeRejectedQty,
		@Param("bmsClosingStock") float bmsClosingStock,@Param("rmId") int rmId,
		@Param("mixingReceiveRejectedQty") float mixingReceiveRejectedQty,@Param("mixingRecQty") float mixingRecQty);
	
}
