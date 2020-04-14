package com.ats.webapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.stock.GetStoreCurrentStock;
import com.ats.webapi.model.stock.StoreStockDetail;
import com.ats.webapi.model.stock.StoreStockDetailList;
import com.ats.webapi.model.stock.StoreStockHeader;
import com.ats.webapi.service.storestock.StoreStockService;

@RestController
public class StoreStockApiController {

	@Autowired
	StoreStockService storeStockService;
	
	@RequestMapping(value = { "/insertStoreOpeningStock" }, method = RequestMethod.POST)
	public @ResponseBody StoreStockHeader insertStoreOpeningStock(@RequestBody StoreStockHeader storeStockHeader)
	{
		Info info=new Info();
		storeStockHeader=storeStockService.insertStoreOpStock(storeStockHeader);
		
		
		return storeStockHeader;
	}
	
	@RequestMapping(value = { "/getMonthWiseStoreStock" }, method = RequestMethod.POST)
	public @ResponseBody StoreStockDetailList getMonthWiseStoreStock(@RequestParam("fromDate")String fromDate, @RequestParam("toDate")String toDate,@RequestParam("grpId")int grpId) {
		
		System.out.println("Dates from "+fromDate+"  toDate  "+toDate+"  GrpId  "+grpId);
		StoreStockDetailList storeStockDetailList=new StoreStockDetailList();
		Info info=new Info();
		
		List<StoreStockDetail> 	resStoreStockDetailList=storeStockService.getMonthWiseStoreStock(fromDate,toDate,grpId);
		System.out.println("Return List"+resStoreStockDetailList.toString());
		
		
		if(resStoreStockDetailList!=null && !resStoreStockDetailList.isEmpty())
		{
			info.setError(false);
			info.setMessage("Success");
			storeStockDetailList.setStoreStockDetailList(resStoreStockDetailList);
		}
		else
		{
			info.setError(true);
			info.setMessage("Failed");
			storeStockDetailList.setStoreStockDetailList(resStoreStockDetailList);
		}
		storeStockDetailList.setInfo(info);
		return storeStockDetailList;
	}
	
	@RequestMapping(value = { "/getCurrentStoreStock" }, method = RequestMethod.POST)
	public @ResponseBody List<GetStoreCurrentStock> getCurrentStoreStock(@RequestParam("grpId")int grpId,@RequestParam("deptId")int deptId) {
	
		List<GetStoreCurrentStock> getStoreCurrentStockList=storeStockService.getCurrentStock(grpId,deptId);
		
		return getStoreCurrentStockList;
	}
	
	@RequestMapping(value = { "/getCurrentStoreStockHeader" }, method = RequestMethod.POST)
	public @ResponseBody StoreStockHeader getCurrentStoreStockHeader(@RequestParam("subCatId")int subCatId,@RequestParam("status")int status) {
		
		StoreStockHeader storeStockHeader = new StoreStockHeader();
		try
		{
			storeStockHeader=storeStockService.getCurrentStockHeader(subCatId,status);
			if(storeStockHeader==null)
			{
				storeStockHeader = new StoreStockHeader();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	
		 
		
		return storeStockHeader;
	}
}
