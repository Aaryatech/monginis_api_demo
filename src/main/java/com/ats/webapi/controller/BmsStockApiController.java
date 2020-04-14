package com.ats.webapi.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.BmsStockDetailed;
import com.ats.webapi.model.BmsStockHeader;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.stock.GetBmsStock;
import com.ats.webapi.repository.BmsStockDetailedRepository;
import com.ats.webapi.repository.bmsstock.GetBmsStockRepository;
import com.ats.webapi.service.bmsstock.BmsStockService;


@RestController
public class BmsStockApiController {
	
	@Autowired
	BmsStockService bmsStockService;
	 
	@Autowired
	BmsStockDetailedRepository bmsStockDetailedRepository;
	
	
	
	
	@RequestMapping(value = { "/getBmsStockDetail" }, method = RequestMethod.POST)
	public @ResponseBody List<BmsStockDetailed> getBmsStockDetail(@RequestParam("bmsStockId")int bmsStockId) {

		List<BmsStockDetailed> bmsStockDetailedList = new ArrayList<BmsStockDetailed>();
		try {

	
			bmsStockDetailedList = bmsStockDetailedRepository.findByBmsStockId(bmsStockId);
			
			if(bmsStockDetailedList!=null && !bmsStockDetailedList.isEmpty())
			{
				System.out.println("successfully  ");
			}
			

		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("Exce in bmsstock   " + e.getMessage());
		}

		return bmsStockDetailedList;

	}
	
	
	@RequestMapping(value = { "/insertBmsStock" }, method = RequestMethod.POST)
	public @ResponseBody BmsStockHeader insertBmsStock(@RequestBody BmsStockHeader bmsStockHeader) {

		BmsStockHeader bmsStockHeaderloc = new BmsStockHeader();
		try {

	
			bmsStockHeaderloc = bmsStockService.insertBmsStock(bmsStockHeader);
			
			if(bmsStockHeaderloc!=null)
			{
				System.out.println("successfully inserted");
			}
			

		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("Exce in bmsstock Insert " + e.getMessage());
		}

		return bmsStockHeaderloc;

	}
	
	@RequestMapping(value = { "/getBmsStockForEdit" }, method = RequestMethod.POST)
	public @ResponseBody BmsStockHeader getBmsStockForEdit(@RequestParam("type") int type) {

		BmsStockHeader bmsStockHeaderloc = new BmsStockHeader();
		try {

	
			bmsStockHeaderloc = bmsStockService.getBmsStockForEdit(type);
			
			 	System.out.println("bmsStockHeaderloc"+bmsStockHeaderloc);
			 	if(bmsStockHeaderloc ==null) {
					 bmsStockHeaderloc = new BmsStockHeader();
				}
			 	System.out.println("bmsStockHeaderloc"+bmsStockHeaderloc);
			} catch (Exception e) {
				 bmsStockHeaderloc = new BmsStockHeader();
			e.printStackTrace();
			System.out.println("Exce in bmsstock Insert " + e.getMessage());
		}

		return bmsStockHeaderloc;

	}
	
	@RequestMapping(value = { "/insertBmsStockDetailed" }, method = RequestMethod.POST)
	public @ResponseBody Info insertBmsStockDetailed(@RequestBody List<BmsStockDetailed> bmsStockDetailedlist) {

		Info info = new Info();
		try {
 
			for(int i=0;i<bmsStockDetailedlist.size();i++)
			{
				BmsStockDetailed bmsStockDetailed=bmsStockDetailedlist.get(i); 
				bmsStockDetailed=bmsStockDetailedRepository.save(bmsStockDetailed);
			}

		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("Exce in bmsstock Insert " + e.getMessage());
		}

		return info;

	}
	
	
	
	@RequestMapping(value = { "/getBmsStock" }, method = RequestMethod.POST)
	public @ResponseBody List<GetBmsStock> getBmsStock(@RequestParam("fromDate")String fromDate , @RequestParam("toDate")String toDate , @RequestParam("rmType")int rmType) {

		List<GetBmsStock> bmsStockDetailedList = new ArrayList<GetBmsStock>();
		try {

	
			bmsStockDetailedList = bmsStockService.getBmsStock(fromDate, toDate, rmType );
			
			if(bmsStockDetailedList!=null && !bmsStockDetailedList.isEmpty())
			{
				System.out.println("successfully  ");
			}
			

		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("Exce in bmsstock   " + e.getMessage());
		}

		return bmsStockDetailedList;

	}
	
	@Autowired
	GetBmsStockRepository getBmsStockRepository;
	
	@RequestMapping(value = { "/getBmsStockBetDateMonth" }, method = RequestMethod.POST)
	public @ResponseBody List<GetBmsStock> getBmsStockBetDateMonth(@RequestParam("fromDate")String fromDate , @RequestParam("toDate")String toDate , @RequestParam("rmType")int rmType,@RequestParam("bmsStatus") int bmsStatus) {

		List<GetBmsStock> bmsStockDetailedList = new ArrayList<GetBmsStock>();
		try {

			bmsStockDetailedList=getBmsStockRepository.getStockBetDateMonth(fromDate, toDate, rmType, bmsStatus);

		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("Exce in bmsstock bet date or month    " + e.getMessage());
		}

		return bmsStockDetailedList;

	}
	
	
	@RequestMapping(value = { "/getBmsStockHeader" }, method = RequestMethod.POST)
	public @ResponseBody BmsStockHeader getBmsStockHeader(@RequestParam("status")int status ,  @RequestParam("rmType")int rmType) {

		BmsStockHeader bmsStockHeader = new BmsStockHeader();
		try {

	System.out.println("status : "+status +"And rmType : "+rmType);
			bmsStockHeader = bmsStockService.getBmsStockHeader(status,  rmType );
			
			if(bmsStockHeader!=null )
			{
				System.out.println("successfully  ");
			}
			
System.out.println("Response from getBms Header  : "+bmsStockHeader.toString());
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("Exce in bmsstock   " + e.getMessage());
		}

		return bmsStockHeader;

	}

}
