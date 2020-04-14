package com.ats.webapi.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.SellBillDataCommon;
import com.ats.webapi.model.SellBillDetail;
import com.ats.webapi.model.SellBillHeader;

@Repository
public interface ExpressBillRepository extends JpaRepository<SellBillHeader, Integer>{

	
	List<SellBillHeader> findByBillTypeAndGrandTotalAndFrId(char billType,float grandTotal,int frId);

	
	//function to get sellBillHeader to close a day
	SellBillHeader getBysellBillNo(int sellBillNo);
	
	
	//function to delete Sell Bill Header if its Details are empty 
	int deleteBySellBillNo(int sellBillNo);


	SellBillHeader findBySellBillNo(int billNo);

	//int deleteInBatch(int sellBillNo);

}
