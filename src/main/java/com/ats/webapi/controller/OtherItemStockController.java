package com.ats.webapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.OtherItemStockDetail;
import com.ats.webapi.model.OtherItemStockHeader;
import com.ats.webapi.model.otheritemstock.OtherItemCurStock;
import com.ats.webapi.model.otheritemstock.OtherItemStockBet;
import com.ats.webapi.repositories.OtherStockDetailRepo;
import com.ats.webapi.repositories.OtherStockHeadRepo;
import com.ats.webapi.repository.othitmstock.OtherItemCurStockRepo;
import com.ats.webapi.repository.othitmstock.OtherItemStockBetRepo;

@RestController
public class OtherItemStockController {

	@Autowired
	OtherStockHeadRepo otherstockRepo;
	
	@Autowired
	OtherStockDetailRepo otherstockDetailRepo;
	
	@RequestMapping(value = { "/getOtherStockHeaderByFrId" }, method = RequestMethod.POST)
	public@ResponseBody List<OtherItemStockHeader> getOtherStockHeaderByFrId(@RequestParam("frId") int frId){
		System.out.println("FRID="+frId);
		List<OtherItemStockHeader> stockItemHeaderList = null;
		try {
				stockItemHeaderList = otherstockRepo.findAllByFrIdAndStatus(frId, 0);
		
				for(int i = 0 ; i < stockItemHeaderList.size() ; i++) {
					List<OtherItemStockDetail> stockItemDetailList = otherstockDetailRepo.getstockOtherDetailByHeaderId(stockItemHeaderList.get(i).getOtherStockHeaderId());
					stockItemHeaderList.get(i).setOtherItemStockList(stockItemDetailList);
					}
		
		}catch(Exception e){
			System.out.println(e);
		}
		System.err.println("Final List Found:"+stockItemHeaderList);
		return stockItemHeaderList;
		
	}
	
	
	@RequestMapping(value = { "/insertNewOtherStock" }, method = RequestMethod.POST)
	public@ResponseBody OtherItemStockHeader insertNewOtherStock(@RequestBody OtherItemStockHeader otherStockHeader){
		OtherItemStockHeader stockHead = new OtherItemStockHeader();
		try {
		System.out.println("New Header="+otherStockHeader);
		
		stockHead = otherstockRepo.save(otherStockHeader);
		
		if(stockHead!=null){
			for(int i=0; i < otherStockHeader.getOtherItemStockList().size();i++) {
				otherStockHeader.getOtherItemStockList().get(i).setOtherStockHeaderId(stockHead.getOtherStockHeaderId());
				
				
			}
			
			List<OtherItemStockDetail> stockDetails = otherstockDetailRepo.save(otherStockHeader.getOtherItemStockList());
			stockHead.setOtherItemStockList(stockDetails);
			
		
		}
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return stockHead;
		
	}
	
	@RequestMapping(value = { "/getStockHeaderByOtherStockHeaderIdAndOtherItemId" }, method = RequestMethod.POST)
	public@ResponseBody List<OtherItemStockDetail> getStockHeaderByHeaderId(@RequestParam("headerId") int headerId){
		List<OtherItemStockDetail> stockItemDetailList = null;
		try {
			
		System.out.println("headerId="+headerId);
					stockItemDetailList = otherstockDetailRepo.getstockDetailByHeaderIdAndOtherItemId(headerId);
						System.out.println("Stock Detail List101:"+stockItemDetailList);
					
			
		
		}catch(Exception e){
			System.out.println(e);
		}
		System.err.println("New List Found101:"+stockItemDetailList);
		return stockItemDetailList;
		
	}
	
	@RequestMapping(value = { "/updateOtherStockDetail" }, method = RequestMethod.POST)
	public@ResponseBody Info updateOtherStockDetail(@RequestParam int headId, @RequestParam int item_id, @RequestParam int opnStock) {
		Info info = new Info();
		System.out.println("HIO///"+headId+" "+item_id+" "+opnStock);
		int i = otherstockDetailRepo.updateDetail(headId, item_id, opnStock);
		if(i>0) {
			info.setError(false);
			info.setMessage("Sucess");
		}else {
			info.setError(true);
			info.setMessage("Fail");
		}
		return info;
		
	}
	
	
	//Sachin get Current Stock Of Other Items..
	
	
	@Autowired OtherItemCurStockRepo getOtherItemCurStockRepo;
	
	@RequestMapping(value = { "/getOtherItemCurStock" }, method = RequestMethod.POST)
	public@ResponseBody List<OtherItemCurStock> getOtherItemCurStock(@RequestParam("catId") int catId,
			@RequestParam("frId") int frId,@RequestParam("month") int month, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate){
		
		List<OtherItemCurStock> othItemCurStockList = new ArrayList<>();
		
		try {
			
			othItemCurStockList=getOtherItemCurStockRepo.getCurOtherItemCurStock(catId, month, frId, fromDate, toDate);
			
		
		}catch(Exception e){
			
			System.out.println(e);
		}
		
		System.err.println(" othItemCurStockList :"+othItemCurStockList);
		
		return othItemCurStockList;
		
	}
	
	//Sachin to get Stock Bet Date for other Items ie Cat ID 7
	
	@Autowired OtherItemStockBetRepo getOtherItemStockBetRepo;
	@RequestMapping(value = { "/getOtherItemStockBetDate" }, method = RequestMethod.POST)
	public@ResponseBody List<OtherItemCurStock> getOtherItemStockBetDate(@RequestParam("catId") int catId,
			@RequestParam("frId") int frId,@RequestParam("month") int month, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate,@RequestParam("prevFromDate") String prevFromDate,
			@RequestParam("prevToDate") String prevToDate){
		
		List<OtherItemCurStock> othItemCurStockList = new ArrayList<>();
		
		List<OtherItemStockBet> betDateList=new ArrayList<>();
		
		try {
			System.err.println("prevFromDate"+prevFromDate+"prevToDate"+prevToDate+"from date"+fromDate+"to Datte"+toDate);
			betDateList=getOtherItemStockBetRepo.getOtherItemStockBet(catId, month, frId, fromDate, toDate, prevFromDate, prevToDate);
			
			if(betDateList.size()>0) {
				
				for(int i=0;i<betDateList.size();i++) {
					
					OtherItemCurStock stock=new OtherItemCurStock();
					
					float tempOpen=(betDateList.get(i).getFirstOpening()+betDateList.get(i).getFirstPurchase())-(betDateList.get(i).getFirstSell());
					
					stock.setOpeningStock(tempOpen);
					
					stock.setSellQty(betDateList.get(i).getSellQty());
					stock.setDamagedStock(betDateList.get(i).getDamagedStock());
					stock.setFrName(betDateList.get(i).getFrName());
					stock.setId(betDateList.get(i).getId());
					stock.setItemId(""+betDateList.get(i).getItemId());
					stock.setItemName(betDateList.get(i).getItemName());
					stock.setPurchaseQty(betDateList.get(i).getPurchaseQty());
					
					othItemCurStockList.add(stock);
					
				}
				
			}
			
		
		}catch(Exception e){
			
			System.out.println(e);
		}
		
		System.err.println(" othItemCurStockList :"+othItemCurStockList);
		
		return othItemCurStockList;
		
	}
	
}
