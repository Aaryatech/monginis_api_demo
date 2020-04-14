package com.ats.webapi.repository.bmsstock;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.stock.FinishedGoodStock;

public interface FinishedGoodStockRepo   extends JpaRepository<FinishedGoodStock, Integer>{
	
	FinishedGoodStock save(FinishedGoodStock finishedGoodStock);
	
	FinishedGoodStock findByFinGoodStockStatus(int finGoodStockStatus);
	
	FinishedGoodStock findByFinGoodStockDate(Date stkDate);
	
}
