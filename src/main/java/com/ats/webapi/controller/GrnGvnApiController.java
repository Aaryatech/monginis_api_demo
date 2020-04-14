package com.ats.webapi.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.commons.Common;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.ItemSup;
import com.ats.webapi.model.grngvn.GrnGvnHeader;
import com.ats.webapi.model.grngvn.GrnGvnHeaderList;
import com.ats.webapi.repository.grngvnheader.GrnGvnHeaderRepo;

@RestController //created on 15 FEB
public class GrnGvnApiController {
	
	@Autowired
	GrnGvnHeaderRepo grnGvnHeaderRepo;
	
	
	
	
	
	@RequestMapping(value = { "/updateGrnGvnHeader" }, method = RequestMethod.POST)
	public @ResponseBody GrnGvnHeader updateGrnGvnHeader(@RequestBody GrnGvnHeader header) {

		GrnGvnHeader grnGvnHeaderRes = null;
		Info info = new Info();
		try {
			grnGvnHeaderRes=grnGvnHeaderRepo.save(header);
		}
		catch (Exception e) {
			System.out.println("Ex in GRN GVN HEADER UPDATE "+e.getMessage());
			e.printStackTrace();
		}
		return grnGvnHeaderRes;
	}
	
	
	@RequestMapping(value = { "/getGrnGvnHeader" }, method = RequestMethod.POST)
	public @ResponseBody GrnGvnHeaderList getGrnGvnHeader(@RequestParam("fromDate")String fromDate,@RequestParam("toDate")String toDate, @RequestParam("frIdList")
	List<String> frIdList,
			@RequestParam("isGrn")List<String> isGrn) {
		
		GrnGvnHeaderList headerList=new GrnGvnHeaderList();

		List<GrnGvnHeader> grnGvnHeaderList = new ArrayList<GrnGvnHeader>();

		try {
			
			Date fDate=Common.convertToSqlDate(fromDate);
			Date tDate=Common.convertToSqlDate(toDate);
			
			System.out.println("Parameter Received Specific Fr Grn Header List  = "+fDate+""+toDate+" "+frIdList+ ""+isGrn);
					
			grnGvnHeaderList = grnGvnHeaderRepo.findGrnGvnHeader(fDate, tDate, frIdList, isGrn);
			headerList.setGrnGvnHeader(grnGvnHeaderList);
			
			System.out.println(" GRN GVN Header LIST /getGrnGvnHeader "+headerList.toString());

			
		} catch (Exception e) {

			System.out.println("Exce in Getting getGrnGvnHeader /GrnGvnApiController " + e.getMessage());
			e.printStackTrace();
		}

		return headerList;
	}
	
	
	
	@RequestMapping(value = { "/getGrnGvnHeaderAllFr" }, method = RequestMethod.POST)
	public @ResponseBody GrnGvnHeaderList getGrnGvnHeaderAllFr(@RequestParam("fromDate")String fromDate,@RequestParam("toDate")String toDate,
			@RequestParam("isGrn")List<String> isGrn) {

		List<GrnGvnHeader> grnGvnHeaderList = new ArrayList<GrnGvnHeader>();
		
		GrnGvnHeaderList headerList=new GrnGvnHeaderList();


		try {
			
			Date fDate=Common.convertToSqlDate(fromDate);
			Date tDate=Common.convertToSqlDate(toDate);
					
			grnGvnHeaderList = grnGvnHeaderRepo.findGrnGvnHeaderAllFr(fDate, tDate, isGrn);
			headerList.setGrnGvnHeader(grnGvnHeaderList);
			System.out.println(" GRN GVN Header LIST /getGrnGvnHeaderAllFr "+headerList.toString());

		} catch (Exception e) {

			System.out.println("Exce in Getting getGrnGvnHeader /GrnGvnApiController " + e.getMessage());
			e.printStackTrace();
		}

		return headerList;
	}
	
	
	
	
	@RequestMapping(value = { "/findGrnGvnHeaderOnLoad" }, method = RequestMethod.POST)
	public @ResponseBody GrnGvnHeaderList findGrnGvnHeaderGateOnLoad(@RequestParam("fromDate")String fromDate,@RequestParam("toDate")String toDate,
			@RequestParam("isGrn") List<String> isGrn,
			@RequestParam("statusList") List<String> statusList) {
		GrnGvnHeaderList headerList=new GrnGvnHeaderList();

		List<GrnGvnHeader> grnGvnHeaderList = new ArrayList<GrnGvnHeader>();

		try {
			
			Date fDate=Common.convertToSqlDate(fromDate);
			Date tDate=Common.convertToSqlDate(toDate);
					System.out.println("Para ReCEived "+fDate+""+tDate +""+isGrn+""+ statusList);
			grnGvnHeaderList = grnGvnHeaderRepo.findGrnGvnHeaderOnLoad(isGrn, statusList);
			
			headerList.setGrnGvnHeader(grnGvnHeaderList);
			
			System.out.println("On Load GRN GVN LIST /findGrnGvnHeaderOnLoad "+headerList.toString());
		} catch (Exception e) {

			System.out.println("Exce in Getting findGrnGvnHeaderOnLoad /GrnGvnApiController " + e.getMessage());
			e.printStackTrace();
		}

		return headerList;
	}
	
	
	@RequestMapping(value = { "/getGrnGvnHeaderByHeaderId" }, method = RequestMethod.POST)
	public @ResponseBody GrnGvnHeaderList getGrnGvnHeaderByHeaderId(@RequestParam("frId")
	int frId,@RequestParam("grnGvnSrNo")
	String grnGvnSrNo,@RequestParam("isGrn")int isGrn) {
		
		GrnGvnHeaderList headerList=new GrnGvnHeaderList();
		
		List<GrnGvnHeader> grnGvnHeaderList = new ArrayList<GrnGvnHeader>();
		
		try {
			
			grnGvnHeaderList = grnGvnHeaderRepo.findByfrIdAndGrngvnSrnoAndIsGrn(frId, grnGvnSrNo, isGrn);
			headerList.setGrnGvnHeader(grnGvnHeaderList);
			
		} catch (Exception e) {

			System.out.println("Exce in Getting getGrnGvnHeader /GrnGvnApiController " + e.getMessage());
			e.printStackTrace();
		}

		return headerList;
		
	}
	
	
	@RequestMapping(value = { "/getHeaderByHeaderId" }, method = RequestMethod.POST)
	public @ResponseBody GrnGvnHeader getHeaderByHeaderId(@RequestParam("headerId")
	int headerId) {
		
		GrnGvnHeader responseHeader=new GrnGvnHeader();
		try {
			
			responseHeader = grnGvnHeaderRepo.findByGrnGvnHeaderId(headerId);
			
		} catch (Exception e) {

			System.out.println("Exce in Getting getHeaderByHeaderId /GrnGvnApiController " + e.getMessage());
			e.printStackTrace();
		}

		return responseHeader;
		
	}
	@RequestMapping(value = { "/updateGrnGvnDate" }, method = RequestMethod.POST)
	public @ResponseBody Info updateGrnGvnDate(@RequestParam int grnGvnHeaderId,@RequestParam String grnGvnDate) {

		int isUpdated =grnGvnHeaderRepo.updateGrnGvnDate(grnGvnHeaderId,grnGvnDate);
		Info info=new Info();
		if(isUpdated>=1)
		{
			info.setError(false);
			info.setMessage("GrnGvnDate Updated");
		}
		else
		{
			info.setError(true);
			info.setMessage("GrnGvnDate Not Updated");
		}
		return info;
	}
}
