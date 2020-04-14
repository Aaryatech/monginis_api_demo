package com.ats.webapi.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.ats.webapi.model.GetMaterialRecNoteList;
import com.ats.webapi.model.GetMaterialReceiptByDate;
import com.ats.webapi.model.GetTaxByRmId;
import com.ats.webapi.model.CheckSuppGst;
import com.ats.webapi.model.GetItemRateByRmIdAndSuppId;
import com.ats.webapi.model.GetTaxListByRmId;
import com.ats.webapi.model.ItemRateByRmIdAndSuppId;
import com.ats.webapi.model.MaterialRecNote;
import com.ats.webapi.repository.GetItemRateByRmIdAndSuppIdRepository;
import com.ats.webapi.repository.GetMaterialReceiptByDateRepository;
import com.ats.webapi.repository.GetSuppGstRepository;
import com.ats.webapi.repository.GetTaxListByRmIdRepository;
import com.ats.webapi.service.MaterialRcNote.MaterialRecNoteService;


@RestController
public class MaterialReceiptNoteController {

	@Autowired
	MaterialRecNoteService materialRecNoteService;
	
	@Autowired
	GetTaxListByRmIdRepository getTaxListByRmIdRepository;
	
	@Autowired
	GetSuppGstRepository getSuppGstRepository;
	
	@Autowired
	GetMaterialReceiptByDateRepository getMaterialReceiptByDateRepository;
	
	@Autowired
	GetItemRateByRmIdAndSuppIdRepository getItemRateByRmIdAndSuppIdRepository;
	
	@RequestMapping(value = { "/postMaterialRecNote" }, method = RequestMethod.POST)
	public @ResponseBody MaterialRecNote postMaterialRecNote(@RequestBody MaterialRecNote materialRecNote)
	{
		System.out.println("Input List :"+materialRecNote.toString());
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date utilCurrentDate = sf.parse(sf.format(new Date()));
			 SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");

			    Date now = new Date();

			    String strTime = sdfTime.format(now.getTime());
			    if(materialRecNote.getMrnId()==0) {
			materialRecNote.setGateEntryDate(utilCurrentDate);
			materialRecNote.setGateEntryTime(strTime);
			    }
		} catch (ParseException e) {

			e.printStackTrace();
		}
        
