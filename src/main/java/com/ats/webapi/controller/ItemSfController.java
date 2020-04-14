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
import com.ats.webapi.model.SellBillDataCommon;
import com.ats.webapi.model.rawmaterial.GetItemSfHeader;
import com.ats.webapi.model.rawmaterial.GetSfType;
import com.ats.webapi.model.rawmaterial.ItemSfDetail;
import com.ats.webapi.model.rawmaterial.ItemSfHeader;
import com.ats.webapi.model.rawmaterial.SfItemDetailList;
import com.ats.webapi.repository.ItemSfDetailRepo;
import com.ats.webapi.repository.ItemSfHeaderRepository;
import com.ats.webapi.repository.SfTypeRepository;
import com.ats.webapi.service.rawmaterial.ItemSfService;
import com.ats.webapi.repository.ItemSfHeaderRepo;;

@RestController
public class ItemSfController {
	
	@Autowired
	ItemSfService itemSfService;
	
	@Autowired
	ItemSfHeaderRepo itemSfHeaderRepo;
	
	@Autowired
	SfTypeRepository sfTypeRepository;
	
	@Autowired
	ItemSfHeaderRepository  getItemSfHeaderRepo;
	
	@Autowired
	ItemSfDetailRepo itemSfDetailRepo;

	@RequestMapping(value = { "/postSfItemHeader" }, method = RequestMethod.POST)
	public @ResponseBody Info postSfItemHeader(@RequestBody ItemSfHeader itemSfHeader) {
		
		Info info =new Info();
		try {
				ItemSfHeader header = itemSfService.saveHeader(itemSfHeader);
			
				if(header!=null) {
					
					info.setError(false);
					info.setMessage("Sf Header Inserted Successfully");
				}
				else {
					
					info.setError(true);
					info.setMessage(" Error:Sf Header insert failed");
				}
			
		}catch (Exception e) {
			
			System.out.println("Exce in itemSf insert Rest controller "+e.getMessage());
			e.printStackTrace();
		}
	
	return info;
		
	  }
	@RequestMapping(value = { "/deleteSfItem" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteSfItem(@RequestParam("sfId") int sfId) {
		
		Info info =new Info();
		try {
				int delete = itemSfHeaderRepo.deleteSfItem(sfId);
			
				if(delete!=1) {
					
					info.setError(false);
					info.setMessage("Sf Header Inserted Successfully");
				}
				else {
					
					info.setError(true);
					info.setMessage(" Error:Sf Header insert failed");
				}
			
		}catch (Exception e) {
			
			System.out.println("Exce in itemSf delete Rest controller "+e.getMessage());
			e.printStackTrace();
		}
	
	return info;
		
	  }
	
	
	@RequestMapping(value = { "/postSfItemDetail" }, method = RequestMethod.POST)
	public @ResponseBody Info postSfItemDetail(@RequestBody List<ItemSfDetail> itemSfDetailList) {
		
		Info info =new Info();
		
		System.out.println("size of input object "+itemSfDetailList.size());
		System.out.println("input ="+itemSfDetailList.toString());
		
		try {
				info=itemSfService.saveDetail(itemSfDetailList);
				
				if(!info.isError()) {
					
					info.setError(false);
					info.setMessage("Sf Detail Inserted Successfully");
				}
				else {
					
					info.setError(true);
					info.setMessage(" Error:Sf Detail insert failed");
				}
			
		}catch (Exception e) {
			
			System.out.println("Exce in itemSf insert Rest controller "+e.getMessage());
			e.printStackTrace();
		}
	
	return info;
		
	  }
	
	
	@RequestMapping(value = { "/getSfType" }, method = RequestMethod.POST)
	public @ResponseBody List<GetSfType> getSfType(@RequestParam("delStatus") int delStatus) {
		
		List<GetSfType> sfTypeList=null;
		
		try {
			
			sfTypeList=sfTypeRepository.findByDelStatus(delStatus);
		
		}catch (Exception e) {
			
			System.out.println("Exe getting Sf Type "+e.getMessage());
			e.printStackTrace();
		}
		
	return sfTypeList;
	
	}
	
	
	@RequestMapping(value = { "/getItemSfHeaderList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetItemSfHeader> getItemSfHeader(@RequestParam("delStatus")int delStatus) {
		
		List<GetItemSfHeader> sfHeader=new ArrayList<GetItemSfHeader>();
		
		try {
			
			sfHeader=getItemSfHeaderRepo.getSfItemHeader(delStatus);
		}catch (Exception e) {
			
			System.out.println("Exe getting Sf Item Header  "+e.getMessage());
			e.printStackTrace();
		}
		
	return sfHeader;
	
	}
	
	
	@RequestMapping(value = { "/getSfItemDetailList" }, method = RequestMethod.POST)
	public @ResponseBody SfItemDetailList getSfItemDetailList(@RequestParam("delStatus")int delStatus,
			@RequestParam("sfId")int sfId) {
		
		SfItemDetailList itemDetails=new SfItemDetailList();
		
		try {
			
		List<ItemSfDetail>	itemList=itemSfDetailRepo.findByDelStatusAndSfId(delStatus, sfId);
		
		itemDetails.setSfItemDetail(itemList);
		}catch (Exception e) {
			
			System.out.println("Exe getting Sf Item Details  "+e.getMessage());
			e.printStackTrace();
		}
		
	return itemDetails;
	
	}
	
}