		System.out.println("Podate "+materialRecNote.getPoDate());
		MaterialRecNote materialRecNotes = materialRecNoteService.postMaterialRecNote(materialRecNote);
		System.out.println(materialRecNotes.toString());
		return materialRecNotes;

	}
	
	@RequestMapping(value = { "/getAllMaterialRecNotes" }, method = RequestMethod.POST)
	public @ResponseBody List<GetMaterialReceiptByDate> getAllMaterialRecNotes(@RequestParam("status")List<String> status,@RequestParam("fromDate")String fromDate,@RequestParam("toDate")String toDate,
			@RequestParam("flag")int flag)
	{
		List<GetMaterialReceiptByDate> getMaterialReceiptByDateGateEntry= new ArrayList<GetMaterialReceiptByDate>();
		try
		{
			System.out.println("Status : "+status);
			System.out.println("fromDate : "+fromDate);
			System.out.println("toDate : "+toDate);
			System.out.println("flag : "+flag);
			System.out.println("Status : "+status.toString());
			if(flag==0)
			{
				getMaterialReceiptByDateGateEntry  = getMaterialReceiptByDateRepository.getMaterialReceiptByDateGateEntry(status,fromDate,toDate);
				
			}
			else if(flag==1 || flag==2)
			{
				getMaterialReceiptByDateGateEntry  = getMaterialReceiptByDateRepository.getMaterialReceiptByDateStore(status,fromDate,toDate);
				
			}
			else if(flag==3)
			{
				getMaterialReceiptByDateGateEntry  = getMaterialReceiptByDateRepository.getMaterialReceiptByDateAcc(status,fromDate,toDate);
				
			}

					  }catch(Exception e)
		{
			e.printStackTrace();
		}


		return getMaterialReceiptByDateGateEntry;

	}
	
	 

	@RequestMapping(value = { "/getMaterialRecNotes" }, method = RequestMethod.POST)
	public @ResponseBody GetMaterialRecNoteList getMaterialRecNote(@RequestParam("status")List<String> status)
	{
		System.out.println("Status : "+status);
		System.out.println("Status : "+status.toString());
		GetMaterialRecNoteList materialRNoteResponse = materialRecNoteService.getMaterialRecNote(status);

		return materialRNoteResponse;

	}
	
	
	@RequestMapping(value = { "/getTaxByRmId" }, method = RequestMethod.POST)
	public @ResponseBody GetTaxListByRmId getTaxByRmId(@RequestParam("rmId")List<String> rmId)
	{
		GetTaxListByRmId getTaxListByRmId = new GetTaxListByRmId();
		List<GetTaxByRmId> getTaxByRmIdList = new ArrayList<GetTaxByRmId>();

		getTaxByRmIdList = getTaxListByRmIdRepository.GetTaxByRmIdlist(rmId);
		getTaxListByRmId.setGetTaxByRmIdList(getTaxByRmIdList);

		return getTaxListByRmId;

	}
	
	@RequestMapping(value = { "/CheckSuppGst" }, method = RequestMethod.POST)
	public @ResponseBody int CheckSuppGst(@RequestParam("suppId")int suppId)
	{

		CheckSuppGst checkSuppGst = getSuppGstRepository.checkSuppGst(suppId);
		
		String value = String.valueOf(checkSuppGst.getSettingValue());
		String gst = checkSuppGst.getSuppGstin();
		System.out.println("value "+value);
		System.out.println("gst "+gst);
		System.out.println("value "+gst.substring(0, 2));
		System.out.println("gst "+value.substring(0, 2));
		
		int flag = 0;
		if(gst.substring(0, 2).equals(value.substring(0, 2)))
		{
			flag=1;
		}
		

		return flag;

	}
	
	@RequestMapping(value = { "/getMaterialRecNotesHeaderDetails" }, method = RequestMethod.POST)
	public @ResponseBody MaterialRecNote getMaterialRecNotesHeaderDetails(@RequestParam("mrnId")int mrnId)
	{

		MaterialRecNote materialRecNoteRes = materialRecNoteService.getMaterialRecNotesHeaderDetails(mrnId);

		return materialRecNoteRes;

	}

	@RequestMapping(value = { "/getMaterialRecNotesHeaderDetailsNew" }, method = RequestMethod.POST)
	public @ResponseBody MaterialRecNote getMaterialRecNotesHeaderDetailsNew(@RequestParam("mrnId")int mrnId)
	{

		MaterialRecNote materialRecNoteRes = materialRecNoteService.getMaterialRecNotesHeaderDetailsNew(mrnId);

		return materialRecNoteRes;

	}
	
	@RequestMapping(value = { "/getRateByRmId" }, method = RequestMethod.POST)
	public @ResponseBody ItemRateByRmIdAndSuppId getRateByRmId(@RequestParam("rmId")List<String> rmId,@RequestParam("suppId")int suppId)
	{
		ItemRateByRmIdAndSuppId itemRateByRmIdAndSuppId = new ItemRateByRmIdAndSuppId();
		try
		{
			
			List<GetItemRateByRmIdAndSuppId> getItemRateByRmIdAndSuppId = new ArrayList<GetItemRateByRmIdAndSuppId>();

			getItemRateByRmIdAndSuppId = getItemRateByRmIdAndSuppIdRepository.getRateByRmId(rmId,suppId);
			itemRateByRmIdAndSuppId.setItemRateByRmIdAndSuppId(getItemRateByRmIdAndSuppId);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		

		return itemRateByRmIdAndSuppId;

	}
	
}
